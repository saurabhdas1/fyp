package pkgfinal.year.algorithms.classifiers.decisiontree.id3;



/**
* This class represents a decision node of a decision tree created by the ID3 algorithm.
 *
 * @see AlgoID3
 * @see Node
 * @see ClassNode
 * @author Saurabh Das
 */
public class DecisionNode extends Node {
	/** the id of the attribute that this node represents */
	public int attribute;
	/** a list of child node */
	public Node[] nodes;
	/** the list of values for the attribute that correspond to the child nodes*/
	public String[] attributeValues;
}
