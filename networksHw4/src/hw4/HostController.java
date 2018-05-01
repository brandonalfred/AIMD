package hw4;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class HostController {
    public int numOfHosts;
    public double maxBandwidth = 1.00000;
    public double inc;
    public double dec;
    public Host[] hosts;
    long runTime = 200;

    public void start() throws InterruptedException {
        Scanner s = new Scanner(System.in);

        System.out.println("Enter number of hosts > ");
        numOfHosts = s.nextInt();

        hosts = new Host[numOfHosts];

        System.out.println("\nEnter inc and dec > ");
        inc = s.nextDouble();
        dec = s.nextDouble();

        System.out.println("\nEnter their initial share of bandwidth > ");
        for (int i = 0; i < numOfHosts; i++) {
            hosts[i] = new Host(inc, dec, s.nextDouble());
        }

        System.out.println("\n(Your program is running)");
        Random rand = new Random();

        while(true) {
            int randomNum = rand.nextInt(numOfHosts);

            long endTime = System.currentTimeMillis() + runTime;

            while(System.currentTimeMillis() <= endTime) {
                if(!sumAllGreaterThanOne())
                    hosts[randomNum].incMyBandwidth(hosts[randomNum].getInc());
                else
                    hosts[randomNum].decMyBandwidth(hosts[randomNum].getDec());

                hosts[randomNum].setMyBandwidth(BigDecimal.valueOf(hosts[randomNum].getMyBandwidth()).setScale(3, RoundingMode.HALF_UP).doubleValue());
            }

            for (int i = 0; i < numOfHosts; i++) {
                System.out.print("h[" + i + "] = " + hosts[i].getMyBandwidth() + "  ");
            }
            System.out.println();

            sleep(400);
        }
    }

    public boolean sumAllGreaterThanOne() {
        double sum = 0;

        for (int i = 0; i < numOfHosts; i++) {
            sum += hosts[i].getMyBandwidth();
        }

        if(sum < maxBandwidth)
            return false;

        return true;
    }
}
