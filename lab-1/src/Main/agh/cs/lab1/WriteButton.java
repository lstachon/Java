package agh.cs.lab1;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;

import java.io.File;
import java.io.FileWriter;

public class WriteButton {

    IWorldMap map;

    public WriteButton(IWorldMap map){
        this.map = map;
    }

    public void makePaintable(Node node) {

        node.setOnMousePressed( onMousePressedEventHandler);
    }

    EventHandler<MouseEvent> onMousePressedEventHandler = event -> {
        try{
            String path = new File("").getAbsolutePath();
            FileWriter fw = new FileWriter(path+"/lab-1/src/Main/agh/cs/lab1/statistic.txt");
            fw.write(map.toFile());
            fw.close();
        }catch(Exception e){System.out.println(e);}

    };



}





