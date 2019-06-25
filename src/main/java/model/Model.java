package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.function.Predicate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.stage.FileChooser;

public class Model {

	private static File file;

	public File openFile() throws FileNotFoundException {

		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Wybiesz plik");

		fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("TXT", "*.txt"));

		file = fileChooser.showOpenDialog(null);

		return file;
	}
	
	public File createFile() throws IOException {

		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Wybiesz lokalizację i nazwę nowego pliku");

		fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("TXT", "*.txt"));

		file = fileChooser.showSaveDialog(null);
		
		file.createNewFile();
		
		return file;
	}

	public static File getFile() {
		return file;
	}


	public void addWord(File file, String word, String description) throws IOException {

		if(file != null) {
			FileWriter fw = new FileWriter(file, true);
			fw.write("\r\n" + word + ";" + description);
			fw.close();
		}else {
			DialogWindow.dialogLackOfFile();
		}
	}


	public static ObservableList<FileData> convertTxtToObservableList() throws FileNotFoundException {
		ObservableList<FileData> obList = FXCollections.observableArrayList();
		Scanner fileScanner = new Scanner(file);

		while(fileScanner.hasNextLine()) {
			String line = fileScanner.nextLine();
			Scanner	stringScanner = new Scanner(line);
			stringScanner.useDelimiter(";");
			while(stringScanner.hasNext()) {
				obList.add(new FileData(stringScanner.next(), stringScanner.next()));
			}
		}
		return obList;
	}


	public static SortedList<FileData> filterObservableList(ObservableList<FileData> obList, String filterWord, String filterLong) {

		FilteredList<FileData> filteredList = new FilteredList<>(obList);
		SortedList<FileData> finalSortedList = new SortedList<>(filteredList);

		if (filterWord.length() != 0 && filterLong.length() != 0) {
			Predicate<FileData> containsText = i -> i.getWord().contains(filterWord);
			Predicate<FileData> wordLength = i -> i.getWord().length() == Integer.parseInt(filterLong);
			Predicate<FileData> filter = containsText.and(wordLength);

			filteredList.setPredicate(filter);
			return new SortedList<>(filteredList);
		}

		else if (filterWord.length() != 0) {
			Predicate<FileData> containsText = i -> i.getWord().contains(filterWord);

			filteredList.setPredicate(containsText);
			return new SortedList<>(filteredList);
		}

		else if(filterLong.length() != 0){
			Predicate<FileData> wordLength = i -> i.getWord().length() == Integer.parseInt(filterLong);

			filteredList.setPredicate(wordLength);
			return new SortedList<>(filteredList);
		}

		else {
			return finalSortedList;
		}

	}

}
