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
import javafx.scene.control.TextArea;
import javafx.scene.text.Font;

/**
 * FXML Controller class
 *
 * @author jason
 */
public class StudentDisplayAllFXMLController implements Initializable {

    @FXML
    private Button returnToMainMenyButton;
    @FXML
    private TextArea displayTextArea;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        String outStr = "   ID        Name                Phone           Email"           + "\n" + 
                        "   _______   _____________       ___________     _______________" + "\n" ;
        for (Student s: AddStudentFXMLController.studentsArrayList){
            outStr += s.toString() + "\n";
        }
        
        outStr += "->" + AddStudentFXMLController.studentsArrayList.size() + 
                "  students found." + "\n";
        
        displayTextArea.setText(outStr);
        
        displayTextArea.setFont(new Font("Courier New", 12));
        
        displayTextArea.setEditable(false);
    }    

    @FXML
    private void returnToMainMenyButtonHandler(ActionEvent event) throws Exception {
        Utility.changeToScene((getClass()), event, "FXMLApp.fxml");
    }
    
}
