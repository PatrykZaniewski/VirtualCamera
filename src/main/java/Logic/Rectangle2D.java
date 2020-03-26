package Logic;

import java.util.ArrayList;

public class Rectangle2D {
    private ArrayList<Point2D> point2DList = new ArrayList<>();

    public Rectangle2D(Point2D p1, Point2D p2, Point2D p3, Point2D p4){
        point2DList.add(p1);
        point2DList.add(p2);
        point2DList.add(p3);
        point2DList.add(p4);
    }

    public Rectangle2D(){

    }


    public ArrayList<Point2D> getPoint2DList() {
        return point2DList;
    }

    public void setPoint2DList(ArrayList<Point2D> point2DList) {
        this.point2DList = point2DList;
    }
}
