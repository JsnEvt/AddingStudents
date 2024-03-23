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
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author jason
 */
public class CourseAddFXMLController implements Initializable {
    
    public static final String FILE_NAME = "courses.txt";

    @FXML
    private Button addButton;
    @FXML
    private Button clearAllButton;
    @FXML
    private Button returnToMainMenuButton;
    @FXML
    private TextField codeTextField;
    @FXML
    private TextField nameTextField;
    
    static ArrayList<Course> coursesArrayList = new ArrayList<Course>();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void addButtonHandler(ActionEvent event) {
        boolean dataValid = true;
       
       String codeStr = codeTextField.getText().trim();
       String nameStr = nameTextField.getText().trim();
       
       

        try {
            Course c = new Course(codeStr, nameStr);
            coursesArrayList.add(c);
            JOptionPane.showMessageDialog(null, "Success: course created.");
        }
        catch(CourseException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }

    @FXML
    private void clearAllButtonHandler(ActionEvent event) {
        codeTextField.setText("");
        nameTextField.setText("");
    }

    @FXML
    private void returnToMainMenuButtonHandler(ActionEvent event) throws Exception {
        Utility.changeToScene(getClass(), event, "FXMLApp.fxml");
    }
    
    public static void saveCoursesToFile(){
            try(Formatter outFile = new Formatter(FILE_NAME)){
            
                for (Course c: coursesArrayList){
                    outFile.format(c.toStringWithLineBreak());
                }
            }catch(Exception err){
                System.out.println("Error: file could not be saved: '" + FILE_NAME + "'."); 
                JOptionPane.showMessageDialog(null, "Error: file could not be saved: '" + FILE_NAME + "'.");
            }
        }
    
    public static void loadCoursesFromFile(){
            try(Scanner inFile = new Scanner(new FileReader(FILE_NAME)))
            {
                while(inFile.hasNext() == true){
                    Course c = new Course(inFile.nextLine(), inFile.nextLine());
                    coursesArrayList.add(c);
                }
            }
            catch(CourseException err){
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
