package sweepingBarista;

import java.util.Date;

/**
 * Created by Kelly on 4/2/2017.
 */

public class Customer implements Runnable
{
    String name;
    Date inTime;

    Starbucks starbucks;

    public Customer(Starbucks starbucks)
    {

        this.starbucks = starbucks;
    }

    public String getName() {

        return name;
    }

    public Date getInTime() {

        return inTime;
    }

    public void setName(String name) {

        this.name = name;
    }

    public void setInTime(Date inTime) {

        this.inTime = inTime;
    }

    public void run()
    {

        getCoffee();
    }
    private synchronized void getCoffee()
    {

        starbucks.add(this);
    }
}
