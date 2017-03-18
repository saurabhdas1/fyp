package pkgfinal.year.gui.patternvizualizer.filters;

/**
 * This class is a filter for selecting only patterns having a double value equal to a given value.
 * 
 * @author Saurabh Das
 */
public class FilterEqualDouble extends AbstractFilter{
	/** the given value*/
	double value;
	
	/**
	 * Constructor
	 * @param value the given value
	 * @param columnName the colum the filter is applied to
	 * @param columnID the index of the column that the filter is applied to
	 */
	public FilterEqualDouble(double value, String columnName, int columnID){
		super(columnName, columnID);
		this.value = value;
	}

	/**
	 * Get the name of this filter
	 * @return the name
	 */
	public static String getFilterGenericName() {
		return " is equal to:";
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
		return ((Double) object) ==  value;
	}

	/**
	 * Get the Class that this filter is applicable to (e.g. Integer.class)
	 * @return a Class object
	 */
	static Class getApplicableClass() {
		return Double.class;
	}

}
