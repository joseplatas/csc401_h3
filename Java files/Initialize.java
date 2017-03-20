import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Initialize {
	// This class does all of the pre-processing, like
	// reading in the file, calculating edge weights,
	// and populating the has map.

	public Initialize() {
		Map<Integer, List<Integer>> myMap = new HashMap<>();
	}

	public HashMap Initialize() throws IOException {
		try {
			File inF = new File(
					"C:\\Users\\Jason\\workspace\\CSC 401 Assignment 3\\src\\testusa_map_data.rtf");
			// If not found then look in the working directory and then in the
			// "Java files" folder
			if (!inF.exists()) {
				String filePath = System.getProperty("user.dir")
						+ "/Java files/testusa_map_data.rtf";
				inF = new File(filePath); // check if jp file exist
				inF.toString();
			}
			// If it still doesnt find the file then show error
			if (!inF.exists()) {
				System.out
						.println("Unable to find file. Please ensure that usa_map_data.rtf is in the same directory as the program.");
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
				System.out.println("Number of Nodes: " + numNodes);
				System.out.println("Number of Edges: " + numEdges);
				System.out.println("-----------------------");
			}

			while (inR.hasNext()) {
				String input = inR.nextLine();
				if (input.isEmpty())
					break;
				System.out.println(input);
			}

			while (inR.hasNext()) {
				String input = inR.nextLine();
				System.out.println(input);
			}
		}

		catch (Exception e) {
			System.out.println("Uh-oh!");
			System.exit(-1);
		}
		return null;
	}

	public double calculateWeights(int xcoord2, int xcoord1, int ycoord2,
			int ycoord1) { // Calculates the weights between two cities
		double weight;
		weight = Math.sqrt((Math.abs(Math.pow(xcoord2 - xcoord1, 2)) + Math
				.abs(Math.pow(ycoord2 - ycoord1, 2))));
		return weight;
	}

	protected int numNodes; // Found in Section 1 of the RTF file, these are the
							// cities.
	protected int numEdges; // Found in Section 1 of the RTF file, there are the
							// connections between the cities.
}

class Node {
	public Node(int newIndex, int x, int y) {
		index = newIndex;
		xcoord = x;
		ycoord = y;
	}

	protected int index;
	protected int xcoord;
	protected int ycoord;
}