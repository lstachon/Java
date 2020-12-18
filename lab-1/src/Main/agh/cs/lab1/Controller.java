package agh.cs.lab1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

import javafx.scene.canvas.GraphicsContext;

public class Controller {

    @FXML
    public void startSimulation1(ActionEvent actionEvent){

    }

//        public Grid grid;
//        private final GraphicsContext context;
//        private int frameRate;
//        private float interval;
//        private boolean running;
//        private boolean paused;
//        private boolean keyIsPressed;
//
//        public Controller(final Grid grid, final GraphicsContext context) {
//            this.grid = grid;
//            this.context = context;
//            frameRate = 20;
//            interval = 1000.0f / frameRate; // 1000 ms in a second
//            running = true;
//            paused = false;
//            keyIsPressed = false;
//        }
//
//        @Override
//        public void run() {
//            while (running && !paused) {
//                // Time the update and paint calls
//                float time = System.currentTimeMillis();
//
//                keyIsPressed = false;
//                grid.update();
//                Painter.paint(grid, context);
//
//                if (!grid.getSnake().isSafe()) {
//                    pause();
//                    Painter.paintResetMessage(context);
//                    break;
//                }
//
//                time = System.currentTimeMillis() - time;
//
//                // Adjust the timing correctly
//                if (time < interval) {
//                    try {
//                        Thread.sleep((long) (interval - time));
//                    } catch (InterruptedException ignore) {
//                    }
//                }
//            }
//        }

//        public void stop() {
//            running = false;
//        }
//
//        public boolean isKeyPressed() {
//            return keyIsPressed;
//        }
//
//        public void setKeyPressed() {
//            keyIsPressed = true;
//        }
//
//        public void resume() {
//            paused = false;
//        }
//
//        public void pause() {
//            paused = true;
//        }
//
//        public boolean isPaused() {
//            return paused;
//        }
//
//        public int getFrameRate() {
//            return frameRate;
//        }
//
//        public void setFrameRate(int frameRate) {
//            this.frameRate = frameRate;
//        }
//    }




}
