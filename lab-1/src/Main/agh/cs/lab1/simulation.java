package agh.cs.lab1;

import com.sun.jdi.LongValue;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.PickResult;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

import java.awt.*;
import java.io.IOException;
import java.rmi.server.ExportException;

public class simulation extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    boolean showHoverCursor = false;

    int rows = 40;
    int columns = 40;
    double width = 250;
    double height = 250;
    double maxheight = 400;
    double maxwidth = 600;
    boolean flag = true;


    @Override
    public void start(Stage primaryStage) throws IOException {

        Pane root = (Pane) FXMLLoader.load(simulation.class.getResource ("simulation_view.fxml"));

        Pane rootwindow = (Pane) root.lookup("#rootnode");

        StackPane root1 = (StackPane) root.lookup("#simulation1window");
        StackPane root2 = (StackPane) root.lookup("#simulation2window");
        Pane animalStatistics1 = (Pane) root.lookup("#staticStatistic1");


            String family = "Helvetica";
            double size = 8;

            TextFlow textFlow = new TextFlow();
            textFlow.setLayoutX(4);
            textFlow.setLayoutY(4);
            Text text1 = new Text("Most popular Gene: \n\n");
            text1.setFont(Font.font(family, FontPosture.ITALIC, size));
            Text text2 = new Text("Animals ammount: \n\n");
            text2.setFont(Font.font(family, FontPosture.ITALIC, size));
            Text text3 = new Text(" Grass ammount: \n\n");

            text3.setFont(Font.font(family, FontPosture.ITALIC, size));
            textFlow.getChildren().addAll(text1, text2, text3);

            Group group = new Group(textFlow);

            animalStatistics1.getChildren().add(group);

            MouseGestures mg = new MouseGestures();


            Grid grid = new Grid(columns, rows, width, height);

            // fill grid
            for (int row = 0; row < rows; row++) {
                for (int column = 0; column < columns; column++) {

                    Cell cell = new Cell(column, row);


                    mg.makePaintable(cell);

                    grid.add(cell, column, row);
                }
            }

            Grid grid2 = new Grid(columns, rows, width, height);

            // fill grid
            for (int row = 0; row < rows; row++) {
                for (int column = 0; column < columns; column++) {

                    Cell cell = new Cell(column, row);


                    mg.makePaintable(cell);

                    grid2.add(cell, column, row);
                }
            }

            root1.getChildren().addAll(grid);

            root2.getChildren().addAll(grid2);


            Scene scene = new Scene(rootwindow, maxwidth, maxheight);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            primaryStage.setScene(scene);

        primaryStage.show();

    }



    public class MouseGestures {

        public void makePaintable( Node node) {


            // that's all there is needed for hovering, the other code is just for painting
            if( showHoverCursor) {
                node.hoverProperty().addListener(new ChangeListener<Boolean>(){

                    @Override
                    public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {

                        System.out.println( observable + ": " + newValue);

                        if( newValue) {
                            ((Cell) node).hoverHighlight();
                        } else {
                            ((Cell) node).hoverUnhighlight();
                        }

                        for( String s: node.getStyleClass())
                            System.out.println( node + ": " + s);
                    }

                });
            }

            node.setOnMousePressed( onMousePressedEventHandler);
            node.setOnDragDetected( onDragDetectedEventHandler);
            node.setOnMouseDragEntered(onMouseDragEnteredEventHandler);

        }

        EventHandler<MouseEvent> onMousePressedEventHandler = event -> {

            Cell cell = (Cell) event.getSource();
            System.out.println(cell.column+" "+cell.row);
            if( event.isPrimaryButtonDown()) {
                cell.highlight();
            } else if( event.isSecondaryButtonDown()) {
                cell.unhighlight();
            }
        };

        EventHandler<MouseEvent> onMouseDraggedEventHandler = event -> {

            PickResult pickResult = event.getPickResult();
            Node node = pickResult.getIntersectedNode();

            if( node instanceof Cell) {

                Cell cell = (Cell) node;

                if( event.isPrimaryButtonDown()) {
                    cell.highlight();
                } else if( event.isSecondaryButtonDown()) {
                    cell.unhighlight();
                }

            }

        };

        EventHandler<MouseEvent> onMouseReleasedEventHandler = event -> {
        };

        EventHandler<MouseEvent> onDragDetectedEventHandler = event -> {

            Cell cell = (Cell) event.getSource();
            cell.startFullDrag();

        };

        EventHandler<MouseEvent> onMouseDragEnteredEventHandler = event -> {

            Cell cell = (Cell) event.getSource();

            if( event.isPrimaryButtonDown()) {
                cell.highlight();
            } else if( event.isSecondaryButtonDown()) {
                cell.unhighlight();
            }

        };

    }

}



