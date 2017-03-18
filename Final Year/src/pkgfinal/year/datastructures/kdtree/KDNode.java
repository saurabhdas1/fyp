package pkgfinal.year.datastructures.kdtree;

import pkgfinal.year.patterns.cluster.DoubleArray;


/**
* This class represents a KDTree node
*<br/><br/>
 * @see KDTree
 * @author Saurabh Das
*/
class KDNode {
	
	DoubleArray values;  // contains a vector
	int d;  // a dimension
	KDNode above;  // node above
	KDNode below;  // node below
	
	/**
	 * Constructor
	 * @param doubleArray a vector
	 * @param d  a dimension
	 */
	public KDNode(DoubleArray doubleArray, int d){
		this.values = doubleArray;
		this.d = d;
	}


}
