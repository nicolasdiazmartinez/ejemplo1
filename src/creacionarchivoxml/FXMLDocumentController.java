/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package creacionarchivoxml;

import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import modelo.Estudiante;

/**
 *
 * @author nicolas_ale.diaz
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label nombre;
     @FXML
    private Label telefono;
      @FXML
    private Label codigo;
       @FXML
    private Label carrera;
        @FXML
    private Label correo;
         @FXML
    private TextField  jnombre;
          @FXML
    private TextField jtelefono;
           @FXML
    private TextField jcodigo;
            @FXML
    private TextField jcarrera;
             @FXML
    private TextField jcorreo;
             
            LinkedList<Estudiante> listaE;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        String nombre = jnombre.getText();
         String telefono = jtelefono.getText();
          String correo = jcorreo.getText();
           String codigo = jcodigo.getText();
            String carrera = jcarrera.getText();
            
            Estudiante objE = new Estudiante (codigo,carrera,nombre,telefono,correo);
            listaE.add(objE);
        
    }
    
    @FXML
    private void guardarXML(ActionEvent event) {
        Estudiante objV = new Estudiante();
        
      boolean guardar = objV.crearArchivoXML(listaE);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
                         
}
