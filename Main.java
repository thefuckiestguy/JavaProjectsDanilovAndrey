import java.util.*;
import java.util.stream.Stream;


public class Main
{
    public static void main(String[] args)
    {

        Triangle[] triangles = new Triangle[]{new Triangle(new Dote[]{new Dote(2, 1), new Dote(2, 5),
                new Dote(5, 1)}), new Triangle(new Dote[]{new Dote(2, 1), new Dote(5, 5),
                new Dote(8, 1)}), new Triangle(new Dote[]{new Dote(4, 2), new Dote(4, 10),
                new Dote(10, 2)}), new Triangle(new Dote[]{new Dote(2, 1), new Dote(2, 5),
                new Dote(10, 2)}), new Triangle(new Dote[]{new Dote(5, 1), new Dote(2, 1),
                new Dote(3, 5)}), new Triangle(new Dote[]{new Dote(12, 6),
                new Dote(12, 30), new Dote(30, 6)})};

        for (int i = 0; i < triangles.length; i++)
        {
            System.out.print("#" + (i + 1) + " ");
            triangles[i].PrintTriangle();
        }

        for (var triangle:
             triangles)
        {
            triangle.FillGroups();
        }

        var MaxRectTriangle = Triangle.GetMaxTriangle(Triangle.rectTriangles);
        var MaxEquaTriangle = Triangle.GetMaxTriangle(Triangle.equaltTriangles);

        System.out.println(MaxEquaTriangle);

    }
}
