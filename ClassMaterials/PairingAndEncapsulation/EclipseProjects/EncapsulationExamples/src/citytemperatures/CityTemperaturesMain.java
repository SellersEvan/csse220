package citytemperatures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 
 * Gets in a list of readings of temperatures for particular cities.
 * Then prints out all the cities and the average temperature for
 * each one.
 * 
 * Note that the order cities are printed out at the end does not matter.
 * 
 * Example:
 * 
	Enter the city name (or exit to quit).
	Buffalo
	What is the city's temperature?
	10
	Enter the city name (or exit to quit).
	Terre Haute
	What is the city's temperature?
	25
	Enter the city name (or exit to quit).
	Buffalo
	What is the city's temperature?
	20
	Enter the city name (or exit to quit).
	exit
	Terre Haute 25.0
	Buffalo 15.0
 * 
 * @author hewner
 *
 */
public class CityTemperaturesMain {
	
	private static HashMap<String,ArrayList<Double>> temperatures = new HashMap<String,ArrayList<Double>>();

	public static void main(String[] args) {
		
		Scanner input = new Scanner( System.in );
		
		while( true ) {
			System.out.println( "Enter the city name (or exit to quit)." );
			String cityName = input.nextLine().trim();
			if( cityName.equals( "exit" ) ) break;
			System.out.println( "What is the city's temperature?" );
			Double temperature = input.nextDouble();
			input.nextLine();
			if ( !temperatures.containsKey( cityName ) ) temperatures.put( cityName, new ArrayList<Double>() );
			temperatures.get( cityName ).add( temperature );
		}

		input.close();

		// print cities
		for ( HashMap.Entry<String,ArrayList<Double>> entity : temperatures.entrySet() ) {
			System.out.println( entity.getKey() + " " + calculateTempAvg( entity.getValue() ) );
		}
	}

	/** GET AVERAGE TEMP (PUBLIC)
	 * 	Calculate the average of an array list of doubles
	 * @param temps { ArrayList<Double> }
	 * @return avg { double }
	 */
	public static double calculateTempAvg( ArrayList<Double> temps ) {
		double total = 0;
		for ( Double temp : temps ) total += temp;
		return ( total / ( double )( temps.size() ) );
	}
}