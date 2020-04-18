package Logic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Reader {
    public ArrayList<Rectangle3D> readData(){
        File A = new File("data.txt");
        Scanner scannerA;
        ArrayList<Rectangle3D> rectangle3DList = new ArrayList<>();
        try {
            scannerA = new Scanner(A);
            while (scannerA.hasNext()) {
                Rectangle3D rectangle3D = new Rectangle3D();
                String line = scannerA.nextLine();
                line = line.replace("\\s+", "");
                String[] array = line.split(";");
                ArrayList<Point3D> point3DS = new ArrayList<>();
                for(String string: array){
                    String[] coord = string.split(",");
                    double x = Double.parseDouble(coord[0]);
                    double y = Double.parseDouble(coord[1]);
                    double z = Double.parseDouble(coord[2]);
                    Point3D point3D = new Point3D(x, y, z);
                    point3DS.add(point3D);
                }
                //TODO rozwazyc inne figury
                rectangle3D.setPoint3DList(point3DS);
                rectangle3DList.add(rectangle3D);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return rectangle3DList;
    }
}
