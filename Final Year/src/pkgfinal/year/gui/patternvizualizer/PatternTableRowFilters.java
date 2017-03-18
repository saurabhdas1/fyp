package pkgfinal.year.gui.patternvizualizer;

import java.util.ArrayList;
import java.util.List;

import javax.swing.RowFilter;

import pkgfinal.year.gui.patternvizualizer.filters.AbstractFilter;

/**
 * This is a RowFilter subclass to filter patterns in the PatternTableModel used by the
 * pattern vizualizer window.
 * @author Saurabh Das
 *
 */
public class PatternTableRowFilters<PatternTableModel, Object> extends RowFilter {
	
	/** the current list of filters */
	public List<AbstractFilter> filters = new  ArrayList<AbstractFilter>();
	
	/**
	 * Default constructor */
	PatternTableRowFilters(){
	}
 
	@Override
	/** This method returns true if a given TableModel entry respects the filters. Otherwise,
	 * it returns false.
	 * @return true if a given TableModel entry respects the filters. Otherwise,
	 * it returns false.
	 */
	public boolean include(Entry entry) {

		// we apply each filter
		for(AbstractFilter filter : filters){
			// if the entry does not respect one of the filter, we reject it
			int columnIndex = filter.getColumnID();
			if(filter.isKept(entry.getValue(columnIndex))== false){
				return false;
			}
			
		}
		// otherwise we will keep that entry
		return true;
	}
}
