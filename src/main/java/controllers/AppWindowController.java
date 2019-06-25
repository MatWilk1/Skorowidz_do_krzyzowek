package controllers;

import java.io.FileNotFoundException;
import java.io.IOException;

import model.DialogWindow;
import model.Main;
import model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class AppWindowController {
	
	private Model model = new Model();
	
    @FXML
    private Label labelFile;
	
	@FXML
	void initialize() throws FileNotFoundException {
		if(Model.getFile() != null) {
			labelFile.setText("Wczytany plik: " + Model.getFile().getName());
		}
		else {
			labelFile.setText("Wczytany plik: brak pliku");
		}
	}
	
	@FXML
    void exit(ActionEvent event) {
    	
    	DialogWindow.dialogExit();
    }
    
    @FXML
    void switchToMainWindow(ActionEvent event) throws IOException {
    	Main.setRoot("/fxml/MainWindow.fxml");
    }
    
    @FXML
    void switchToAppWindowAdd(ActionEvent event) throws IOException {
    	Main.setRoot("/fxml/AppWindowAdd.fxml");
    }
    
    @FXML
    void switchToAppWindowShow(ActionEvent event) throws IOException {
    	Main.setRoot("/fxml/AppWindowShow.fxml");
    }
    
    @FXML
    void openFile(ActionEvent event) throws FileNotFoundException {
    	
    	labelFile.setText("Wczytany plik: " + model.openFile().getName());
    }
    
    @FXML
    void createFile(ActionEvent event) throws IOException {
    	labelFile.setText("Wczytany plik: " + model.createFile().getName());
    }

}
