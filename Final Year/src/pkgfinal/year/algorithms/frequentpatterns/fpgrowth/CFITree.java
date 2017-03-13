package pkgfinal.year.algorithms.frequentpatterns.fpgrowth;



import java.util.HashMap;
import java.util.Map;

import pkgfinal.year.patterns.itemset_array_integers_with_count.Itemset;


/**
 * This is an implementation of a CFITree as used by the FPClose algorithm.
 *
 * @see CFINode
 * @see Itemset
 * @see AlgoFPClose
 * @author Saurabh Das
 */
public class CFITree {
	
	// List of pairs (item, frequency) of the header table
	Map<Integer, CFINode> mapItemNodes = new HashMap<Integer, CFINode>();
	
	// Map that indicates the last node for each item using the node links
	// key: item   value: an fp tree node
	Map<Integer, CFINode> mapItemLastNode = new HashMap<Integer, CFINode>();
	
	// root of the tree
	CFINode root = new CFINode(); // null node

	// last added itemset
	CFINode lastAddedItemsetNode = null;
	
	/**
	 * Constructor
	 */
	public CFITree(){	
		
	}

	/**
	 * Method to fix the node link for an item after inserting a new node.
	 * @param item  the item of the new node
	 * @param newNode the new node thas has been inserted.
	 */
	private void fixNodeLinks(Integer item, CFINode newNode) {
		// get the latest node in the tree with this item
		CFINode lastNode = mapItemLastNode.get(item);
		if(lastNode != null) {
			// if not null, then we add the new node to the node link of the last node
			lastNode.nodeLink = newNode;
		}
		// Finally, we set the new node as the last node 
		mapItemLastNode.put(item, newNode); 
		
		CFINode headernode = mapItemNodes.get(item);
		if(headernode == null){  // there is not
			mapItemNodes.put(item, newNode);
		}
	}


	/**
	 * Add an itemset to the CFI-Tree
	 * @param itemset the itemset
	 * @param itemsetLength the length of the itemset
	 * @param support the support of the itemset
	 */
	public void addCFI(int[] itemset, int itemsetLength, int support) {
		
		CFINode currentNode = root;
		// For each item in the itemset
		for(int i=0; i < itemsetLength; i++){
			int item = itemset[i];
			
			// look if there is a node already in the FP-Tree
			CFINode child = currentNode.getChildWithID(item);
			if(child == null){ 
				// there is no node, we create a new one
				CFINode newNode = new CFINode();
				newNode.itemID = item;
				newNode.parent = currentNode;
				// remember at which level in the tree that node appears
				newNode.level = i+1;  
				newNode.counter = support; // NEW BY PHILIPPE 2015
				// we link the new node to its parrent
				currentNode.childs.add(newNode);
				
				// we take this node as the current node for the next for loop iteration 
				currentNode = newNode;
				
				// We update the header table.
				// We check if there is already a node with this id in the header table
				fixNodeLinks(item, newNode);	
			}else{ 
				// FPCLOSE:
				// If there is a node already, we update it
				// with the maximum of the support already in the path
				// and the support of the current itemset
				child.counter = Math.max(support, child.counter);
				currentNode = child;
			}
		}
		
//		 SET THE SUPPORT OF THE CFI (the last item)
//		currentNode.counter = support;
		
		// remember that this is the last added itemset
		lastAddedItemsetNode = currentNode;
	}

	/**
	 * Perform the subset test to see if an itemset is a subset of an already
	 * found CFI with the same support
	 * @param headWithP the itemset to be tested
	 * @param headWithPLength the last position to be considered in headWithP
	 * @param the support of the itemset headwithP
	 * @return true if the itemset is not a subset of an already found CFI.
	 */
	public boolean passSubsetChecking(int[] headWithP, int headWithPLength, int headWithPSupport) { 
		// OPTIMIZATION:
		// We first check against the last added itemset 
		// If there is a last added itemset and it has the same support
		if (lastAddedItemsetNode != null
				&& lastAddedItemsetNode.counter == headWithPSupport) {
			boolean isSubset = issASubsetOfPrefixPath(headWithP, headWithPLength, lastAddedItemsetNode);
			// if the itemset is a subset of the last added itemset, we do not need to check further
			if(isSubset) {
				return false;
			}
		}
		

		// Find the node list for the first item of the itemset
		Integer firstITem = headWithP[headWithP.length-1];
		
		// OTHERWISE, WE NEED TO COMPARE "headwithP" with all the patterns in the CFI-tree.
		CFINode node = mapItemNodes.get(firstITem);
		// if that last item is not yet in the CFI-tree, it means that "itemset" is not a subset 
		// of some itemset already in the tree
		if(node == null) {
			return true;
		}
		// we will loop over each node by following node links
		do {
			// for a node, we will check if "headwithP" is a subset of the path ending at node
			boolean isSubset = node.counter == headWithPSupport 
					&& issASubsetOfPrefixPath(headWithP, headWithPLength, node);
			// if it is a subset, then "headWithP" is in the CFI-tree, we return false
			if(isSubset) {   
				return false;
			}
			// go to the next itemset to test
			node = node.nodeLink;
		}while(node != null);

		// the itemset is not in the CFI-TREE.  Itemset passed the test!
		return true;
	}

	/**
	 * Check if the itemset headwithP is contained in the path ending at "node" in the CFI-tree
	 * and have the same support
	 * @param headWithP the itemset headwithP
	 * @param headWithPLength the last position to be considered in headWithP
	 * @param node  the node
	 * @param the support of the itemset headwithP 
	 * @return true if "headwithP" is contained in the path ending at "node" in the CFI-Tree and has the same support.
	 * Otherwise, false.
	 */
	private boolean issASubsetOfPrefixPath(int[] headWithP, int headWithPLength,CFINode node) {
		// optimization proposed in the fpmax* paper: if there is less than itemset node in that branch,
		// we don't need to check it
		if(node.level >= headWithPLength) {
			// check if "itemset" is contained in the prefix path ending at "node"
			// We will start comparing from the parent of "node" in the prefix path since
			// the last item of itemset is "node".
			CFINode nodeToCheck = node;
			int positionInItemset = headWithP.length-1;
			int itemToLookFor = headWithP[positionInItemset];
			// for each item in itemset
			do {
				if(nodeToCheck.itemID == itemToLookFor) {
					positionInItemset--;
					// we found the itemset completely, so the subset check test is failed
					if(positionInItemset < 0) {
						return true;
					}
					itemToLookFor = headWithP[positionInItemset];
				}
				nodeToCheck = nodeToCheck.parent;
			}while(nodeToCheck != null);
		}
		return false;
	}
	
	
	@Override
	/**
	 * Method for getting a string representation of the CP-tree 
	 * (to be used for debugging purposes).
	 * @return a string
	 */
	public String toString() {
		return "M"+root.toString("");
	}

	
	//========================= METHODS NOT USED  BY FPCLOSE =============================/
	
	/**
	 * This method calculate the support of any frequent itemset by using the CFI-tree containing all the
	 * frequent closed itemsets. 
	 * Note that this method assumes that all frequent closed itemsets are stored in the CFI-tree.
	 * 
	 * **** It is not used by FPClose***. 
	 * 
	 * It is instead designed for algorithms
	 * that use the CFI-tree generated by FPClose such as the algorithm for generating closed
	 * association rules.
	 * @param itemset the itemset that we want to calculate the support
	 * @return the support of that itemset as a number of transaction
	 */
	public int calculateSupport(int[] itemset) {
		// Find the node list for the first item of the itemset
		Integer firstITem = itemset[itemset.length-1];
		
		// OTHERWISE, WE NEED TO COMPARE "headwithP" with all the patterns in the CFI-tree.
		CFINode node = mapItemNodes.get(firstITem);

		// we will loop over each node by following node links
		do {
			// for a node, we will check if "headwithP" is a subset of the path ending at node
			if(issASubsetOfPrefixPath(itemset, itemset.length, node)){
				return node.counter;
			}
			// go to the next itemset to test
			node = node.nodeLink;
		}while(node != null);

		throw new Error("CFI-Tree: itemset not found. This should not happen");
	}


}
