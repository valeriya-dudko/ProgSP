public abstract class Sandals implements Shoes, ShoeObject {
    protected int coverage; //in %
    protected String color;
    protected int size;

    public Sandals(int coverage, String color, int size)
    {
        this.coverage = coverage;
        this.color = color;
        this.size = size;
    }

    public String getColor()
    {
        return color;
    }
    public int getSize()
    {
        return size;
    }
    public int getCoverage()
    {
        return coverage;
    }
}
