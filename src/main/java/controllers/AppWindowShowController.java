package controllers;

import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.collections.transformation.SortedList;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.DialogWindow;
import model.FileData;
import model.Main;
import model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class AppWindowShowController {

	@FXML
	private Label labelFile;

	@FXML
	private TextField filterWord;

	@FXML
	private TextField filterLong;

	@FXML
	private TableView<FileData> table;

	@FXML
	private TableColumn<FileData, String> tableWord;

	@FXML
	private TableColumn<FileData, String> tableDescription;


	@FXML
	void initialize() throws FileNotFoundException {
		if (Model.getFile() != null) {
			labelFile.setText("Wczytany plik: " + Model.getFile().getName());
		} else {
			labelFile.setText("Wczytany plik: brak pliku");
		}

		tableWord.setCellValueFactory(new PropertyValueFactory<>("word"));
		tableDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
	}
	
	@FXML
    void exit(ActionEvent event) {
    	
    	DialogWindow.dialogExit();
    }


	@FXML
	void switchToAppWindow(ActionEvent event) throws IOException {
		Main.setRoot("/fxml/AppWindow.fxml");
	}

	@FXML
	void showData(ActionEvent event) throws FileNotFoundException {

		if (Model.getFile() == null) {
			DialogWindow.dialogLackOfFile();
			return;
		}

		if(filterLong.getText().length() > 0 && !isNumber(filterLong.getText())){
			DialogWindow.dialogWrongNumber();
		}
		else{
			SortedList<FileData> sortedData = Model.filterObservableList(Model.convertTxtToObservableList(), filterWord.getText(), filterLong.getText());
			sortedData.comparatorProperty().bind(table.comparatorProperty());
			table.setItems(sortedData);
		}

	}

	public boolean isNumber(String text){
		try{
			Integer.parseInt(text);
		}catch(NumberFormatException | NullPointerException e){
			return false;
		}
		return true;
	}

}
