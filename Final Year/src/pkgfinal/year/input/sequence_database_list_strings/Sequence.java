package pkgfinal.year.input.sequence_database_list_strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import pkgfinal.year.input.sequence_database_array_integers.SequenceDatabase;

/**
 * Implementation of a sequence as a list of itemsets, where an itemset is a list of strings.
*
* @see SequenceDatabase
 * @author Saurabh Das
 */
public class Sequence{
	
	/** A sequence is a list of itemsets, 
	 * where an itemset is a list of strings
	 */
	private final List<List<String>> itemsets = new ArrayList<List<String>>();
	/** id of this sequence */
	private int id; 
	
	/**
	 * Constructor of a sequence
	 * @param id a sequence id that should be unique.
	 */
	public Sequence(int id){
		this.id = id;
	}

	/**
	 * Add an itemset to this sequence.
	 * @param itemset An itemset (list of strings).
	 */
	public void addItemset(List<String> itemset) {
		itemsets.add(itemset);
	}
	
	/**
	 * Print this sequence to System.out.
	 */
	public void print() {
		System.out.print(toString());
	}
	
	/**
	 * Return a string representation of this sequence.
	 */
	public String toString() {
		StringBuilder r = new StringBuilder("");
		// for each itemset
		for(List<String> itemset : itemsets){
			r.append('(');
			// for each item in the current itemset
			for(String item : itemset){
				r.append( item);
				r.append(' ');
			}
			r.append(')');
		}

		return r.append("    ").toString();
	}
	
	/**
	 * Get the sequence ID of this sequence.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Get the list of itemsets in this sequence
	 * @return A list of itemsets.
	 */
	public List<List<String>> getItemsets() {
		return itemsets;
	}
	
	/**
	 * Get the itemset at a given position in this sequence
	 * @param index the position
	 * @return the itemset as a list of strings.
	 */
	public List<String> get(int index) {
		return itemsets.get(index);
	}
	
	/**
	 * Get the size of this sequence (number of itemsets).
	 * @return the size (an integer).
	 */
	public int size(){
		return itemsets.size();
	}

	/**
	 * Make a copy of this sequence while removing some items
	 * that are infrequent with respect to a threshold minsup.
	 * @param mapSequenceID a map with key = item  value = a set of sequence ids containing this item
	 * @param relativeMinSup the minimum support threshold chosen by the user.
	 * @return a copy of this sequence except that item(s) with a support lower than minsup have been excluded.
	 */
	public Sequence cloneSequenceMinusItems(Map<String, Set<Integer>> mapSequenceID, double relativeMinSup) {
		// create a new sequence
		Sequence sequence = new Sequence(getId());
		// for each  itemset in the original sequence
		for(List<String> itemset : itemsets){
			// call a method to copy this itemset
			List<String> newItemset = cloneItemsetMinusItems(itemset, mapSequenceID, relativeMinSup);
			// add the copy to the new sequence
			if(newItemset.size() !=0){ 
				sequence.addItemset(newItemset);
			} 
		}
		return sequence; // return the new sequence
	}
	
	/**
	 * Make a copy of an itemset while removing some items
	 * that are infrequent with respect to a threshold minsup.
	 * @param mapSequenceID a map with key = item  value = a set of sequence ids containing this item
	 * @param relativeMinsup the minimum support threshold chosen by the user.
	 * @return a copy of this itemset except that item(s) with a support lower than minsup have been excluded.
	 */
	public List<String> cloneItemsetMinusItems(List<String> itemset,Map<String, Set<Integer>> mapSequenceID, double relativeMinsup) {
		// create a new itemset
		List<String> newItemset = new ArrayList<String>();
		// for each item of the original itemset
		for(String item : itemset){
			// if the support is enough
			if(mapSequenceID.get(item).size() >= relativeMinsup){
				newItemset.add(item); // add it to the new itemset
			}
		}
		return newItemset; // return the new itemset.
	} 

}
