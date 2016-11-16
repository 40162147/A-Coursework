import java.awt.geom.Point2D;
import java.util.ArrayList;



public class Algorithm 
{

	public static void main(String[] args) 
	{	
		
		//filenames
		String fName;
		//fName = "src/berlin52.tsp";
		//fName = "src/rl5915.tsp";
		//fName = "src/rl5934.tsp";
		fName = "src/rl11849.tsp";
		
		//get current time in milliseconds
		double startTime = System.currentTimeMillis();
		//arraylist = loaded file cities
		ArrayList<Point2D> cities = TSBLib.loadTSPLib(fName);
	

		//get routelength before algorithm and how many cities
		System.out.println("Before " + TourLength.routeLength(cities));
		System.out.println(cities.size());

		//Algorithms
		ArrayList<Point2D> result = NearestNeighbour.Nneighbour(cities);
		//ArrayList<Point2D> result = HighLowAlgorithm.HLA(cities);
		//ArrayList<Point2D> result = SmallestPoint.SP(cities);
		
		//get current time in milliseconds
		double endTime   =  System.currentTimeMillis();
		//calculate total time in seconds
		double totalTime = (endTime - startTime)/1000;
		System.out.println(totalTime + " seconds");
		//show new routelength
		System.out.println("After " + TourLength.routeLength(result));

	}
	
	
}
