package application.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.JButton;

import application.Model.Genio;
import application.Model.AppModel;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;



public class GuiController implements Initializable {

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtNacimiento;

    @FXML
    private Button btnGuardar;

    @FXML
    private TableView<Genio> tableData;

    @FXML
    private TableColumn<Genio, Number> colId;

    @FXML
    private TableColumn<Genio,String > colNombres;
    

    @FXML
    private TableColumn<Genio, Number> colNacimiento;

    @FXML
    private Button btnLimpiar;
    
    ObservableList<Genio> listData;
	AppModel genios = new AppModel();
  

	@Override
	public void initialize(URL url, ResourceBundle resources) {

		colId.setCellValueFactory((TableColumn.CellDataFeatures<Genio, Number> cellData) -> new SimpleIntegerProperty(
				cellData.getValue().getIdGenio()));

		colNombres.setCellValueFactory(
				(TableColumn.CellDataFeatures<Genio, String> cellData) -> new SimpleStringProperty(
						cellData.getValue().getNombre()));

		colNacimiento.setCellValueFactory((TableColumn.CellDataFeatures<Genio, Number> cellData) -> new SimpleIntegerProperty(
				cellData.getValue().getNacimiento()));

		listData = FXCollections.observableArrayList();
		this.listarGenios();
			
		tableData.getSelectionModel().clearSelection();
		listData = FXCollections.observableArrayList();
		tableData.setItems(listData);
	}
	
		

	

    @FXML
    void eventClickTable(MouseEvent event) {
    		
    }

    @FXML
    void eventGuardar(ActionEvent event) {
    	 String nombre = txtNombre.getText();
		 Integer nacimiento = Integer.valueOf(txtNacimiento.getText());
		 
		 

    }

    @FXML
    void eventLimpiar(ActionEvent event) {
    	txtNombre.setText("");
    	txtNacimiento.setText("");

    }

}
