public class Tankettes extends Sandals{

    public Tankettes(int coverage, String color, int size)
    {
        super(coverage, color, size);
    }

    @Override
    public String Brand()
    {
        return "Неизвестный бренд танкеток";
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
        int hash = 11;
        hash = 17 * hash + this.color.hashCode();
        hash = 17 * hash + this.coverage;
        hash = 17 * hash + this.size;
        return hash;
    }
}
