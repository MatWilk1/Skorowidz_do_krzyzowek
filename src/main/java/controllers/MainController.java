package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

import model.DialogWindow;
import model.Main;

public class MainController {

    @FXML
    public void switchToAppWindow() throws IOException {
        Main.setRoot("/fxml/AppWindow.fxml");
    }

    
    @FXML
    void exit(ActionEvent event) {
    	
    	DialogWindow.dialogExit();
    }
}
