import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SmallestPoint 
{
	public static ArrayList<Point2D>SP(ArrayList<Point2D> cities)
	{
		//sort cities by y
		Collections.sort(cities, new Comparator<Point2D>() 
		{
	    	public int compare(Point2D p1, Point2D p2) 
	    	{
	        	return Double.compare(p1.getY(), p2.getY());
	    	}
		});
		//sort cities by x
		Collections.sort(cities, new Comparator<Point2D>() 
		{
	    	public int compare(Point2D p1, Point2D p2) 
	    	{
	        	return Double.compare(p1.getX(), p2.getX());
	    	}
		});
		
		
		ArrayList<Point2D> result = new ArrayList<Point2D>();
		Point2D currentCity = cities.get(0);
		Point2D closest = null;
		
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
		return result;
	
	}
	
	//work out distance
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
