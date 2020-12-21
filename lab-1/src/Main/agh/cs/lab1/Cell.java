package agh.cs.lab1;

import javafx.scene.layout.StackPane;

public class Cell extends StackPane {

    int column;
    int row;

    public Cell(int column, int row) {

        this.column = column;
        this.row = row;

        getStyleClass().add("cell");


        setOpacity(0.9);
    }


    public String toString() {
        return this.column + "/" + this.row;
    }
}