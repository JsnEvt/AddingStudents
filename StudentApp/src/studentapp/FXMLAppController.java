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

/**
 * FXML Controller class
 *
 * @author jason
 */
public class FXMLAppController implements Initializable {

    @FXML
    private Button addAStudentButton;
    @FXML
    private Button dispalyAllStudentsButton;
    @FXML
    private Button addCourseButton;
    @FXML
    private Button displayAllCoursesButton;
    @FXML
    private Button exitButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void addAStudentButtonHandler(ActionEvent event) throws Exception {
            Utility.changeToScene(getClass(), event, "AddStudentFXML.fxml");
    }

    @FXML
    private void dispalyAllStudentsButtonHandler(ActionEvent event) {
    }

    @FXML
    private void addCourseButtonHandler(ActionEvent event) {
    }

    @FXML
    private void displayAllCoursesButtonHandler(ActionEvent event) {
    }

    @FXML
    private void exitButtonHandler(ActionEvent event) {
    }
    
}
