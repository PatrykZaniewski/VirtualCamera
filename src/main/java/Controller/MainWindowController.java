package Controller;

import Logic.*;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MainWindowController {

    public Canvas canvas;
    public AnchorPane anchor;
    long keyCooldown = 5 * 10000000;
    long lastTimePressed = 0;
    public Calculator calculator;


    @FXML
    public void initialize() {
        Reader reader = new Reader();
        ArrayList<Rectangle3D> rectangle3DList = reader.readData();
        calculator = new Calculator(rectangle3DList);
        calculator.projection();
        draw(calculator.getRectangle2DList());


        canvas.setOnMouseClicked(e -> {
            double x = e.getX() - 325.0;
            double y = e.getY() - 325.0;
            System.out.println("[" + x +", " + y + "]");
        });

        canvas.setFocusTraversable(true);
        canvas.setOnKeyTyped(this::keyPressed);
    }

    public void draw(ArrayList<Rectangle2D> rectangle2DList){
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, 650, 650);
        gc.setStroke(Color.WHITE);
        gc.beginPath();
        for(Rectangle2D rectangle2D: rectangle2DList){
            int i = 0;
            double xstart = 0;
            double ystart = 0;
            for(Point2D point2D: rectangle2D.getPoint2DList()){
                if(i == 0){
                    xstart = point2D.getX();
                    ystart = point2D.getY();
                    gc.moveTo(point2D.getX(), point2D.getY());
                }
                else
                {
                    gc.lineTo(point2D.getX(), point2D.getY());
                }
                i++;
            }
            gc.lineTo(xstart, ystart);
            gc.stroke();
        }
    }

    public void keyPressed(KeyEvent keyEvent){
        //TODO ten czas poprawic na mili moze
        if (System.nanoTime() - lastTimePressed > keyCooldown) {
            lastTimePressed = System.nanoTime();
            System.out.println(keyEvent.getCharacter());
            calculator.changeDistance(-10);
            draw(calculator.projection());
        }
    }

}
