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
public class CourseDisplayAllFXMLController implements Initializable {

    @FXML
    private Button returnToMainMenuButton;
    @FXML
    private TextArea courseTextArea;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        String outStr = "   Code        Name          " + "\n" + 
                        "   _________   _____________ " + "\n" ;
        for (Course c: CourseAddFXMLController.coursesArrayList){
            outStr += c.toString() + "\n";
        }
        
        outStr += "->" + CourseAddFXMLController.coursesArrayList.size() + 
                "  courses found." + "\n";
        
        courseTextArea.setText(outStr);
        
        courseTextArea.setFont(new Font("Courier New", 12));
        
        courseTextArea.setEditable(false);
    }    

    @FXML
    private void returnToMainMenuButtonHandler(ActionEvent event) throws Exception {
        Utility.changeToScene(getClass(), event, "FXMLApp.fxml");
    }
    
}
