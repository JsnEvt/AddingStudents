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
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author jason
 */
public class FXMLAppController implements Initializable, IExitable {

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
    @FXML
    private Button addCourseEnrolmentsButton;
    @FXML
    private Button addTestDataButton;
    @FXML
    private Button displayAllCoursesEnrolmentsButton;
    @FXML
    private Label headerLabel;

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
    private void dispalyAllStudentsButtonHandler(ActionEvent event) throws Exception {
        Utility.changeToScene((getClass()), event, "StudentDisplayAllFXML.fxml");

    }

    @FXML
    private void addCourseButtonHandler(ActionEvent event) throws Exception {
        Utility.changeToScene((getClass()), event, "CourseAddFXML.fxml");
    }

    @FXML
    private void displayAllCoursesButtonHandler(ActionEvent event) throws Exception {
        Utility.changeToScene((getClass()), event, "CourseDisplayAllFXML.fxml");
    }

    @FXML
    private void exitButtonHandler(ActionEvent event) {
        
        this.exitClick();
    }

    @FXML
    private void addCourseEnrolmentsButtonHandler(ActionEvent event) throws Exception {
        Utility.changeToScene (getClass(), event, "EnrolmentAddFXML.fxml");
    }

    @FXML
    private void addTestDataButtonHandler(ActionEvent event) throws Exception {
        // Create some Students
        AddStudentFXMLController.studentsArrayList.add(new Student("José", "123456", "js@gemail.com"));
        AddStudentFXMLController.studentsArrayList.add(new Student("Adilma", "654321", "as@gemail.com"));
        AddStudentFXMLController.studentsArrayList.add(new Student("Erlan", "632541", "es@gemail.com"));
        
        // Create some Courses
        CourseAddFXMLController.coursesArrayList.add(new Course("ADM6", "Administrador"));
        CourseAddFXMLController.coursesArrayList.add(new Course("MED8", "Medicina"));
        CourseAddFXMLController.coursesArrayList.add(new Course("TEC10", "Tecnologia"));
        
        //Create Enrolments
        EnrolmentAddFXMLController.enrolmentsArrayList.add(
                new Enrolment (AddStudentFXMLController.studentsArrayList.get(0),
                CourseAddFXMLController.coursesArrayList.get(0)));
    }

    @FXML
    private void displayAllCoursesEnrolmentsButtonHandler(ActionEvent event) throws Exception {
         Utility.changeToScene(getClass(), event, "EnrolmentDisplayAllFXML.fxml");
    }
    
}
