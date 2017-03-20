import java.io.IOException;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class MapTest {
	public static void main(String[] args) throws IOException {
		Initialize Test = new Initialize();
		
		Test.Initialize();
		
		//get user input to find the nearest city
		Scanner scan = new Scanner(System.in);
		System.out.println("What city Would you like to go to?");
		System.out.println("Starting City?");
		String startingCity = scan.next();
		System.out.println("Destination City?");
		String destinationCity = scan.next();
		
		
		/*Map<Integer, String> dataMap = new HashMap<>(); //Map<Key, Value> they must be class names
		dataMap.put(0, "Zero"); //.put starts loading the HashMap
		dataMap.put(1, "One");
		dataMap.put(2, "Two");
		dataMap.put(3, "Three");
		
		System.out.println(dataMap.get(2));*/
	}
}
	