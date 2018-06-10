/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.fei.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * FXML Controller class
 *
 * @author adolf
 */
public class PagPlanDeTrabajoController implements Initializable {

    @FXML
    private Button botonCrear;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void crearPlanDeTrabajo(){
        Stage stage = new Stage();
        Stage actualStage = (Stage) botonCrear.getScene().getWindow();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("FormularioPlanDeTrabajo.fxml"));
            
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setOnCloseRequest((WindowEvent t) -> {
                Platform.exit();
                System.exit(0);
            });
            actualStage.close();
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
