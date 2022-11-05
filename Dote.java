public class Dote
{
    private double x;
    private double y;

    public double GetX()
    {
        return this.x;
    }
    public double GetY()
    {
        return this.y;
    }

    public Dote(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString()
    {
    var s = "(" + this.x + ", " + this.y + ")";
        return s;
    }

}
