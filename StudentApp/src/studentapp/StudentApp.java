/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML.java to edit this template
 */
package studentapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author jason
 */
public class StudentApp extends Application implements IExitable {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLApp.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        
        stage.setOnCloseRequest(event -> {this.exitClick();
                                            event.consume(); 
    //event.consume() - para consumir o evento e nao ser usado em outra ocasiao inadequada;
        });
        System.out.println("StudentApp -> start..."); //procurando um local apropriado para carregar arquivos db.
        
        //Load the data from the file(s)...
        CourseAddFXMLController.loadCoursesFromFile();
        AddStudentFXMLController.loadStudentFromFile();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
