package sweepingBarista;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Kelly on 4/2/2017.
 */

public class Starbucks {

        int maxLine;
        List<Customer> listCustomer;

        public Starbucks()
        {
            maxLine = 10;
            listCustomer = new LinkedList<Customer>();
        }

        public void serveCustomer()
        {
            Customer customer;
            System.out.println("Barista found customer in line.");
            synchronized (listCustomer)
            {

                while(listCustomer.size()==0)
                {
                    System.out.println("Barista is sweeping while waiting for customer.");
                    try
                    {
                        listCustomer.wait();
                    }
                    catch(InterruptedException iex)
                    {
                        iex.printStackTrace();
                    }
                }
                System.out.println("Barista found is serving a customer.");
                customer = (Customer)((LinkedList<?>)listCustomer).poll();
            }
            long duration=0;
            try
            {
                System.out.println("Customer waiting in line : "+customer.getName());
                duration = (long)(Math.random()*10);
                TimeUnit.SECONDS.sleep(duration);
            }
            catch(InterruptedException iex)
            {
                iex.printStackTrace();
            }
            System.out.println("Customer is being served : "+customer.getName() + " in "+duration+ " seconds.");
        }

        public void add(Customer customer)
        {
            System.out.println("Customer : "+customer.getName()+ " entering the store at "+customer.getInTime());

            synchronized (listCustomer)
            {
                if(listCustomer.size() == maxLine)
                {
                    System.out.println("Customer waiting in line " + customer.getName());
                    System.out.println("Customer " + customer.getName() + "Exists...");
                    return ;
                }

                ((LinkedList<Customer>) listCustomer).offer(customer);
                System.out.println("Customer : " + customer.getName() + " is waiting.");

                if(listCustomer.size()==1)
                    listCustomer.notify();
            }
        }
}

