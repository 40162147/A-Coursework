import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Algorithm 
{

	public static void main(String[] args) 
	{	
		String fName;
		fName = "src/berlin52.tsp";
		
		ArrayList<Point2D> cities = TSBLib.loadTSPLib(fName);
		ArrayList<Point2D> result = new ArrayList<Point2D>();
		ArrayList<Point2D> higher = new ArrayList<Point2D>();
		ArrayList<Point2D> lower = new ArrayList<Point2D>();
		
		Point2D currentCity = cities.get(0);
		Point2D closest = null;
	
		System.out.println("Before " + TourLength.routeLength(cities));
		System.out.println(cities.size());
		
		//Nearest Neighbour
		/**While (cities.size >0) Repeat until all cities have been added
		while(cities.size() > 0)
		{
			//result.add(currentCity) Add current city to the result
			result.add(currentCity);
			
			cities.remove(currentCity);
			
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
			
			//The closest city is now the current city
			currentCity = closest;
			//End while
		}
		**/
		
		
		//My algorithm
		
		result.add(currentCity);
		cities.remove(currentCity);
		
		for(Point2D possible  : cities)
		{
			//getDistance() returns the distance between 2 cities
			//if it is closer than any examined so far let’s take note
			if (possible.getY() <= result.get(0).getY())
			{
				lower.add(possible);
			}
			else
			{
				higher.add(possible);
			}
		}
		
		Collections.sort(higher, new Comparator<Point2D>() 
		{
		    public int compare(Point2D p1, Point2D p2) 
		    {
		        return Double.compare(p1.getY(), p2.getY());
		    }
		});
		
		Collections.sort(lower, new Comparator<Point2D>() 
		{
		    public int compare(Point2D p1, Point2D p2) 
		    {
		        return Double.compare(p1.getY(), p2.getY());
		    }
		});
		
		
		for (Point2D possible  : lower)
		{
			System.out.println(possible);
		}
		
		/**while(lower.size() > 0)
		{
			
			double distance = Double.POSITIVE_INFINITY;
			
			for(Point2D possible  : lower)
			{
				if (getDistance(currentCity, possible) < distance)
				{
					closest = possible;
					distance = getDistance(currentCity, possible);
				}
			}
			currentCity = closest;
			result.add(currentCity);
			lower.remove(currentCity);
		}
			
		while(higher.size() > 0)
		{
			
			double distance = Double.POSITIVE_INFINITY;
			
			for(Point2D possible  : higher)
			{
				if (getDistance(currentCity, possible) < distance)
				{
					closest = possible;
					distance = getDistance(currentCity, possible);
				}
			}
			currentCity = closest;
			result.add(currentCity);
			higher.remove(currentCity);
		}
		**/	
			
		
		
		System.out.println("After " + TourLength.routeLength(result));

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
