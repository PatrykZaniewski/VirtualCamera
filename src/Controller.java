import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;

import java.awt.event.MouseEvent;
import java.beans.EventHandler;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
    public Canvas canvas;

    @FXML
    public void initialize() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, 650, 650);
        gc.setStroke(Color.WHITE);
        gc.beginPath();

        File A = new File("src/sample/data.txt");
        Scanner scannerA;

        int i = 0;
        try {
            scannerA = new Scanner(A);
            while (scannerA.hasNext()) {
                String line = scannerA.nextLine();
                line = line.replace("\\s+", "");

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        gc.moveTo(30.5, 30.5);
        gc.lineTo(150.5, 30.5);
        gc.lineTo(150.5, 150.5);
        gc.lineTo(30.5, 30.5);
        gc.stroke();
        canvas.setOnMouseClicked(e -> {
            double x = e.getX() - 315.0;
            double y = e.getY() - 315.0;
            System.out.println("[" + x +", " + y + "]");
        });
    }

}
