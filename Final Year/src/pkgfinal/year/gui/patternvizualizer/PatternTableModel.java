package pkgfinal.year.gui.patternvizualizer;

import java.util.ArrayList;
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 * This is a TableModel for storing patterns in the JTable of the pattern vizualizer window
 * @author Saurabh Das
 *
 */
class PatternTableModel implements TableModel {
	
	/** a list of rows stored in the table, where each row (pattern) is a list of Objects*/
	List<List<Object>> data;
	/** the column names for this table*/
	List<String> columnNames;
	/** the column classes for this table*/
	List<Class> columnClasses;
	/** A list of listener for this TableModel */
	List<TableModelListener> listeners = new ArrayList<TableModelListener>();
	
	/**
	 * Constructor
	 * @param data  the list of rows
	 * @param columnNames the column names
	 * @param columnClasses the column classes
	 */
	public PatternTableModel(List<List<Object>> data, List<String> columnNames, List<Class> columnClasses){
		this.data = data;
		this.columnNames = columnNames;
		this.columnClasses = columnClasses;
	}

	@Override
	/**
	 * Add a listener to this TableModel
	 * @param listener a TableModelListener
	 */
	public void addTableModelListener(TableModelListener listener) {
		listeners.add(listener);
	}

	@Override
	/**
	 * Get the class of objects stored in the i-th column.
	 * @param int the index "i"
	 * @retur a Class object
	 */
	public Class<?> getColumnClass(int columnIndex) {
		return columnClasses.get(columnIndex);
	}

	@Override
	/**
	 * Get the number of columns
	 * @return the number of columns
	 */
	public int getColumnCount() {
		return columnNames.size();
	}

	@Override
	/**
	 * Get the name of the column at a given index
	 * @param columnIndex the index of the column
	 */
	public String getColumnName(int columnIndex) {
		return columnNames.get(columnIndex);
	}

	@Override
	/**
	 * Get the number of rows in that TableModel
	 * @return the number of rows
	 */
	public int getRowCount() {
		return data.size();
	}

	@Override
	/**
	 * Get the value in a cell at a given column and row position.
	 * @param rowIndex the row index
	 * @param columnIndex the columnn index
	 */
	public Object getValueAt(int rowIndex, int columnIndex) {
		return data.get(rowIndex).get(columnIndex);
	}

	@Override
	/**
	 * Check if a given cell is editable or not
	 * @param rowIndex the row index of that cell
	 * @param columnIndex the columnn index of that cell
	 * @retur true if editable. Otherwise: false.
	 */
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	@Override
	/**
	 * Remove a TableModelListener
	 * @param listener the listener
	 */
	public void removeTableModelListener(TableModelListener listener) {
		listeners.remove(listener);
		
	}

	@Override
	/**
	 * Set the value in a cell
	 * @param rowIndex the row index of that cell
	 * @param columnIndex the columnn index of that cell
	 * @param aValue the value
	 */
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		data.get(rowIndex).set(columnIndex,(String) aValue);
	}
	
}