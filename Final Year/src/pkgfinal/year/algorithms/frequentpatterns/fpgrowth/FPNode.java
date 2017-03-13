package pkgfinal.year.algorithms.frequentpatterns.fpgrowth;



import java.util.ArrayList;
import java.util.List;

import pkgfinal.year.patterns.itemset_array_integers_with_count.Itemset;

/**
 * This is an implementation of a FPTree node as used by the FPGrowth algorithm.
 *
 * @see FPTree
 * @see Itemset
 * @see AlgoFPGrowth
 * @author Saurabh Das
 */
public class FPNode {
	int itemID = -1;  // item id
	int counter = 1;  // frequency counter  (a.k.a. support)
	
	// the parent node of that node or null if it is the root
	FPNode parent = null; 
	// the child nodes of that node
	List<FPNode> childs = new ArrayList<FPNode>();
	
	FPNode nodeLink = null; // link to next node with the same item id (for the header table).
	
	/**
	 * constructor
	 */
	FPNode(){
		
	}

	/**
	 * Return the immediate child of this node having a given ID.
	 * If there is no such child, return null;
	 */
	FPNode getChildWithID(int id) {
		// for each child node
		for(FPNode child : childs){
			// if the id is the one that we are looking for
			if(child.itemID == id){
				// return that node
				return child;
			}
		}
		// if not found, return null
		return null;
	}

	/**
	 * Method for getting a string representation of this tree 
	 * (to be used for debugging purposes).
	 * @param an indentation
	 * @return a string
	 */
	public String toString(String indent) {
		StringBuilder output = new StringBuilder();
		output.append(""+ itemID);
		output.append(" (count="+ counter);
		output.append(")\n");
		String newIndent = indent + "   ";
		for (FPNode child : childs) {
			output.append(newIndent+ child.toString(newIndent));
		}
		return output.toString();
	}
	
	public String toString() {
		return ""+itemID;
	}
}
