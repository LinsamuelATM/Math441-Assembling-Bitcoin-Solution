/**
 * 9 * Project:IndependentSet
 * 
 * 
 * File: Driver.java
 * Date: Nov 8, 2019
 * Time: 2:06:46 PM
 */

/**
 * @author Samuel Lin, A01079605
 *
 */

public class Driver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Create IndependentSet Object
		IndependentSet indSet = new IndependentSet();

		// Model the graph with a two-dimensional matrix
		int[][] graph = { { 0, 1, 1, 0, 0, 0, 0, 0, 0 }, { 1, 0, 1, 0, 1, 0, 1, 0, 0 }, { 1, 1, 0, 0, 0, 0, 0, 1, 0 }, { 0, 0, 0, 0, 1, 1, 0, 0, 0 },
				{ 0, 1, 0, 1, 0, 1, 0, 0, 0 }, { 0, 0, 0, 1, 1, 0, 0, 1, 0 }, { 0, 1, 0, 0, 0, 0, 0, 1, 1 }, { 0, 0, 1, 0, 0, 1, 1, 0, 1 },
				{ 0, 0, 0, 0, 0, 0, 1, 1, 0 } };

		int size = 3;

		// Check Decision
		if (indSet.check(graph, size)) {
			System.out.println("Yes, an Independent set of the given size exist in the graph");
		} else {
			System.out.println("No, an Independent set of the given size does not exist in the graph");
		}

	}

}
