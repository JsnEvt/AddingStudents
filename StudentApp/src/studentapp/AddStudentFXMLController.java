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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author jason
 */
public class AddStudentFXMLController implements Initializable {

    @FXML
    private TextField nameTextField;
    @FXML
    private TextField phoneTextField;
    @FXML
    private TextField emailTextField;
    @FXML
    private Button addStudentButton;
    @FXML
    private Button clearAllButton;
    @FXML
    private Button returnToMainMenuButton;
    @FXML
    private Label nameLabel;
    @FXML
    private Label phoneLabel;
    @FXML
    private Label emailLabel;
    
    
    static ArrayList<Student> studentsArrayList = new ArrayList<>();
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //studentsArrayList = new ArrayList<Student>();
    }    

    @FXML
    private void addStudentButtonHandler(ActionEvent event) throws Exception {
       boolean dataValid = true;
       
       String nameStr = nameTextField.getText().trim();
       String phoneStr =phoneTextField.getText().trim();
       String emailStr = emailTextField.getText().trim();
       
            
        try{
            Student s = new Student(nameStr, phoneStr, emailStr);
            studentsArrayList.add(s);
            JOptionPane.showMessageDialog(null, "Success: student created.");
        }
        catch (StudentException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }

    @FXML
    private void clearAllButtonHandler(ActionEvent event) {
        nameTextField.setText("");
        phoneTextField.setText("");
        emailTextField.setText("");
    }

    @FXML
    private void returnToMainMenuButtonHandler(ActionEvent event) throws Exception {
        Utility.changeToScene(getClass(), event, "FXMLApp.fxml");
    }
    
}
