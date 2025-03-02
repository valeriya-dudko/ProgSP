public class Sneakers implements Shoes, ShoeObject {
    private String soleType;
    private String companyMnfct;
    private String color;
    private int size;

    public Sneakers(int size, String soleType, String companyMnfct, String color)
    {
        this.size = size;
        this.soleType = soleType;
        this.companyMnfct = companyMnfct;
        this.color = color;
    }

    public String getSoleType()
    {
        return soleType;
    }
    public String getCompanyMnfct()
    {
        return companyMnfct;
    }
    public String getColor()
    {
        return color;
    }
    public int getSize()
    {
        return size;
    }

    @Override
    public String Brand()
    {
        return "Неизвестный бренд кроссовок";
    }

    @Override
    public String toString()
    {
        return "Размер: " + size + "\nЦвет: " + color + "\nТип подошвы: " + soleType +
                "\nПроизводитель: " + companyMnfct + "\nБренд: " + Brand();
    }

    @Override
    public void printInfo()
    {
        System.out.println(toString());
    }

    @Override
    public int hashCode()
    {
        int hash = 3;
        hash = 37 * hash + this.color.hashCode();
        hash = 37 * hash + this.soleType.hashCode();
        hash = 31 * hash + this.size;
        hash = 37 * hash + this.companyMnfct.hashCode();
        return hash;

    }
}
