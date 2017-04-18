import java.io.File;
import java.io.IOException;
import java.util.ListIterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.List;
import java.util.StringTokenizer;

public class MapVertices {
	// This class does all of the pre-processing, like
	// reading in the file, calculating edge weights,
	// and populating the has map.

	// create linked list for node edges pairs
	public LinkedList<VerticePair> nodeEdgesLinkedList = new LinkedList<VerticePair>();
	public LinkedList<VerticeWeight> nodeWeightsLinkedList = new LinkedList<VerticeWeight>();
	
	protected int numNodes;
	// Found in Section 1 of the RTF file, these
	// are the
	// cities.
	protected int numEdges;

	// Found in Section 1 of the RTF file, there
	// are the
	// connections between the cities.
	public MapVertices() {

		try {
			String filePath = System.getProperty("user.dir")
					+ "/Java files/testusa_map_data.txt";
			File inF = new File(filePath); // check if jp file exist
			inF.toString();

			// If it still doesnt find the file then show error
			if (!inF.exists()) {
				System.out
						.println("File not found. Please put 'testusa_map_data' in in same directory.");
				System.exit(0);
			}
			Scanner inR = new Scanner(inF);

			/*
			 * The following while statements iterate through the RTF file. The
			 * "if input is empty" tests effectively separate the different
			 * sections of the RTF file; Section 1 is a single line telling us
			 * how many nodes and edges we have. Section 2 tells us the X and Y
			 * coordinate of each node Section 3 tells us which nodes are
			 * connected.
			 */

			while (inR.hasNext()) {
				String input = inR.nextLine();
				if (input.isEmpty())
					break;

				StringTokenizer token = new StringTokenizer(input);
				numNodes = Integer.parseInt(token.nextToken());
				numEdges = Integer.parseInt(token.nextToken());
//				System.out.println("Number of Nodes: " + numNodes);
//				System.out.println("Number of Edges: " + numEdges);
//				System.out.println("-----------------------");
			}

			while (inR.hasNext()) {
				String input = inR.nextLine();
				if (input.isEmpty())
					break;
				//System.out.println(input);
				// make an verticeWeight object
				String[] verticeSplit = input.split(" ");

				int index = Integer.parseInt(verticeSplit[0]);
				int x = Integer.parseInt(verticeSplit[1]);
				int y = Integer.parseInt(verticeSplit[2]);
				VerticeWeight vw = new VerticeWeight(index, x, y);
				// add to linkedlist
				nodeWeightsLinkedList.add(vw);
			}

			// reading vertices pairs
			while (inR.hasNext()) {
				String input = inR.nextLine();
				//System.out.println(input);
				// make an veticePair object
				String[] edgesSplit = input.split(" ");
				int origin = Integer.parseInt(edgesSplit[0]);
				int pair = Integer.parseInt(edgesSplit[1]);
				VerticePair vp = new VerticePair(origin, pair);
				// add to linkedlist
				nodeEdgesLinkedList.add(vp);

			}

		} catch (Exception e) {
			System.out.println("Uh-oh!");
			System.exit(-1);
		}
	}

	// Calculates the weights between two cities
	public double calculateWeights(int xcoord2, int xcoord1, int ycoord2,
			int ycoord1) {
		double weight;
		weight = Math.sqrt((Math.abs(Math.pow(xcoord2 - xcoord1, 2)) + Math
				.abs(Math.pow(ycoord2 - ycoord1, 2))));
		return weight;
	}

}

class VerticeWeight {

	protected int index;
	protected int xcoord;
	protected int ycoord;

	public VerticeWeight(int i, int x, int y) {
		index = i;
		xcoord = x;
		ycoord = y;
	}

	@Override
	public String toString() {
		return "Index: " + index + " x: " + xcoord + " y: " + ycoord;
	}

}

// vertices pairs for section 3
class VerticePair {
	protected int origin;
	protected int pair;

	public VerticePair(int o, int p) {
		origin = o;
		pair = p;
	}

	@Override
	public String toString() {
		return "Origin: " + origin + " Pair: " + pair;
	}
}
