package Logic;

import java.util.ArrayList;

import static java.lang.Thread.sleep;

public class Calculator {

    private ArrayList<Rectangle3D> rectangle3DList;
    private ArrayList<Rectangle2D> rectangle2DList;

    double distance = -200f;

    public Calculator(ArrayList<Rectangle3D> rectangle3DList) {
        this.rectangle3DList = rectangle3DList;
    }

    public ArrayList<Rectangle2D> projection() {
        rectangle2DList = new ArrayList<>();
        for (Rectangle3D rectangle3D : rectangle3DList) {
            Rectangle2D rectangle2D = new Rectangle2D();
            ArrayList<Point2D> point2DList = new ArrayList<>();
            /*for (int i = 0; i < rectangle3D.getPoint3DList().size(); i++) {

                double x1, y1, z1;
                double x2, y2, z2;
                Point2D point2D1;
                Point2D point2D2;
                if(i == rectangle3D.getPoint3DList().size() - 1){
                    x1 = rectangle3D.getPoint3DList().get(i).getX();
                    y1 = rectangle3D.getPoint3DList().get(i).getY();
                    z1 = rectangle3D.getPoint3DList().get(i).getZ();
                    x2 = rectangle3D.getPoint3DList().get(0).getX();
                    y2 = rectangle3D.getPoint3DList().get(0).getY();
                    z2 = rectangle3D.getPoint3DList().get(0).getZ();
                }
                else
                {
                    x1 = rectangle3D.getPoint3DList().get(i).getX();
                    y1 = rectangle3D.getPoint3DList().get(i).getY();
                    z1 = rectangle3D.getPoint3DList().get(i).getZ();
                    x2 = rectangle3D.getPoint3DList().get(i + 1).getX();
                    y2 = rectangle3D.getPoint3DList().get(i + 1).getY();
                    z2 = rectangle3D.getPoint3DList().get(i + 1).getZ();
                }

                if(1 == 1){
                    double xp1 = ((x1 * distance) / (z1 > 1 ? z1 : 1)) + 325;
                    double yp1 = ((y1 * distance) / (z1 > 1 ? z1 : 1)) + 325;

                    double xp2 = ((x2 * distance) / (z2 > 1 ? z2 : 1)) + 325;
                    double yp2 = ((y2 * distance) / (z2 > 1 ? z2 : 1)) + 325;

                    point2D1 = new Point2D(xp1, yp1);
                    point2D2 = new Point2D(xp2, yp2);

                    point2DList.add(point2D1);
                    point2DList.add(point2D2);
                }
            }*/
            for (Point3D point3D : rectangle3D.getPoint3DList()) {
                double x = point3D.getX();
                double y = point3D.getY();
                double z = point3D.getZ();

                double xp = ((x * distance) / (z > 1 ? z : 1)) + 325;
                double yp = ((y * distance) / (z > 1 ? z : 1)) + 325;

                Point2D point2D = new Point2D(xp, yp);
                point2DList.add(point2D);
            }
            rectangle2D.setPoint2DList(point2DList);
            rectangle2DList.add(rectangle2D);
        }
        return rectangle2DList;
    }

    public ArrayList<Rectangle3D> getRectangle3DList() {
        return rectangle3DList;
    }

    public void setRectangle3DList(ArrayList<Rectangle3D> rectangle3DList) {
        this.rectangle3DList = rectangle3DList;
    }

    public ArrayList<Rectangle2D> getRectangle2DList() {
        return rectangle2DList;
    }

    public void setRectangle2DList(ArrayList<Rectangle2D> rectangle2DList) {
        this.rectangle2DList = rectangle2DList;
    }

    public void changeDistance(double change) {
        this.distance += change;
        if (this.distance < -1000) {
            this.distance = -1000;
        }
        if (this.distance > -20) {
            this.distance = -20;
        }
    }

    public void changeTranslation(double change, String axis) {
        for (Rectangle3D rectangle3D : this.rectangle3DList) {
            for (Point3D point3D : rectangle3D.getPoint3DList()) {
                switch (axis) {
                    case "x":
                        point3D.setX(point3D.getX() + change);
                        break;
                    case "y":
                        point3D.setY(point3D.getY() + change);
                        break;
                    case "z":
                        point3D.setZ(point3D.getZ() + change);
                        break;
                }
            }
        }
    }

    public void changeRotation(double change, String axis) {
        change = Math.toRadians(change);
        for (Rectangle3D rectangle3D : this.rectangle3DList) {
            for (Point3D point3D : rectangle3D.getPoint3DList()) {
                double x = point3D.getX();
                double y = point3D.getY();
                double z = point3D.getZ();
                switch (axis) {
                    case "x":
                        point3D.setY(Math.cos(change) * y - Math.sin(change) * z);
                        point3D.setZ(Math.sin(change) * y + Math.cos(change) * z);
                        break;
                    case "y":
                        point3D.setX(Math.cos(change) * x + Math.sin(change) * z);
                        point3D.setZ(-Math.sin(change) * x + Math.cos(change) * z);
                        break;
                    case "z":
                        point3D.setX(Math.cos(change) * x - Math.sin(change) * y);
                        point3D.setY(Math.sin(change) * x + Math.cos(change) * y);
                        break;
                }
            }
        }
    }
}
