import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class HighLowAlgorithm 
{
	public static ArrayList<Point2D> HLA(ArrayList<Point2D> cities)
	{
		ArrayList<Point2D> result = new ArrayList<Point2D>();
		ArrayList<Point2D> higher = new ArrayList<Point2D>();
		ArrayList<Point2D> lower = new ArrayList<Point2D>();
		
		Point2D currentCity = cities.get(0);
		Point2D closest = null;
		
		
		
		result.add(currentCity);
		cities.remove(currentCity);
		//split cities into 2 arraylist one for values higher and one for lower
		for(Point2D possible  : cities)
		{
			if (possible.getY() <= result.get(0).getY())
			{
				lower.add(possible);
			}
			else
			{
				higher.add(possible);
			}
		}
	
	
	
		//sort higher by y
		Collections.sort(higher, new Comparator<Point2D>() 
		{
	    	public int compare(Point2D p1, Point2D p2) 
	    	{
	        	return Double.compare(p1.getY(), p2.getY());
	    	}
		});
		//sort higher by x
		Collections.sort(higher, new Comparator<Point2D>() 
		{
	    	public int compare(Point2D p1, Point2D p2) 
	    	{
	        	return Double.compare(p1.getX(), p2.getX());
	    	}
		});
	
		//sort lower by y
		Collections.sort(lower, new Comparator<Point2D>() 
		{
	    	public int compare(Point2D p1, Point2D p2) 
	    	{
	        	return Double.compare(p1.getY(), p2.getY());
	    	}
		});
		//sort lower by x
		Collections.sort(lower, new Comparator<Point2D>() 
		{
	    	public int compare(Point2D p1, Point2D p2) 
	    	{
	        	return Double.compare(p1.getX(), p2.getX());
	    	}
		});
		
		while(lower.size() > 0)
		{
		
			double distance = Double.POSITIVE_INFINITY;
			//for all cities in lower
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
			//for all cities in lower
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
