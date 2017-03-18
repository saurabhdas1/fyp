package pkgfinal.year.algorithms.clustering.distanceFunctions;

import pkgfinal.year.patterns.cluster.DoubleArray;

/**
 * This class implements the Manathan distance function. It is a subclass of the
 * DistanceFunction class which represents any distance function.
 * <br/><br/>
 * 
 * @see DistanceFunction
 * @author Saurabh Das
 */

public class DistanceManathan extends DistanceFunction {
	/** the name of this distance function */
	static String NAME = "manathan";

	/**
	 * Calculate the Manathan distance between two vectors of doubles.
	 * @param vector1 the first vector
	 * @param vector2 the second vector
	 * @return the distance
	 */
	public double calculateDistance(DoubleArray vector1, DoubleArray vector2) {
		double sum =0;	
		for(int i=0; i< vector1.data.length; i++){
			sum += Math.abs(vector1.data[i] - vector2.data[i]);
		}
		return sum;
	}
	
	@Override
	public String getName() {
		return NAME;
	}
//	
//	public static void main(String[] args) {
//		DoubleArray array1 = new DoubleArray(new double[] {0,2});
//		DoubleArray array2 = new DoubleArray(new double[] {2,0});
//		System.out.println(new DistanceManathan().calculateDistance(array1,array2));
//	}
	

}
