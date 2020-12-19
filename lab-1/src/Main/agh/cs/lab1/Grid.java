package agh.cs.lab1;

import javafx.scene.layout.Pane;

public class Grid extends Pane {

    int rows;
    int columns;
    double width;
    double height;
    IWorldMap map;


    Cell[][] cells;

    public Grid( int columns, int rows, double width, double height, IWorldMap map) {

        this.columns = columns;
        this.rows = rows;
        this.width = width;
        this.height = height;
        this.map = map;

        cells = new Cell[rows][columns];

        MouseGestures mg = new MouseGestures();

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {

                Cell cell = new Cell(column, row);

                Object object = map.objectAt(new Vector2d(row,column));

                if(object instanceof Animal){
                    getStyleClass().add("cellAnimal");
                }

                mg.makePaintable(cell);

                this.add(cell, column, row);
            }
        }

    }

//    public void update() {
//        if (food.getPoint().equals(snake.getHead())) {
//            snake.extend();
//            food.setPoint(getRandomPoint());
//        } else {
//            snake.move();
//        }
//    }


    /**
     * Add cell to array and to the UI.
     */
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

    /**
     * Unhighlight all cells
     */
    public void unhighlight() {
        for( int row=0; row < rows; row++) {
            for( int col=0; col < columns; col++) {
                cells[row][col].unhighlight();
            }
        }
    }
}