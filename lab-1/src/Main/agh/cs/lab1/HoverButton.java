package agh.cs.lab1;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;

public class HoverButton {

    IWorldMap map;
    public HoverButton(IWorldMap map){
        this.map = map;
    }

    public void addEventHandler(Node node) {
        node.setOnMousePressed( onMousePressedEventHandler);
    }

    EventHandler<MouseEvent> onMousePressedEventHandler = event -> {
        this.map.setHighlight();
    };


}