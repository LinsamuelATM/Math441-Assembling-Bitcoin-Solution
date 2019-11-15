
/**
 * Project:IndependentSet
 * 
 * File: IndependentSet.java
 * Date: Nov 8, 2019
 * Time: 11:24:06 AM
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 */
public class IndependentSet {
	ArrayList<Integer> IndepdentSet = new ArrayList<Integer>();

	// Constructor
	public IndependentSet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @param graph
	 *            - undirect graph in matrix form
	 * @param size
	 *            - size of Independent set
	 * @return "True", if size k Independent set exist. "False" , if size k independent set does not exist
	 */

	// check to is there is a size k independent set in the given graph
	public boolean check(int[][] graph, int size) {

		// Empty Independent set
		Object arr[] = {};

		// Create an empty HashMap
		Map<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();

		// Decision, either "Yes" or "No"
		Boolean output = false;

		// Put vertex numbers as the key and the values of each each is an empty ArrayList
		for (int i = 0; i < graph.length; i++) {
			map.put(i, new ArrayList<Integer>());
		}

		// Using a two for-loops we go through the graph and add the vertex with no edges to each set
		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph[i].length; j++) {
				if (graph[i][j] == 0) {
					map.get(i).add(j);
				}
			}
		}

		// We loop through each keySet and the value which represents the set of vertices with not edges, find combinations of given size and check if
		// it is independent
		for (int i = 0; i < map.keySet().size(); i++) {

			Object[] independentnumbers = map.get(i).toArray();
			arr = independentnumbers;

			System.out.println("Vertex " + i);
			System.out.println(Arrays.toString(independentnumbers));

			// Create Combination class
			Combination getCombination = new Combination();

			// We find all combinations of size k
			List<ArrayList<Integer>> allCombinations = getCombination.CreateCombination(arr, arr.length, size);

			System.out.println(" ");
			System.out.println("Possible combinations with given size:");
			System.out.println(allCombinations);
			System.out.println(" ");

			// loop through each combination, and check if it there is one that is independent
			for (int k = 0; k < allCombinations.size(); k++) {
				if (FesibleSet(graph, allCombinations.get(k), size)) {
					output = true;
				}
			}
		}

		return output;

	}

	/**
	 * 
	 * @param graph
	 *            - undirected graph
	 * @param Independentset
	 *            - vertices that are non-adjacent
	 * @param size
	 *            - size of Independent set
	 * @return "True", if the set is independent . "False" , if the set is not independent
	 */
	// Check to see if the set if Independent
	public boolean FesibleSet(int[][] graph, ArrayList<Integer> Independentset, int size) {

		for (int i = 0; i < Independentset.size(); i++) {
			for (int j = 1; j < Independentset.size(); j++) {
				// if two vertices have an edge between we return false. Note* , 1 represents an edge in the matrix
				if (graph[Independentset.get(i)][Independentset.get(j)] == 1) {
					return false;
				}
			}
		}
		// return true there are no edges between the vertices in the set.
		return true;

	}

}
