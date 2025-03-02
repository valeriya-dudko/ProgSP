public class Boots implements Shoes, ShoeObject {
    private int heelSize;
    private String seasonType;
    private String color;
    private int size;

    public Boots(int heelSize, String seasonType, String color, int size)
    {
        this.heelSize = heelSize;
        this.seasonType = seasonType;
        this.color = color;
        this.size = size;

    }

    @Override
    public String Brand()
    {
        return "Неизвестный бренд сапог";
    }

    @Override
    public void printInfo()
    {
        System.out.println(toString());
    }

    @Override
    public String toString()
    {
        return "Размер: " + size + "\nЦвет: " + color + "\nСезон: " + seasonType + "\nКаблук: " + heelSize
                + "\nБренд: " + Brand();
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == null)
            return false;
        if (this == obj)
            return true;
        if (obj instanceof Boots)
        {
            Boots temp = (Boots) obj;
            return this.color.equals(temp.color) &&
                    this.seasonType.equals(temp.seasonType) &&
                    this.size == temp.size &&
                    this.heelSize == temp.heelSize;
        }
        else
            return false;
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 31 * hash + this.color.hashCode();
        hash = 31 * hash + this.seasonType.hashCode();
        hash = 31 * hash + this.size;
        hash = 31 * hash + this.heelSize;
        return hash;
    }
}
