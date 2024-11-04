import java.io.BufferedReader;
import java.io.FileReader;

public class City {
	String name;
	Connection[] neighbours;
	
	public City(String name) {
		this.name = name;
		neighbours = new Connection[541];
	}
	
}
