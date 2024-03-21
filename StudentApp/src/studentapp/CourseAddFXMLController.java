/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package studentapp;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
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
       
       
       if(dataValid == true){
           if(codeStr.length() == 0){
               JOptionPane.showMessageDialog(null, "Error: Code cannot be blank");
               dataValid = false;
           }
       }
       
       if(dataValid == true){
           if(nameStr.length() == 0){
               JOptionPane.showMessageDialog(null, "Error: Name cannot be blank");
               dataValid = false;
           }
       }
       
        
        if(dataValid == true) {
            Course c = new Course(codeStr, nameStr);
            coursesArrayList.add(c);
            JOptionPane.showMessageDialog(null, "Success: course created.");
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
 
}
