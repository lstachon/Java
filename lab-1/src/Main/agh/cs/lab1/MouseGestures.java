package agh.cs.lab1;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.PickResult;

import java.util.LinkedList;

public class MouseGestures {

    IWorldMap map;

    public MouseGestures(IWorldMap map){
        this.map = map;
    }

    public void addEventHandler(Node node) {

        node.setOnMousePressed( onMousePressedEventHandler);
    }

    EventHandler<MouseEvent> onMousePressedEventHandler = event -> {

        Cell cell = (Cell) event.getSource();


        Object object = map.objectAt(new Vector2d(cell.row,cell.column));

        if(object != null){

            if(object instanceof LinkedList){
                if(((LinkedList<?>) object).getFirst() instanceof Animal){
                Animal a = map.getStrongest((LinkedList<Animal>) object);
                map.followAnimal(new Vector2d(cell.row, cell.column));
            }}}


    };


}