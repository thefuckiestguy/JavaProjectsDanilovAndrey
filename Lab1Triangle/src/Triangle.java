import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;
public class Triangle
{
    Dote[] dotes;
    private double AB;
    private double BC;
    private double AC;

    static ArrayList<Triangle> rectTriangles = new ArrayList();
    static ArrayList<Triangle> isoTriangles = new ArrayList();
    static ArrayList<Triangle> equaltTriangles = new ArrayList();
    static ArrayList<Triangle> randomTriangles = new ArrayList();

    public Triangle(Dote[] dotes)
    {
        this.dotes = dotes;
        this.AB = Math.sqrt(Math.pow((dotes[1].GetX() - dotes[0].GetX()), 2)
                + Math.pow((dotes[1].GetY() - dotes[0].GetY()), 2));
        this.BC = Math.sqrt(Math.pow((dotes[2].GetX() - dotes[1].GetX()), 2)
                + Math.pow((dotes[2].GetY() - dotes[1].GetY()), 2));
        this.AC = Math.sqrt(Math.pow((dotes[2].GetX() - dotes[0].GetX()), 2)
                + Math.pow((dotes[2].GetY() - dotes[0].GetY()), 2));
    }

    @Override
    public String toString()
    {
        String triangleStr = "";
        for (var dote : this.dotes)
        {
            triangleStr += dote.toString() + " ";
        }
        return this.InterperetationTriangle() + triangleStr;
    }

    public double CalculateSquare()
    {
        return (0.5) * Math.abs(this.dotes[0].GetX() * (this.dotes[1].GetY() - this.dotes[2].GetY())
                + this.dotes[1].GetX() * (this.dotes[2].GetY() - this.dotes[0].GetY()) +
                this.dotes[2].GetX() * (this.dotes[0].GetY() - this.dotes[1].GetY()));
    }

    public double CalculatePerimeter()
    {
        return this.AB + this.BC + this.AC;
    }

    public String InterperetationTriangle()
    {
        if (this.AB == Math.sqrt(Math.pow(this.BC, 2) + (Math.pow(this.AC, 2))) ||
                this.BC == Math.sqrt(Math.pow(this.AB, 2) + (Math.pow(this.AC, 2))) ||
                this.AC == Math.sqrt(Math.pow(this.BC, 2) + (Math.pow(this.AB, 2))))
        {
            return "Rectangular";
        }
        if (this.AB == this.BC || this.AB == this.AC || this.AC == this.BC)
        {
            if (this.AB == this.BC && this.AB == this.AC && this.BC == this.AB)
            {
                return "Equilateral";
            }
            return "Isosceles";
        }
        if (this.AB != this.BC && this.AC != this.AB && this.AC != this.BC)
        {
            return "Random";
        }

        return "It's not a triangle";
    }

    public void PrintTriangle()
    {
        System.out.printf("%s Triangle with cooridinates " + this.toString() + "\n", this.InterperetationTriangle());
        System.out.println("S = " + this.CalculateSquare());
        System.out.println("P = " + this.CalculatePerimeter());
    }
    public void FillGroups()
    {
        if (Objects.equals(this.InterperetationTriangle(), "Rectangular"))
        {
            rectTriangles.add(this);
        }
        if (Objects.equals(this.InterperetationTriangle(), "Equilateral"))
        {
            equaltTriangles.add(this);
        }
        if (Objects.equals(this.InterperetationTriangle(), "Isosceles"))
        {
            isoTriangles.add(this);
        }
        if (Objects.equals(this.InterperetationTriangle(), "Random"))
        {
            randomTriangles.add(this);
        }
    }

    public static Triangle GetMaxTriangle(ArrayList<Triangle> triangles)
    {
        try
        {
            double minSquare = triangles.get(0).CalculateSquare();
        } catch (IndexOutOfBoundsException ex)
        {
            System.out.println("Size = 0");
            return null;
        }
        double maxSquare = 0;
        Triangle maxTriangle = null;
        for (Triangle triangle : triangles)
        {
            if (triangle.CalculateSquare() > maxSquare)
            {
                maxSquare = triangle.CalculateSquare();
                maxTriangle = triangle;
            }
        }
        return maxTriangle;
    }

    public static Triangle GetMinTriangle(ArrayList<Triangle> triangles)
    {
        try
        {
            double minSquare = triangles.get(0).CalculateSquare();
        } catch (IndexOutOfBoundsException ex)
        {
            System.out.println("Size = 0");
            return null;
        }
        double minSquare = Double.MAX_VALUE;
        Triangle minTriangle = null;
        for (Triangle triangle : triangles)
        {
            if (triangle.CalculateSquare() < minSquare)
            {
                minSquare = triangle.CalculateSquare();
                minTriangle = triangle;
            }
        }
        return minTriangle;
    }
}




