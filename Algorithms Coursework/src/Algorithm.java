import java.awt.geom.Point2D;
import java.util.ArrayList;

public class Algorithm 
{

	public static void main(String[] args) 
	{	
		String fName;
		fName = "berlin52.tsp";
		
		ArrayList<Point2D> cities = TSBLib.loadTSPLib(fName);
		ArrayList<Point2D> result = new ArrayList<Point2D>();
		
		Point2D currentCity = cities.remove(0);
		Point2D closest = null;
	
		//While (cities.size >0) Repeat until all cities have been added
		while(cities.size() > 0)
		{
			//result.add(currentCity) Add current city to the result
			result.add(currentCity);
			
			
			//distance = Infinity
			double distance = Double.POSITIVE_INFINITY;
			 
			//Find the closest city to the current city and	add it
			//For (city possible in cities)
			for(Point2D possible  : cities)
			{
				//getDistance() returns the distance between 2 cities
				//if it is closer than any examined so far let’s take note
				if (getDistance(currentCity, possible) < distance)
				{
					closest = possible;
					distance = getDistance(currentCity, possible);
				}
			}
			//Remove the closest city so we don’t consider it again
			cities.remove(closest);
			//The closest city is now the current city
			currentCity = closest;
			//End while
		}
	}
	
	
	private static double getDistance(Point2D currentCity, Point2D possible) 
	{
		double x1 = currentCity.getX();
		double y1 = currentCity.getY();
		double x2 = possible.getX();
		double y2 = possible.getY();
		
		double x = Math.pow((x2-x1), 2);
		double y = Math.pow((y2-y1), 2);
			
		double xy = x + y;
		double distance = Math.sqrt(xy);
			
		return distance;
	}
}
