/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package studentapp;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author jason
 */
public class EnrolmentAddFXMLController implements Initializable {
    
    public static final String FILE_NAME = "enrolments.txt";

    @FXML
    private ComboBox<Student> studentComboBox;
    @FXML
    private ComboBox<Course> courseComboBox;
    @FXML
    private Button addEnrolmentsButton;
    @FXML
    private Button clearAllEnrolmentButton;
    @FXML
    private Button returnToMainMenu;
    
    static ArrayList<Enrolment> enrolmentsArrayList = new ArrayList<Enrolment>();
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //studentComboBox.getItems().addAll("Zé", "Pitomba", "Caroço");
        
        for (Student s: AddStudentFXMLController.studentsArrayList){
        studentComboBox.getItems().addAll(s);
        }
        studentComboBox.setOnAction(e -> printSelectedStudent());
        
    
        for (Course c: CourseAddFXMLController.coursesArrayList){
        courseComboBox.getItems().addAll(c);
        }
        courseComboBox.setOnAction(e -> printSelectedStudent());
        
    }    

    @FXML
    private void addEnrolmentsButtonHandler(ActionEvent event) {
        //printSelectedStudent();

        try{
        Enrolment e = new Enrolment(studentComboBox.getValue(), courseComboBox.getValue());
                
                enrolmentsArrayList.add(e);
        
        JOptionPane.showMessageDialog(null, "Success: Student course enrolment created:" + "\n" + 
                "' " + e.toString());
        }
        catch(StudentException err){
            JOptionPane.showMessageDialog(null,"Error: Please, select a student an a course.");
        }
    }

    @FXML
    private void clearAllEnrolmentButtonHandler(ActionEvent event) {
    }

    @FXML
    private void returnToMainMenuHandler(ActionEvent event) throws Exception {
        Utility.changeToScene(getClass(), event, "FXMLApp.fxml");
    }
    
    private void printSelectedStudent(){
        System.out.println("Student: " + studentComboBox.getValue() +
        ", Course: " + courseComboBox.getValue());
    }
    
        public static void saveEnrolmentsToFile(){
            try(Formatter outFile = new Formatter(FILE_NAME)){
            
                for (Enrolment e: enrolmentsArrayList){
                    outFile.format(e.toStringWithLineBreak());
                }
            }catch(Exception err){
                System.out.println("Error: file could not be saved: '" + FILE_NAME + "'."); 
                JOptionPane.showMessageDialog(null, "Error: file could not be saved: '" + FILE_NAME + "'.");
            }
        }
    
    public static void loadEnrolmentsFromFile(){
            try(Scanner inFile = new Scanner(new FileReader(FILE_NAME)))
            {
                while(inFile.hasNext() == true){
                    
                    int studId = Integer.parseInt(inFile.nextLine());
                    
                    Student stud = null;
                    
                    for(int k = 0; k < AddStudentFXMLController.studentsArrayList.size(); k++){
                        if(studId == AddStudentFXMLController.studentsArrayList.get(k).getStudId()) {
                            stud = AddStudentFXMLController.studentsArrayList.get(k);
                            k = AddStudentFXMLController.studentsArrayList.size(); //Exit Loop, stoping when find the first occurence.
                        }
                    }
                    
                    String courseCode = inFile.nextLine();
                    
                    Course course = null;

                    for(int k = 0; k < CourseAddFXMLController.coursesArrayList.size(); k++){
                        if(courseCode.equalsIgnoreCase(CourseAddFXMLController.coursesArrayList.get(k).getCode()) == true){
                            
                            course = CourseAddFXMLController.coursesArrayList.get(k);
                            k = CourseAddFXMLController.coursesArrayList.size(); //Exit Loop, stoping when find the first occurence.
                        }
                    }                    
                    
                    
                    Enrolment e = new Enrolment(stud, course);
                    enrolmentsArrayList.add(e);
                }
            }
            catch(NumberFormatException | CourseException err){
                //JOptionPane.showMessageDialog(null,err.getMessage());
                JOptionPane.showMessageDialog(null, "Error: invalid data, file could not be loaded: '" +
                                                                                FILE_NAME + "'." + "\n\n" + err.getMessage());
            }
            catch(FileNotFoundException err){
                //Do nothing. File does not yest exist, so this is fine.
            }
            
            catch(Exception err){
                    System.out.println("Error: file could not be loaded: '" + FILE_NAME + "'.");
                    JOptionPane.showMessageDialog(null, "Error: file could not be loaded: '" + FILE_NAME + "'.");
                    }
            }
}
