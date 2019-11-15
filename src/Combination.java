import java.util.ArrayList;
import java.util.List;

// Java program to print all combination of size r in an array of size n

class Combination {
	static List<ArrayList<Integer>> list = new ArrayList<>();

	/*
	 * arr[] ---> Input Array
	 * data[] ---> Temporary array to store current combination
	 * start & end ---> Staring and Ending indexes in arr[]
	 * index ---> Current index in data[]
	 * r ---> Size of a combination to be printed
	 */
	static List<ArrayList<Integer>> combinationUtil(Object arr[], int data[], int start, int end, int index, int r) {
		ArrayList<Integer> independentset = new ArrayList<>();
		if (index == r) {
			for (int j = 0; j < r; j++) {
				// System.out.print(data[j] + " ");
				independentset.add(data[j]);
			}
			list.add(independentset);
			return list;
		}

		// replace index with all possible elements. The condition
		// "end-i+1 >= r-index" makes sure that including one element
		// at index will make a combination with remaining elements
		// at remaining positions
		for (int i = start; i <= end && end - i + 1 >= r - index; i++) {
			data[index] = (int) arr[i];
			combinationUtil(arr, data, i + 1, end, index + 1, r);
		}
		return list;
	}

	// The main function that prints all combinations of size r
	// in arr[] of size n. This function mainly uses combinationUtil()
	List<ArrayList<Integer>> CreateCombination(Object arr[], int n, int r) {
		// A temporary array to store all combination one by one
		int data[] = new int[r];

		// Print all combination using temprary array 'data[]'
		return combinationUtil(arr, data, 0, n - 1, 0, r);
	}

	/* Driver function to check for above function */
	public static void main(String[] args) {
		Object arr[] = { 2, 3, 0 };
		int r = 2;
		int n = arr.length;
		Combination comb = new Combination();
		System.out.println(comb.CreateCombination(arr, n, r));
	}
}
