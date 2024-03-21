/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package studentapp;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

/**
 * FXML Controller class
 *
 * @author jason
 */
public class EnrolmentAddFXMLController implements Initializable {

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
        printSelectedStudent();

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
}
