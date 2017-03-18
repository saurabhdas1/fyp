package pkgfinal.year.algorithms.clustering.distanceFunctions;

import pkgfinal.year.patterns.cluster.DoubleArray;

/**
 * This class implements the Jaccard distance function. This distance
 * function is suitable for vectors of binary values (0 or 1). It should
 * not be used with vectors containing non binary numbers.
 * It is a subclass of the
 * DistanceFunction class which represents any distance function.
 * <br/><br/>
 * 
 * @see DistanceFunction
 * @author Saurabh Das
 */

public class DistanceJaccard extends DistanceFunction {
	/** the name of this distance function */
	static String NAME = "jaccard";

	/**
	 * Calculate the Jaccard distance between two vectors of doubles, which are
	 * assumed to be either 0s or 1s.
	 * @param vector1 the first vector
	 * @param vector2 the second vector
	 * @return the distance
	 */
	public double calculateDistance(DoubleArray vector1, DoubleArray vector2) {
		double count11 = 0;	  // count of M11
		double count10or01or11 = 0; // count of M01, M10 and M11
		
		// for each position in the vector
		for(int i=0; i< vector1.data.length; i++){
			// if it is not  two 0s
			if(vector1.data[i] != 0  || vector2.data[i] != 0) {
				// if it is two 1s
				if(vector1.data[i] == 1  && vector2.data[i] == 1) {
					count11++;
				}
				// increase the count of not two 0s
				count10or01or11++;
			}
			
		}
		return count11 / count10or01or11;
	}
	
	@Override
	public String getName() {
		return NAME;
	}
	
	public static void main(String[] args) {
		DoubleArray array1 = new DoubleArray(new double[] {0,1,0,1});
		DoubleArray array2 = new DoubleArray(new double[] {1,0,0,1});
		System.out.println(new DistanceJaccard().calculateDistance(array1,array2));
		// result should be 0.33
		
		DoubleArray array4 = new DoubleArray(new double[] {1, 0});
		DoubleArray array3 = new DoubleArray(new double[] {1, 0});
		System.out.println(new DistanceCosine().calculateDistance(array3,array4));
	}
	

}
