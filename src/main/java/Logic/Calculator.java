package Logic;

import java.util.ArrayList;

public class Calculator {

    ArrayList<Rectangle3D> rectangle3DList;
    ArrayList<Rectangle2D> rectangle2DList;
    double distance = -200f;

    public Calculator(ArrayList<Rectangle3D> rectangle3DList){
        this.rectangle3DList = rectangle3DList;
    }


    public ArrayList<Rectangle2D> projection(){
        rectangle2DList = new ArrayList<>();
        for(Rectangle3D rectangle3D : rectangle3DList) {
            Rectangle2D rectangle2D = new Rectangle2D();
            ArrayList<Point2D> point2DList = new ArrayList<>();
            for (Point3D point3D : rectangle3D.getPoint3DList()) {
                double xp = ((point3D.getX() * distance) / (point3D.getZ() - distance)) + 325;
                double yp = ((point3D.getY() * distance) / (point3D.getZ() - distance)) + 325;
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

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public void changeDistance(double change){
        this.distance += change;
    }
}
