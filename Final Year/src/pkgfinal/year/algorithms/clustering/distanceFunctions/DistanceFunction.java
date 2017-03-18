package pkgfinal.year.algorithms.clustering.distanceFunctions;

import pkgfinal.year.patterns.cluster.DoubleArray;


/**
 * This class represent a distance function to calculate the distance between two 
 * arrays of double values. It is an abstract class having several subclasses 
 * such as the Euclidian distance and the Manathan distance. 
 * The distance classes are used by the clustering algorithm. It let the user
 * choose which distance measure should be used.
 * <br/><br/>
 * 
 * @author Saurabh Das
 */
public abstract class DistanceFunction {
	
	/**
	 * Calculate the  distance between two vectors of doubles.
	 * @param vector1 the first vector
	 * @param vector2 the second vector
	 * @return the distance
	 */
	public abstract double calculateDistance(DoubleArray vector1, DoubleArray vector2);
	
	/**
	 * Get the nam of this distance function
	 * @return a string
	 */
	public  abstract String getName();
	
	
	/**
	 * This method returns the distance function having a given name
	 * @param name the name  (euclidian, manathan, cosine, correlation,...)
	 * @return the distance function
	 */
	public static DistanceFunction getDistanceFunctionByName(String name){
		if(DistanceCorrelation.NAME.equals(name)) {
			return new DistanceCorrelation();
		}else if(DistanceCosine.NAME.equals(name)) {
			return new DistanceCosine();
		}else if(DistanceEuclidian.NAME.equals(name)) {
			return new DistanceEuclidian();
		}else if(DistanceManathan.NAME.equals(name)) {
			return new DistanceManathan();
		}else if(DistanceJaccard.NAME.equals(name)) {
			return new DistanceJaccard();
		}
		return null;
	}
}
