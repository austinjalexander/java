/* WE WEREN'T ABLE TO GET PAST THE POINT OF INTEGRATING THE DRIVER 
 * AND THE QUEUE CLASS; THE PLANE CLASS WAS CHANGED INTO A TIMING CLASS,
 * AND IT TOOK TIME CHANGE IT BACK TO A PLANE CLASS WHEN WE REALIZED IT 
 * SHOULD HAVE NOT BEEN CHANGED
 */

import java.util.Scanner;

//Rebecca Bell
//Austin Alexander
//Dimitrus Glover


public class PlaneDriver {

	public static void main(String[] args) {
		
		PlaneDriver me = new PlaneDriver();
		me.doIt();
	}
	
	public void doIt() {
		
		
		RunwayQueue landingQueue = new RunwayQueue();
		RunwayQueue takeoffQueue = new RunwayQueue();

		int simulationTime, landingTime, takeoffTime, landingFreqMin, takeoffFreqMin, fuelTimer;
		
		Scanner keyboard = new Scanner(System.in);

		System.out.println("Welcome to our Airport Simulation!");
		
		
		//Get user input
		//-----------------------------------------------

		System.out.println("Please enter the total time that the simulation will run, in minutes:");
		simulationTime = keyboard.nextInt();
		
		System.out.println("Please enter the amount of time it takes for one plane to land:");
		landingTime = keyboard.nextInt();

		System.out.println("Please enter the amount of time it takes for one plane to take off:");
		takeoffTime = keyboard.nextInt();
		
		System.out.println("On average how often do planes arrive to the landing queue?");
		landingFreqMin = keyboard.nextInt();
		//turn this into a random range in minutes to add planes
		
		System.out.println("On average how often do planes arrive to the takeoff queue?");
		takeoffFreqMin = keyboard.nextInt();
		//turn this into a random range in minutes to add planes

		System.out.println("How long, in minutes, can a plane wait to land before running out of fuel?");
		fuelTimer = keyboard.nextInt();
		//-----------------------------------------------
		
		
		int timePassed = 0;
		boolean runwayOccupied = false;
		while (timePassed <= simulationTime) {
			
			System.out.println("Start of Minute "+ timePassed);
			System.out.println("Number of planes in takeoff queue: " + takeoffQueue.size());
			System.out.println("Number of planes in landing queue: " + landingQueue.size()+"\n");

			//queue maintenance
			if (timePassed % landingFreqMin == 0) { //not random right now
				landingQueue.addFlight("AD343F");
			}
			
			if (timePassed % takeoffFreqMin == 0) { //not random right now
				takeoffQueue.addFlight("CV34R");
			}			
				
			//process queues	
			if (!landingQueue.isEmpty()) {
		
			//remove plane from landing queue 																TO DO
			//landingQueue should log success count															TO DO
			//if so, make runwayOccupied true																TO DO
			timePassed =- landingTime;
			//loop through landing queue and increment fuel timer landingTime								TO DO

			continue;
			}
			
			else if (!takeoffQueue.isEmpty()) {
				//remove plane from takeoff queue 															TO DO
				//takeoffQueue should increment takeoff count												TO DO
				//if so, make runwayOccupied true															TO DO
				timePassed =- takeoffTime;
				//loop through landing queue and increment fuel timer takeoffTime							TO DO
				continue;
			}
			
			else {
				//clock ticks up by 1 minute
				timePassed++;	
				//loop through landing queue and increment fuel timer 1 minute								TO DO

			}
		}
		
		//-----------------------------------------------

		System.out.println("              SIMULATION RESULTS                     ");
		System.out.println("-----------------------------------------------------");
		System.out.println("Number of planes successfully taken off: " + takeoffQueue.numSuccesses());
		System.out.println("Average waiting time for takeoffs: " + "insert getter here");

		System.out.println("Number of planes successfully landed: " + landingQueue.numSuccesses());
		System.out.println("Average waiting time for successful landings: " + "insert getter here");
		System.out.println("Number of planes crashed: " + landingQueue.numCrashes());


	}

}
