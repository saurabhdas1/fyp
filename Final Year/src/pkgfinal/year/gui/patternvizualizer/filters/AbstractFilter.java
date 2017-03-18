package pkgfinal.year.gui.patternvizualizer.filters;


/**
 * This class represents a filter for sorting patterns in the pattern vizualizer window.
 * It stores the column that the filter is applied to, and also the index of this column.
 * 
 * @author Saurabh Das
 */
public abstract class AbstractFilter{
	/** The column that the filter is applied to */
	String columnName;
	/** The index of the column that the filter is applied to */
	int columnID;
	
	/**
	 * Constructor
	 * @param columnName the column that the filter is applied to 
	 * @param columnID the index of the column that the filter is applied to
	 */
	AbstractFilter(String columnName, int columnID){
		this.columnName = columnName;
		this.columnID = columnID;
	}
	
	/**
	 * Abstract method to determine if an object should be kept according to the filter
	 * @param object  the object
	 * @return true if the object should be kept. Otherwise, false.
	 */
	public abstract boolean isKept(Object object);
	
	/**
	 * Get the name of the column that this filter is applied to
	 * @return the name of the column
	 */
	public String getColumnName(){
		return columnName;
	}
	
	/**
	 * Get the index of the column that this filter is applied to
	 * @return the index of the column (an integer >=0)
	 */
	public int getColumnID(){
		return columnID;
	}
	
	/**
	 * Get a string representation of this filter including the given value and column name
	 * @return a string representation of the filter indicating the filter name, given value and column name.
	 */
	public abstract String getFilterWithParameterName();

}
