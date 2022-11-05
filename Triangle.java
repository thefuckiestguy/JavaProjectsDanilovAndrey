import java.util.Comparator;

public class Triangle
{
    Dote[] dotes;
    //   public double Square;
    //   public double Perimeter;

    private double AB;
    private double BC;
    private double AC;


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
        return triangleStr;
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
}


