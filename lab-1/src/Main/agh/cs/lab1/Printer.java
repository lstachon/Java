package agh.cs.lab1;

import javafx.scene.canvas.GraphicsContext;

import java.util.LinkedList;

public class Printer implements Runnable {
    private final Grid grid;
    private int frameRate;
    private float interval;
    private boolean running;
    private boolean paused;
    private boolean keyIsPressed;
    private IWorldMap map;

    public Printer(final Grid grid, boolean button, IWorldMap map ) {
        this.grid = grid;
        frameRate = 20;
        interval = 1000.0f / frameRate; // 1000 ms in a second
        running = true;
        paused = false;
        this.keyIsPressed = button;
        this.map = map;
    }

    @Override
    public void run() {
        while (keyIsPressed) {
            // Time the update and paint calls
            float time = System.currentTimeMillis();


//            for (int row = 0; row < map.getWidth() ;row++) {
//                for (int column = 0; column < map.getHeight(); column++) {
//
//                    if (map.isInJungle(new Vector2d(row,column))){
//                        grid.cells[row][column].setStyle("-fx-background-color: #009933;");
//                    }
//                    else {
//                        grid.cells[row][column].setStyle("-fx-background-color: #663300;");
//                    }
//
//                }
//            }
//
//
//            for (LinkedList<Animal> animalList : this.map.getAnimalsMap().values()) {
//                System.out.println("beka"+animalList);
//                if (animalList != null) {
//                    for(int i=0; i<animalList.size(); i++){
//                        Animal a = animalList.get(i);
//                        Vector2d prev = a.getPosition();
//                        a.rotate();
//                        a.positionChanged(prev, a.getPosition(),a);
//                    }
//
//                }
//
//            }
//
//            for(Vector2d key: map.getAnimalsMap().keySet()) {
//                if(map.getAnimalsMap().get(key).size()==1) {
//                    grid.cells[key.x][key.y].setStyle("-fx-background-color: #ffb366;");
//                }
//                else{
//                    grid.cells[key.x][key.y].setStyle("-fx-background-color: #a84e32;");
//                }
//
//            }
//
//            for (Vector2d v : map.getGrassMap().keySet()) {
//                grid.cells[v.x][v.y].setStyle("-fx-background-color: #66ff33;");
//            }
//
//
//            this.map.subtractEnergy();
//            this.map.removeDeadAnimals();
//            this.map.addGrass();
//            time = System.currentTimeMillis() - time;
//
//            if (time < interval) {
//                try {
//                    Thread.sleep((long) (interval - time));
//                } catch (InterruptedException ignore) {
//                }
//            }
        }
    }

    public void stop() {
        running = false;
    }

    public boolean isKeyPressed() {
        return keyIsPressed;
    }

    public void setKeyPressed() {
        keyIsPressed = true;
    }

    public void resume() {
        paused = false;
    }

    public void pause() {
        paused = true;
    }

    public boolean isPaused() {
        return paused;
    }

    public int getFrameRate() {
        return frameRate;
    }

    public void setFrameRate(int frameRate) {
        this.frameRate = frameRate;
    }
}
