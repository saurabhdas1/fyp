package pkgfinal.year.gui.patternvizualizer.filters;

/**
 * This class is a filter for selecting only patterns having a boolean value equal to a given value.
 * 
 * @author Saurabh Das
 */
public class FilterEqualBoolean extends AbstractFilter{
	/** the required value*/
	boolean value;
	
	/**
	 * Constructor
	 * @param value the given value
	 * @param columnName the colum the filter is applied to
	 * @param columnID the index of the column that the filter is applied to
	 */
	public FilterEqualBoolean(boolean value, String columnName, int columnID){
		super(columnName, columnID);
		this.value = value;
	}

	/**
	 * Get the name of this filter
	 * @return the name
	 */
	public static String getFilterGenericName() {
		return " is equal to (true/false):";
	}

	/**
	 * Get a string representation of this filter including the given value and column name
	 * @return a string representation of the filter indicating the filter name, given value and column name.
	 */
	public String getFilterWithParameterName() {
		return "\"" + getColumnName() + "\" = " + value;
	}

	/**
	 * Abstract method to determine if an object should be kept according to the filter
	 * @param object  the object
	 * @return true if the object should be kept. Otherwise, false.
	 */
	public boolean isKept(Object object) {
		return ((Boolean) object) ==  value;
	}
	
	/**
	 * Get the Class that this filter is applicable to (e.g. Integer.class)
	 * @return a Class object
	 */
	static Class getApplicableClass() {
		return Boolean.class;
	}
}
