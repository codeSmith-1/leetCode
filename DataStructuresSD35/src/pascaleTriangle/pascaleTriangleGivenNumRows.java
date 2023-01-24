package pascaleTriangle;

import java.util.ArrayList;
import java.util.List;

public class pascaleTriangleGivenNumRows {

	public static void main(String[] args) {
		System.out.print(pascaleTriangle((27)));
		
	}

	public static List<List<Integer>> pascaleTriangle(int numRows) {
		// create a triangle List<List<Integer>>
		// create first List and add 1 to the row;
		// add that row to the triangle;

		// create outer loop up to numRows (i < numRows)
		// create inner loop grabbing the two prior elements up to j < i

		List<List<Integer>> triangle = new ArrayList<>();
		if (numRows == 0)
			return triangle;

		List<Integer> firstRow = new ArrayList<>();
		firstRow.add(1);
		triangle.add(firstRow);
		// [[1],[1, 1],[1, 2, 1],[1, 3, 3, 1]]
		for (int i = 1; i < numRows; i++) {
			List<Integer> row = new ArrayList<>();
			List<Integer> prevRow = triangle.get(i - 1);

			row.add(1);

			for (int j = 1; j < i; j++) {
				row.add(prevRow.get(j - 1) + prevRow.get(j));
			}

			row.add(1);
			triangle.add(row);
		}
		return triangle;
	}
}
