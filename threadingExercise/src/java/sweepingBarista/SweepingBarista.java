package sweepingBarista;

/**
 * Created by Kelly on 4/2/2017.
 */
public class SweepingBarista {

    public static void main(String a[])
    {
        Starbucks starbucks = new Starbucks();

        Barista barista = new Barista(starbucks);
        CustomerGenerator customerGenerator = new CustomerGenerator(starbucks);

        Thread threadBarista = new Thread(barista);
        Thread threadCustomerGenerator = new Thread(customerGenerator);
        threadCustomerGenerator.start();
        threadBarista.start();
    }
}
