import java.io.IOException;
import java.util.ListIterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class MapMain {
	public static void main(String[] args) throws IOException {
		MapVertices mv = new MapVertices();

		// loop through nodeEdgesLinkedList
		for (int i = 0; i < mv.nodeEdgesLinkedList.size(); i++) {
			//System.out.println(mv.nodeEdgesLinkedList.get(i));
		}
		// loop through nodeEdgesLinkedList
		for (int i = 0; i < mv.nodeWeightsLinkedList.size(); i++) {
			//System.out.println(mv.nodeWeightsLinkedList.get(i));
		}

		int startingCity = 0;
		int destinationCity = 0;
		// get user input to find the nearest city
		Scanner scan = new Scanner(System.in);
		System.out.println("What city Would you like to go to?");

		// System.out.println("Starting City?");
		// startingCity = scan.nextInt();
		//
		// System.out.println("Destination City?"); String
		// destinationCity = scan.nextInt();

		// TEST DATA TO SEARCH
		startingCity = 0;
		destinationCity = 5;
		
		//begin search
		boolean searching = true;
		int i = 0;
		
		int origin = 0;
		double weight = 0;
		int nextPath = 0;
		while(searching){
			VerticePair current = mv.nodeEdgesLinkedList.get(i);
			//save origin until it changes
			if(origin != current.origin){
				origin = current.origin;
			}
			int xcoord1 = mv.nodeWeightsLinkedList.get(current.origin).xcoord;
			int ycoord1 = mv.nodeWeightsLinkedList.get(current.origin).ycoord;
			int xcoord2 = mv.nodeWeightsLinkedList.get(current.pair).xcoord;
			int ycoord2 = mv.nodeWeightsLinkedList.get(current.pair).ycoord;
			
			double currentWeight = mv.calculateWeights(xcoord2, xcoord1, ycoord2, ycoord1);			
			System.out.println(mv.nodeWeightsLinkedList.get(origin));
			System.out.println(mv.nodeWeightsLinkedList.get(current.pair));
			System.out.println("The Weight: "+currentWeight);
			System.out.println(" ");
			
			
			
			i++;
			//stop overflow
			if(i >= mv.nodeEdgesLinkedList.size() ){
				searching = false;
			}
			
		}
		
		
	}
}
