import java.util.*;

public class Order {
    private List<Sandals> sandalsColl;
    private int coverage; //in %
    private String color;
    private int size;
    private static int orderNum = 0;

    public Order()
    {
        sandalsColl = new ArrayList<Sandals>();
        orderNum++;
    }

    public void addSandals(Sandals obj)
    {
        sandalsColl.add(obj);
    }

        public void printOrder()
    {
        int i = 1;
        Iterator it = sandalsColl.iterator();
        System.out.println();
        while(it != null)
        {
            System.out.println(i + ". " + (it.next()).toString());
            i++;
        }
        System.out.println();

    }


}
