/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal.year.patterns.itemset_array_integers_with_count;

import java.util.List;

import pkgfinal.year.algorithms.ArraysAlgos;
import pkgfinal.year.patterns.AbstractOrderedItemset;


/**
 * This class represents an itemset (a set of items) implemented as an array of integers with
 * a variable to store the support count of the itemset.
* 
 * @author Saurabh Das
 */

public class Itemset extends AbstractOrderedItemset{
	/** the array of items **/
	public int[] itemset; 

	/**  the support of this itemset */
	public int support = 0; 
	
	/**
	 * Get the items as array
	 * @return the items
	 */
	public int[] getItems() {
		return itemset;
	}
	
	/**
	 * Constructor
	 */
	public Itemset(){
		itemset = new int[]{};
	}
	
	/**
	 * Constructor 
	 * @param item an item that should be added to the new itemset
	 */
	public Itemset(int item){
		itemset = new int[]{item};
	}

	/**
	 * Constructor 
	 * @param items an array of items that should be added to the new itemset
	 */
	public Itemset(int [] items){
		this.itemset = items;
	}
	
	/**
	 * Constructor 
	 * @param items a list of Integer representing items in the itemset
	 * @param support the support of the itemset
	 */
	public Itemset(List<Integer> itemset, int support){
		this.itemset = new int[itemset.size()];
	    int i = 0;
	    for (Integer item : itemset) { 
	    	this.itemset[i++] = item.intValue();
	    }
	    this.support = support;
	}
	
	/**
	 * Get the support of this itemset
	 */
	public int getAbsoluteSupport(){
		return support;
	}
	
	/**
	 * Get the size of this itemset 
	 */
	public int size() {
		return itemset.length;
	}

	/**
	 * Get the item at a given position in this itemset
	 */
	public Integer get(int position) {
		return itemset[position];
	}

	/**
	 * Set the support of this itemset
	 * @param support the support
	 */
	public void setAbsoluteSupport(Integer support) {
		this.support = support;
	}

	/**
	 * Increase the support of this itemset by 1
	 */
	public void increaseTransactionCount() {
		this.support++;
	}


	/**
	 * Make a copy of this itemset but exclude a given item
	 * @param itemToRemove the given item
	 * @return the copy
	 */
	public Itemset cloneItemSetMinusOneItem(Integer itemToRemove) {
		// create the new itemset
		int[] newItemset = new int[itemset.length -1];
		int i=0;
		// for each item in this itemset
		for(int j =0; j < itemset.length; j++){
			// copy the item except if it is the item that should be excluded
			if(itemset[j] != itemToRemove){
				newItemset[i++] = itemset[j];
			}
		}
		return new Itemset(newItemset); // return the copy
	}
	

	/**
	 * Make a copy of this itemset but exclude a set of items
	 * @param itemsetToNotKeep the set of items to be excluded
	 * @return the copy
	 */
	public Itemset cloneItemSetMinusAnItemset(Itemset itemsetToNotKeep) {
		// create a new itemset
		int[] newItemset = new int[itemset.length - itemsetToNotKeep.size()];
		int i=0;
		// for each item of this itemset
		for(int j =0; j < itemset.length; j++){
			// copy the item except if it is not an item that should be excluded
			if(itemsetToNotKeep.contains(itemset[j]) == false){
				newItemset[i++] = itemset[j];
			}
		}
		return new Itemset(newItemset); // return the copy
	}
	
	/**
	 * This method return an itemset containing items that are included
	 * in this itemset and in a given itemset
	 * @param itemset2 the given itemset
	 * @return the new itemset
	 */
	public Itemset intersection(Itemset itemset2) {
		int [] intersection = ArraysAlgos.intersectTwoSortedArrays(this.getItems(), itemset2.getItems());
		return new Itemset(intersection);
	}
}
