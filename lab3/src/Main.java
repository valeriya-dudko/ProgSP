import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) throws NoSuchElementException {
        Order o = new Order();

        Tankettes t = new Tankettes(70, "белый", 38);
        FlipFlops f = new FlipFlops(10, "голубой", 40);
        o.addSandals(t);
        o.addSandals(f);

        try {
            o.printOrder();
        }
        catch (Exception e) {System.out.println(e);}


    }
}