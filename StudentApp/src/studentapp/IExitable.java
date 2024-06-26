/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package studentapp;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 *
 * @author jason
 */
public interface IExitable {
    
    @FXML
    default void exitClick(){
        Alert alert = new Alert (Alert.AlertType.CONFIRMATION, "Are you sure you want to Close?");
        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                System.out.println("Exiting application...");
                
                //Save the data to file(s)
                CourseAddFXMLController.saveCoursesToFile();
                AddStudentFXMLController.saveStudentToFile();
                EnrolmentAddFXMLController.saveEnrolmentsToFile();
                Platform.exit();
            }
        });
    }
    
}
