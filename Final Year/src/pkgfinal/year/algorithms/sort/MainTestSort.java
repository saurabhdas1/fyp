package pkgfinal.year.algorithms.sort;

/**
 * Class for testing and debugging the sorting algorithms (for development purposes only).
 * @author Saurabh Das
 *
 */
class MainTestSort {
	public static void main(String[] args) {
		int []arrayInt = new int[]{5,2,6,7,9, 4,2, 1};
//		Sort.mergeSort(arrayInt);
		Sort.mergeSort(arrayInt);
		
//		QuickSelect.quicksort(arrayInt);
		
		System.out.println(arrayToString(arrayInt));
//		insertionSort(arrayInt);
		System.out.println(arrayToString(arrayInt));
	}

	 
	 public static String arrayToString(int[] a) {
		    StringBuilder result = new StringBuilder();
		    if (a.length > 0) {
		        result.append(a[0]);
		        for (int i=1; i<a.length; i++) {
		            result.append(" ");
		            result.append(a[i]);
		        }
		    }
		    return result.toString();
		}
}
