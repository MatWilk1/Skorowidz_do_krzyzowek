package model;

import java.util.Optional;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

public class DialogWindow {
	

	public static Optional<ButtonType> dialogExit() {
		Alert alertExit = new Alert(AlertType.CONFIRMATION);
		alertExit.setTitle("Zamykanie");
		alertExit.setHeaderText("Zamykanie aplikacji");
		alertExit.setContentText("Czy na pewno chcesz zamknąć aplikację?");

		Optional<ButtonType> result = alertExit.showAndWait();
		
		if(result.get() == ButtonType.OK) {
			Platform.exit();
		}
		
		return result;
	}
	
	public static void dialogLackOfFile() {
		Alert alertExit = new Alert(AlertType.INFORMATION);
		alertExit.setTitle("Brak pliku");
		alertExit.setHeaderText("Żaden plik nie został wczytany");
		alertExit.setContentText("Aby dodać lub wyświetlić hasła musisz wczytać plik");

		alertExit.showAndWait();
	}

	public static void dialogEmptyWord() {
		Alert alertExit = new Alert(AlertType.INFORMATION);
		alertExit.setTitle("Brak hasła lub opisu");
		alertExit.setHeaderText("Nie podano hasła lub opisu");
		alertExit.setContentText("Aby dodać hasło musisz uzupełnić oba pola");

		alertExit.showAndWait();
	}

	public static void dialogWrongNumber() {
		Alert alertExit = new Alert(AlertType.INFORMATION);
		alertExit.setTitle("Błędna długośc hasła");
		alertExit.setHeaderText("Podana długość hasła nie jest liczbą całkowitą");
		alertExit.setContentText("Aby wyszukiwać po długości hasła musisz podać liczbę całkowitą");

		alertExit.showAndWait();
	}
	
	
}
