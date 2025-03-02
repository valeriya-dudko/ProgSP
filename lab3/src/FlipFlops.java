public class FlipFlops extends Sandals{
    public FlipFlops(int coverage, String color, int size)
    {
        super(coverage, color, size);
    }


    @Override
    public String Brand()
    {
        return "Неизвестный бренд вьтнамок";
    }

    @Override
    public String toString()
    {
        return "Размер: " + size + "\nЦвет: " + color + "\nЗакрытость: " + coverage + "%"
            + "\nБренд: " + Brand();
    }

    @Override
    public void printInfo()
    {
        System.out.println(toString());
    }

    @Override
    public int hashCode()
    {
        int hash = 5;
        hash = 29 * hash + this.color.hashCode();
        hash = 29 * hash + this.coverage;
        hash = 29 * hash + this.size;
        return hash;
    }
}
