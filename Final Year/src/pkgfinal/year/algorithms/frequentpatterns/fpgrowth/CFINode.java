package pkgfinal.year.algorithms.frequentpatterns.fpgrowth;




import java.util.ArrayList;
import java.util.List;

import pkgfinal.year.patterns.itemset_array_integers_with_count.Itemset;

/**
 * This is an implementation of a CFI-Node as used by the FPClose algorithm.
 *
 * @see CFITree
 * @see Itemset
 * @see AlgoFPClose
 * @author Saurabh Das
 */
public class CFINode {
	int itemID = -1;  // item id
	int counter = 1;  // frequency counter  (a.k.a. support)
	int level;  // at which level in the CFI tree this node appears
	
	// the parent node of that node or null if it is the root
	CFINode parent = null; 
	// the child nodes of that node
	List<CFINode> childs = new ArrayList<CFINode>();
	
	CFINode nodeLink = null; // link to next node with the same item id (for the header table).
	
	/**
	 * constructor
	 */
	CFINode(){
		
	}

	/**
	 * Return the immediate child of this node having a given ID.
	 * If there is no such child, return null;
	 */
	CFINode getChildWithID(int id) {
		// for each child node
		for(CFINode child : childs){
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
		output.append(" level="+ level);
		output.append(")\n");
		String newIndent = indent + "   ";
		for (CFINode child : childs) {
			output.append(newIndent+ child.toString(newIndent));
		}
		return output.toString();
	}

}
