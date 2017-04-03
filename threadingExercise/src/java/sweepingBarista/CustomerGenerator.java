package sweepingBarista;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by Kelly on 4/2/2017.
 */
public class CustomerGenerator implements Runnable
{
    Starbucks starbucks;

    public CustomerGenerator(Starbucks starbucks)
    {
        this.starbucks = starbucks;
    }

    public void run()
    {
        while(true)
        {
            Customer customer = new Customer(starbucks);
            customer.setInTime(new Date());
            Thread threadCustomer = new Thread(customer);
            customer.setName("Customer Thread " + threadCustomer.getId());
            threadCustomer.start();

            try
            {
                TimeUnit.SECONDS.sleep((long)(Math.random()*10));
            }
            catch(InterruptedException iex)
            {
                iex.printStackTrace();
            }
        }
    }

}