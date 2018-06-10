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
public class PrincipalController implements Initializable {
    
    @FXML
    private Button botonPlanTrabajo;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    @FXML
    public void cargarReporteCoordinador(){
        Stage stage = new Stage();
        Stage actualStage = (Stage) botonPlanTrabajo.getScene().getWindow();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("PagReporteDeCoordinador.fxml"));
            
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
    
    @FXML
    public void cargarPagPlanDeTrabajo(){
        Stage stage = new Stage();
        Stage actualStage = (Stage) botonPlanTrabajo.getScene().getWindow();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("PagPlanDeTrabajo.fxml"));
            
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
    
    @FXML
    public void cargarVisualizadorDocumento(){
        Stage stage = new Stage();
        Stage actualStage = (Stage) botonPlanTrabajo.getScene().getWindow();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("PagVisualizarDocumento.fxml"));
            
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
