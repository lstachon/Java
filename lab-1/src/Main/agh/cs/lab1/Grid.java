package agh.cs.lab1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

public class Grid extends Pane {

    int rows;
    int columns;
    double width;
    double height;
    IWorldMap map;
    double jungleRatio;


    Cell[][] cells;

    public Grid( int columns, int rows, double width, double height, IWorldMap map, double jungleRatio) {

        this.columns = columns;
        this.rows = rows;
        this.width = width;
        this.height = height;
        this.map = map;
        this.jungleRatio = jungleRatio;
        cells = new Cell[rows][columns];

        MouseGestures mg = new MouseGestures(this.map);


        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {

                Cell cell = new Cell(column, row);

                if (map.isInJungle(new Vector2d(row,column))){
                    cell.setStyle("-fx-background-color: #009933;");
                }
                mg.makePaintable(cell);

                this.add(cell, column, row);
            }
        }


        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {

                Object object = map.objectAt(new Vector2d(row,column));


                if(object != null) {
                    if (object instanceof LinkedList) {
                        if (((LinkedList<?>) object).getFirst() instanceof Animal) {
                            this.cells[row][column].setStyle("-fx-background-color: #ffb366;");
                        }
                    }
                }
            }
        }

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {

                Object object = map.objectAt(new Vector2d(row,column));


                if(object != null) {
                    if (object instanceof Grass) {
                            this.cells[row][column].setStyle("-fx-background-color: #66ff33;");

                    }
                }
            }
        }

    }

    public void nextday() throws InterruptedException {
            for (int row = 0; row < rows; row++) {
                for (int column = 0; column < columns; column++) {

                    if (map.isInJungle(new Vector2d(row, column))) {
                        this.cells[row][column].setStyle("-fx-background-color: #009933;");
                    } else {
                        this.cells[row][column].setStyle("-fx-background-color: #663300;");
                    }

                }
            }

            for (Vector2d v : map.getGrassMap().keySet()) {
                this.cells[v.x][v.y].setStyle("-fx-background-color: #66ff33;");
            }


        for (LinkedList<Animal> animalList : this.map.getAnimalsMap().values()) {
            if (animalList != null) {
                for(Animal a: animalList){
                    if(animalList.size()>1){
                        this.cells[a.getPosition().x][a.getPosition().y].setStyle("-fx-background-color: #a84e32;");
                    }
                    if(animalList.size()==1){
                        if(a.getEnergy()>0.5*this.map.getMaxEnergy()){
                            this.cells[a.getPosition().x][a.getPosition().y].setStyle("-fx-background-color: #ffb366;");
                        }
                        if(a.getEnergy()<0.5*this.map.getMaxEnergy() && a.getEnergy()>0.25*this.map.getMaxEnergy()){
                            this.cells[a.getPosition().x][a.getPosition().y].setStyle("-fx-background-color: #FF5733;");
                        }
                        if(a.getEnergy()<0.25*this.map.getMaxEnergy()){
                            this.cells[a.getPosition().x][a.getPosition().y].setStyle("-fx-background-color: #581845;");
                        }
                    }

                }
            }

        }

            this.map.nextDay();

            Thread.sleep(30);

        }



//    public void update() {
//        if (food.getPoint().equals(snake.getHead())) {
//            snake.extend();
//            food.setPoint(getRandomPoint());
//        } else {
//            snake.move();
//        }
//    }


    public void add(Cell cell, int column, int row) {

        cells[row][column] = cell;

        double w = width / columns;
        double h = height / rows;
        double x = w * column;
        double y = h * row;

        cell.setLayoutX(x);
        cell.setLayoutY(y);
        cell.setPrefWidth(w);
        cell.setPrefHeight(h);
        getChildren().add(cell);

    }

    public Cell getCell(int column, int row) {
        return cells[row][column];
    }

    public void unhighlight() {
        for( int row=0; row < rows; row++) {
            for( int col=0; col < columns; col++) {
                cells[row][col].unhighlight();
            }
        }
    }
}