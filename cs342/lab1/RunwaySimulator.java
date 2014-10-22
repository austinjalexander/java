/*** THIS FILE WAS USED TO TEST RunwayQueue.java ***/

import java.io.*;

public class RunwaySimulator {

  public static void main(String[] args) {
    
    RunwayQueue arrivals = new RunwayQueue(5);
    //RunwayQueue departures = new RunwayQueue(5);

    arrivals.displayQueue();
    //departures.displayQueue();

    arrivals.addFlight(String.valueOf(System.currentTimeMillis()));
    arrivals.addFlight(String.valueOf(System.currentTimeMillis())+1);
    arrivals.addFlight(String.valueOf(System.currentTimeMillis())+2);

    arrivals.displayQueue();

    arrivals.removeFlight();
    arrivals.removeFlight();
    arrivals.removeFlight();

    arrivals.displayQueue();

    arrivals.displayQueue();

    arrivals.addFlight(String.valueOf(System.currentTimeMillis()));

    arrivals.displayQueue();

    arrivals.removeFlight();

    arrivals.displayQueue();
  }
}