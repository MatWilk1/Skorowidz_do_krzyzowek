package controllers;

import java.io.FileNotFoundException;
import java.io.IOException;

import model.DialogWindow;
import model.Main;
import model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AppWindowAddController {

	private Model model = new Model();
	
    @FXML
    private TextField textWord;

    @FXML
    private TextField textDescription;

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
    void addNewWord(ActionEvent event) throws IOException {

		if(textWord.getText().length() !=0 && textDescription.getText().length() != 0){
			model.addWord(Model.getFile(), textWord.getText(), textDescription.getText());
			Main.setRoot("/fxml/AppWindow.fxml");
		}
    	else{DialogWindow.dialogEmptyWord();}


    }

    @FXML
    void switchToAppWindow(ActionEvent event) throws IOException {
    	Main.setRoot("/fxml/AppWindow.fxml");
    }
}
