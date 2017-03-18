package pkgfinal.year.algorithms.sort;

import java.util.Random;

/**
 * Implementation of a few selection algorithms (randomized select, etc.).
 * based on description from the book "Introduction to Algorithms" from MIT Press.
 * 
 * Please refer to that book for details about the algorithms and proofs that
 * they are correct.
 * 
 * @author Saurabh Das
 */
public class Select {
	private static Random random = new Random(System.currentTimeMillis());
	 
	/**
	 * Method to select the ith smallest integer of an array in average linear time.
	 * Based on the Randomized-Select algorithm in "Introduction to algorithms" book by Cormen et al. (2001).
	 * @param a   array of integers
	 * @param i  the i value
	 * @return the element of "a" that is larger than i elements.
	 */
	// ((see the book for details about the algorithm)
	public static int randomizedSelect(int[] a, int i) {
		int p = 0;
		int r = a.length-1;
		
		while(true){
			if(p == r){
				return a[p];
			}
			int q = randomizedPartition(a, p, r);  
			int k = q-p+1;

			if(i == k-1){
				return a[q];
			}
			else if(i <k){
				r = q -1;
			}else{
				i = i - k;
				p = q + 1;
			}
		}
  	}
	
	// (see the book for details about the algorithm)
    private static int randomizedPartition(int[] a, int p, int r) {
		int i = 0;
		if(p < r){
			i =  p + random.nextInt(r-p);
		}else{
			i =  r + random.nextInt(p-r);
		}
		swap(a, r, i);
		return partition(a, p, r);  // call the partition method of quicksort.
	}
    
 // (see the book for details about the algorithm)
    private static int partition(int[] a, int p, int r) {
		int x = a[r];
		int i = p - 1;
		for(int j = p; j <= r-1; j++){
			if(a[j] <= x){
				i = i+1;
				swap(a, i, j);
			}
		}
		swap(a, i+1, r);
		return i+1;
	}

	/**
	 * Method to swap two elements in an array
	 * @param array the array
	 * @param i position of an element
	 * @param j position of another element
	 */
	private static void swap(int[] array, int i, int j) {
        int valueI = array[i];
        array[i] = array[j];
        array[j] = valueI;  
    }
}