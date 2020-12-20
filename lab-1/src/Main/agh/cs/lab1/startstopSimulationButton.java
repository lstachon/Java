package agh.cs.lab1;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.PickResult;

public class startstopSimulationButton {

    boolean showHoverCursor = false;

    IWorldMap map;

    public startstopSimulationButton(IWorldMap map){
        this.map = map;
    }

    public void makePaintable( Node node) {


        node.setOnMousePressed( onMousePressedEventHandler);
    }

    EventHandler<MouseEvent> onMousePressedEventHandler = event -> {

        this.map.changego();

    };

}