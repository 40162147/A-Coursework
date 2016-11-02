import java.awt.geom.Point2D;
import java.util.ArrayList;

public class Main 
{
	
	ArrayList<Point2D> cities = new ArrayList<Point2D>();
	ArrayList<Point2D> result = new ArrayList<Point2D>();
	
	Point2D currentCity = cities.remove(0);
	
	
	//While (cities.size >0) Repeat until all cities have been added
	//result.add(currentCity) Add current city to the result
	//distance = Infinity Find the closest city to the current city and
	//add it
	//For (city possible in cities)
	//If (getDistance(currentCity, possible) < distance
	//getDistance() returns the distance between 2 cities
	//if it is closer than any examined so far let’s take
	//note
	//closest = currentCity
	//distance = getDistance(currentCity, possible)
	//End if

	//End for
	//cities.remove(closest)Remove the closest city so we don’t consider
	//it angain
	//currentCity = closest The closest city is now the current city
	//End while
		
		
		
		
		

}
