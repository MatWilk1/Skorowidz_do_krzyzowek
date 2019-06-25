package model;

import javafx.beans.property.SimpleStringProperty;

public class FileData {

    private SimpleStringProperty word, description;


    public FileData(String word, String description) {
        this.word = new SimpleStringProperty(word);
        this.description = new SimpleStringProperty(description);
    }

    public String getWord() {
        return word.get();
    }

    public SimpleStringProperty wordProperty() {
        return word;
    }

    public void setWord(String word) {
        this.word.set(word);
    }

    public String getDescription() {
        return description.get();
    }

    public SimpleStringProperty descriptionProperty() {
        return description;
    }

    public void setDescription(String description) {
        this.description.set(description);
    }
}
