package sweepingBarista;

/**
 * Created by Kelly on 4/2/2017.
 */
public class Barista  implements Runnable
    {
        Starbucks starbucks;

        public Barista(Starbucks starbucks)
        {

            this.starbucks = starbucks;
        }

        public void run()
        {
            try
            {
                Thread.sleep(10000);
            }
            catch(InterruptedException iex)
            {
                iex.printStackTrace();
            }
            System.out.println("Barista started..");
            while(true)
            {
                starbucks.serveCustomer();
            }
        }
    }
