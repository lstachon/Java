package agh.cs.lab1;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.PickResult;

public class MouseGestures {

    boolean showHoverCursor = false;

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