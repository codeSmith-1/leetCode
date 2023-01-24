package InsertionSort;

public class insertionSortAlgo {

	public static void main(String[] args) {
		int[] result = insertionSort((new int[] {4, 2, 3, 1}));
		
		for(int num : result) {
			System.out.print(num +" ");
		}
		

	}
	
	public static int[] insertionSort(int nums[]) {
		int n = nums.length;
		for(int i = 1; i < n; i++) {
			int current = nums[i];
			int j = i-1;
			
			while (j >= 0 && nums[j] > current) {
				nums[j + 1] = nums[j];
				j = j - 1;
			}
			nums[j+1] = current;
		}
		
		return nums;
	}

}
