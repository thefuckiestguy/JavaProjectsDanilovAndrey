import java.util.*;
import java.util.stream.Stream;


public class Main
{
    static void PrintMaxMin(ArrayList<Triangle> triangles)
    {
        try
        {
            double maxSquare = triangles.get(0).CalculateSquare();
        }
        catch (IndexOutOfBoundsException ex){
            System.out.println("Size = 0");
            return;
        }
        double maxSquare = triangles.get(0).CalculateSquare();
        double maxPer = triangles.get(0).CalculatePerimeter();
        double minSquare = triangles.get(0).CalculateSquare();
        double minPer = triangles.get(0).CalculatePerimeter();

        System.out.println("Max and Min of " + triangles.get(0).InterperetationTriangle() + " triangles");

        double[] arrS = new double[triangles.size()];
        double[] arrP = new double[triangles.size()];

        for (int i = 0; i < arrS.length; i++){
            arrS[i] = triangles.get(i).CalculateSquare();
            arrP[i] = triangles.get(i).CalculatePerimeter();
        }

        double maxS = arrS[0];
        double minS = arrS[0];
        double maxP = arrP[0];
        double minP = arrP[0];


        int indexMaxS = 0;
        int indexMinS = 0;
        int indexMinP = 0;
        int indexMaxP =0;

        for (int i = 0; i < arrS.length;i++){
            if(maxS < arrS[i]){
                maxS = arrS[i];
                indexMaxS = i;
            }
            if(minS > arrS[i]){
                minS = arrS[i];
                indexMinS = i;
            }
            if(maxP < arrP[i]){
                maxP = arrP[i];
                indexMaxP = i;
            }
            if(minP > arrP[i]){
                minP = arrP[i];
                indexMinP = i;
            }
        }
        System.out.println("MaxSquare " + maxS+ "\nTriangle:\n" + triangles.get(indexMaxS));
        System.out.println("MinSquare " + minS+ "\nTriangle:\n"+ triangles.get(indexMinS));
        System.out.println("MaxPer " + maxP+ "\nTriangle:\n"+ triangles.get(indexMaxP));
        System.out.println("MinPer " + minP + "\nTriangle:\n"+ triangles.get(indexMinP));

    }

    public static void main(String[] args)
    {

        Triangle[] triangles = new Triangle[]
                {
                        new Triangle(new Dote[]{new Dote(2, 1), new Dote(2, 5), new Dote(5, 1)}),
                        new Triangle(new Dote[]{new Dote(2, 1), new Dote(5, 5), new Dote(8, 1)}),
                        new Triangle(new Dote[]{new Dote(4, 2), new Dote(4, 10), new Dote(10, 2)}),
                        new Triangle(new Dote[]{new Dote(2, 1), new Dote(2, 5), new Dote(10, 2)}),
                        new Triangle(new Dote[]{new Dote(5, 1), new Dote(2, 1), new Dote(3, 5)}),
                        new Triangle(new Dote[]{new Dote(12, 6), new Dote(12, 30), new Dote(30, 6)})
                };
        for (int i = 0; i < triangles.length; i++)
        {
            System.out.print("#" + (i + 1) + " ");
            triangles[i].PrintTriangle();
        }

        var rectTriangles = new ArrayList();
        var isoTriangles = new ArrayList();
        var equaltTriangles = new ArrayList();
        var randomTriangles = new ArrayList();

        for (var triangle : triangles)
        {
            if (triangle.InterperetationTriangle() == "Rectangular")
            {
                rectTriangles.add(triangle);
            }
            if (triangle.InterperetationTriangle() == "Equilateral")
            {
                equaltTriangles.add(triangle);
            }

            if (triangle.InterperetationTriangle() == "Isosceles")
            {
                isoTriangles.add(triangle);
            }
            if (triangle.InterperetationTriangle() == "Isosceles")
            {
                randomTriangles.add(triangle);
            }
            System.out.println(triangle);
        }

        System.out.println("Amount of Rectangular Triangles = " + rectTriangles.size());
        System.out.println("Amount of Equilateral Triangles = " + equaltTriangles.size());
        System.out.println("Amount of Isosceles Triangles = " + isoTriangles.size());
        System.out.println("Amount of Random Triangles = " + randomTriangles.size());

        var ListTriangles = new ArrayList<ArrayList<Triangle>>();
        ListTriangles.add(rectTriangles);
        ListTriangles.add(equaltTriangles);
        ListTriangles.add(isoTriangles);
        ListTriangles.add(randomTriangles);

        for (var triangles1:
             ListTriangles)
        {
            PrintMaxMin(triangles1);
        }
    }


}

//double[] arr = {1,2,2,344};







