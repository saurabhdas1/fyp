package pkgfinal.year.algorithms.frequentpatterns.eclat;

import java.util.HashSet;
import java.util.Set;

import pkgfinal.year.datastructures.triangularmatrix.TriangularMatrix;
import pkgfinal.year.input.transaction_database_list_integers.TransactionDatabase;
import pkgfinal.year.patterns.itemset_array_integers_with_count.Itemset;
import pkgfinal.year.patterns.itemset_array_integers_with_count.Itemsets;
import pkgfinal.year.tools.MemoryLogger;
 

/**
 * This is a version of the dECLAT algorithm. It uses sets of integers to represent tidsets. It 
 * extends the class AlgoDEclat to avoid redundancy of common code.
 * Note than unlike Eclat, dEclat returns itemsets annotated with diffsets instead of tidsets.
 * About implementation details, note that this implementation uses tidsets initially for single items, 
 * then it uses diffsets starting from itemsets containing two itemsets (2-itemsets).
 * 
 * See this article for details about dECLAT:
 * <br/><br/>
 * 
 * Zaki, M.J., Gouda, K.: Fast vertical mining using diffsets. Technical Report 01-1, Computer Science Dept., Rensselaer Polytechnic Institute (March 2001) 10
 * <br/><br/>
 * 
 * This  version  saves the result to a file
 * or keep it into memory if no output path is provided
 * by the user to the runAlgorithm method().
 * 
 * @see TriangularMatrix
 * @see TransactionDatabase
 * @see Itemset
 * @see Itemsets
 * @author Saurabh Das
 */
public class AlgoDEclat extends AlgoEclat{
	
	

	/**
	 * Print statistics about the algorithm execution to System.out.
	 */
	public void printStats() {
		System.out.println("=============  dECLAT v0.96r18 - STATS =============");
		long temps = endTime - startTimestamp;
		System.out.println(" Transactions count from database : "
				+ database.size());
		System.out.println(" Frequent itemsets count : "
				+ itemsetCount);
		System.out.println(" Total time ~ " + temps + " ms");
		System.out.println(" Maximum memory usage : "
				+ MemoryLogger.getInstance().getMaxMemory() + " mb");
		System.out.println("===================================================");
	}
	
	/**
	 * This method performs the calculation of a new diffset by merging two tidsets.
	 * Tidsets are used for single items and when we make 2-itemsets, we switch to diffsets.
	 * @param tidsetI the first tidset/diffset
	 * @param supportI  the cardinality of the first tidset/diffset
	 * @param tidsetJ  the second tidset/diffset
	 * @param supportJ the cardinality of the second tidset/diffset
	 * @return the resulting tidset.
	 */
	 Set<Integer> performANDFirstTime(Set<Integer> tidsetI, int supportI,
			Set<Integer> tidsetJ, int supportJ) {
		// Create the new tidset that will store the difference
		Set<Integer> diffsetIJ = new HashSet<Integer>();
		// for each tid containing j
		for(Integer tid : tidsetI) {
			// if the transaction does not contain i, add it to the diffset
			if(tidsetJ.contains(tid) == false) {
				// add it to the intersection
				diffsetIJ.add(tid);
			}			
		}
		// return the new tidset
		return diffsetIJ;
	}

	/**
	 * This method performs the calculation of a new diffset by merging two tidsets/diffsets.
	 * @param tidsetI the first tidset/diffset
	 * @param supportI  the cardinality of the first tidset/diffset
	 * @param tidsetJ  the second tidset/diffset
	 * @param supportJ the cardinality of the second tidset/diffset
	 * @return the resulting tidset.
	 */
	 Set<Integer> performAND(Set<Integer> tidsetI, int supportI,
			Set<Integer> tidsetJ, int supportJ) {
		// Create the new tidset that will store the difference
		Set<Integer> diffsetIJ = new HashSet<Integer>();
		// for each tid containing j
		for(Integer tid : tidsetJ) {
			// if the transaction does not contain i, add it to the diffset
			if(tidsetI.contains(tid) == false) {
				// add it to the intersection
				diffsetIJ.add(tid);
			}			
		}
		// return the new tidset
		return diffsetIJ;
	}
	
	/**
	 * Calculate the support of an itemset X using the tidset of X if the size = 1. Otherwise uses diffsets
	 * to calculate the support
	 * @param lengthOfX  the length of the itemset X - 1 (used by dEclat)
	 * @param supportPrefix the support of the prefix (not used by Eclat, but used by dEclat).
	 * @param tidsetI the tidset of X
	 * @return the support
	 */
	int calculateSupport(int lengthOfX, int supportPrefix,  Set<Integer> tidsetX) {
		// if length of prefix = 1 then we are using tidsets
		if(lengthOfX == 1) {
			return tidsetX.size();
		}else {
			// otherwise we are using diffsets
			return supportPrefix - tidsetX.size();
		}
	}

}
