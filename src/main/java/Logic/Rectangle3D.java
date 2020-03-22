package Logic;

import java.util.ArrayList;

public class Rectangle3D {
    ArrayList<Point3D> point3DList = new ArrayList<>();

    public Rectangle3D(Point3D p1, Point3D p2, Point3D p3, Point3D p4){
        point3DList.add(p1);
        point3DList.add(p2);
        point3DList.add(p3);
        point3DList.add(p4);
    }

    public Rectangle3D(){

    }


    public ArrayList<Point3D> getPoint3DList() {
        return point3DList;
    }

    public void setPoint3DList(ArrayList<Point3D> point3DList) {
        this.point3DList = point3DList;
    }
}
