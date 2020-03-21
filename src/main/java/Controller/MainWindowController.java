package Controller;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MainWindowController {

    public Canvas canvas;
    public AnchorPane anchor;
    long keyCooldown = 5 * 70000000;
    long lastTimePressed = 0;


    @FXML
    public void initialize() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, 650, 650);
        gc.setStroke(Color.WHITE);
        gc.beginPath();

        double distance = -200f;

        File A = new File("src/main/resource/data.txt");
        Scanner scannerA;

        int i = 0;
        try {
            scannerA = new Scanner(A);
            while (scannerA.hasNext()) {
                String line = scannerA.nextLine();
                line = line.replace("\\s+", "");
                String[] array = line.split(";");
                i = 0;
                double xstart = 0;
                double ystart = 0;
                for(String string: array){
                    String[] coord = string.split(",");
                    double x = Double.parseDouble(coord[0]);
                    double y = Double.parseDouble(coord[1]);
                    double z = Double.parseDouble(coord[2]);
                    double xp = ((x * distance ) / (z - distance)) + 325;
                    double yp = ((y * distance) / (z - distance )) + 325;
                    System.out.println(i + " " + x + " " + y + " " +z + " " + xp + " " + yp);

                    if(i == 0){
                        xstart = xp;
                        ystart = yp;
                        gc.moveTo(xp, yp);
                    }
                    else
                    {
                        gc.lineTo(xp, yp);
                    }
                    i++;
                }
                gc.lineTo(xstart, ystart);

                gc.stroke();

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        canvas.setOnMouseClicked(e -> {
            double x = e.getX() - 325.0;
            double y = e.getY() - 325.0;
            System.out.println("[" + x +", " + y + "]");
        });
        canvas.setFocusTraversable(true);
        canvas.setOnKeyTyped(this::keyPressed);
    }

    public void keyPressed(KeyEvent keyEvent){
        //TODO ten czas poprawic na mili moze
        if (System.nanoTime() - lastTimePressed > keyCooldown) {
            lastTimePressed = System.nanoTime();
            System.out.println(keyEvent.getCharacter());
        }
    }

}
