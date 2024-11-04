import java.io.BufferedReader;
import java.io.FileReader;

public class Graphs {
	
	private static City[] cities;
	private static final int mod = 541;
	private static Routes[] routes;
	static Connection[] trips = new Connection[541];
	
	public Graphs(String file) {
		cities = new City[mod];
		routes = new Routes[mod];
		trips = new Connection[mod];
		
		try(BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			int i = 0;
			int j = 0;
			int p = 0;
			while((line = br.readLine()) != null) {
				String[] row = line.split(",");
				cities[i++] = new City(row[0]);
				routes[j++] = new Routes(row[0], row[1], Integer.valueOf(row[2]));
				trips[p++] = new Connection(row[1], Integer.valueOf(row[2]));
				
				
			/*	for(String index : row) {
					System.out.printf("%-15s", index);
				}
				System.out.println(); */
			}
		} catch (Exception e) {
			System.out.println("file " + file + " not found or corrupt");
		}
	}
	
	public static String lookup(String name) {
		
		int i = 0;
		while(i < 75) {
			if(name.equals(cities[i].name)) {
			//	System.out.println(name + " found");
				return name;
			}
			else {
				i++;
			}
		}
		System.out.println("not found");
		return "false";
		
	}
	
	private static Integer hash(String name) {
		int hash = 7;
		for(int i = 0; i < name.length(); i++) {
			hash = (hash*31 % mod) + name.charAt(i);
		}
		System.out.println(hash%mod);
		return hash % mod;
	}
	
	
	
	
	public static void addConnection() {
		
		for(int i = 0; i < 75; i++) {
			int k = 0;
			for(int j = 0; j < 75; j++) {
				if(cities[i].name.equals(routes[j].from)) {
					cities[i].neighbours[k] = trips[j];
					k++;
				}
				else {
					continue;
				}
			}
		}
		
	}
	
	private static Integer shortest(City from, City to, Integer max) {
		if(max < 0) {
			return null;
		}
		if(from == to) {
			return 0;
		}
		
		Integer shrt = 19999;
		
		for(int i = 0; i < from.neighbours.length; i++) {
			if(from.neighbours[i] != null) {
				Connection conn = from.neighbours[i];
				if(conn.distance < shrt) {
					shrt = conn.distance;
				}
				else {
					continue;
				}
				
			}
		}
		return shrt;
	}
	

	public static void main(String[] args) {
		Graphs g = new Graphs("src\\trains.csv");
		
		
		lookup("Alvesta");
		
	/*	for(int i = 0; i < 75; i++) {
			System.out.println(routes[i].from + "  to  " + routes[i].to + 
			"  " +		 routes[i].distance + "  minutes  ");
		} */
		
		addConnection();
		
		
		for(int i = 0; i < 75; i++) {
			for(int j = 0; j < 5; j++) {
				if(cities[i].neighbours[j] != null) {
					System.out.println("direct connections: " + cities[i].name +
						" to " +
						cities[i].neighbours[j].name
						+ " " + cities[i].neighbours[j].distance + " minutes " );
				}
			}
		}  
		
		
		String from = "Malmö";
		String to = "Lund";
		Integer max = 10000;
		
		long t0 = System.nanoTime();
		Integer dist = shortest(cities[10], cities[9], max);
		long time = (System.nanoTime() - t0)/1000000;
		
		System.out.println("shortest: " + dist + " min (" + time + " ms)");
	}

}


