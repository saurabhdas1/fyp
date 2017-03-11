/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal.year.algorithms;

import java.util.HashMap;
import java.util.Map;


/**
 * This class is used to rename items in a datasets.
 * It is used by several algorithms that use a total order, which
 * is different from the alphabetical or lexicographical order. 
 * By renaming items with consecutive names, it allows several optimization
 * such as faster comparison between items by using the > < == operators.
 *
 * @author Saurabh Das
 */

public class ItemNameConverter {
    /** This structure is used for converting new names to old names.
	 *  The i-th position contains the old item name corresponding to the new name "i" **/
	int[] newNamesToOldNames;
	/** This structure is used for converting old names to new names.
	 *  The key is an old name. The value is a new name **/
	Map<Integer, Integer> oldNamesToNewNames;
	
	/** this variable is the next new name that will be given*/
	int currentIndex;
	
	/**
	 * Constructor
	 * @param itemCount we have to specify the number of items in the dataset.
	 */
	public ItemNameConverter(int itemCount) {
		// initialize the internal data structures
		newNamesToOldNames = new int[itemCount+1];
		oldNamesToNewNames = new HashMap<Integer, Integer>(itemCount);
		currentIndex = 1;
	}
	
	/**
	 * This method takes an old name as parameter and create a new name.
	 * @param oldName the old name
	 * @return the new name
	 */
	public int assignNewName(int oldName) {
		// we give the new name "currentIndex"
		int newName = currentIndex;
		oldNamesToNewNames.put(oldName, newName);
		// we store the old name so that we may convert back to old name if needed
		newNamesToOldNames[newName] = oldName;
		// we increase this variable so that the value + 1 will be the next new name
		// to be given
		currentIndex++;
		// we return the new name
		return newName;
	}
	
	/**
	 * Convert an old name to the corresponding new name.
	 * @param oldName an old name
	 * @return the corresponding new name or null, if no new name exists for that old name.
	 */
	public int toNewName(int oldName) {
		return oldNamesToNewNames.get(oldName);
	}
	
	/**
	 * Convert an old name to the corresponding new name.
	 * @param oldName an old name
	 * @return the corresponding new name or null, if no new name exists for that old name.
	 */
	public int toOldName(int newName) {
		return newNamesToOldNames[newName];
	}

	
}
