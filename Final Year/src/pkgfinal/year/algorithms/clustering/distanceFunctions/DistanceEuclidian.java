package pkgfinal.year.algorithms.clustering.distanceFunctions;

import pkgfinal.year.patterns.cluster.DoubleArray;

/**
 * This class implements the Euclidian distance function. It is a subclass of the
 * DistanceFunction class which represents any distance function.
 * <br/><br/>
 * 
 * @see DistanceFunction
 * @author Saurabh Das
 */

public class DistanceEuclidian extends DistanceFunction {
	/** the name of this distance function */
	static String NAME = "euclidian";
	
	/**
	 * Calculate the eucledian distance between two vectors of doubles.
	 * @param vector1 the first vector
	 * @param vector2 the second vector
	 * @return the distance
	 */
	public double calculateDistance(DoubleArray vector1, DoubleArray vector2) {
		double sum =0;	
		for(int i=0; i< vector1.data.length; i++){
			sum += Math.pow(vector1.data[i] - vector2.data[i], 2);
		}
		return Math.sqrt(sum);
	}

	public String getName() {
		return NAME;
	}
	
}
