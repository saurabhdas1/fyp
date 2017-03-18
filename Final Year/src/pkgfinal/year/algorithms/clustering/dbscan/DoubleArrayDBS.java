package pkgfinal.year.algorithms.clustering.dbscan;

import pkgfinal.year.patterns.cluster.Cluster;
import pkgfinal.year.patterns.cluster.DoubleArray;
import pkgfinal.year.patterns.cluster.DoubleArrayInstance;

/**
 * This class represents a vector of double values used by the DBScan algorithm.
 * It has a "visited" flag to remember the node that have been already visited.
* 
 * @author Saurabh Das
 */
public class DoubleArrayDBS extends DoubleArrayInstance{
	
	boolean visited = false;
	Cluster cluster = null;

	/**
	 * Constructor
	 * @param data an array of double values
	 * @param String the name of this array
	 */
	public DoubleArrayDBS(double[] data, String name) {
		super(data, name);
	}

}
