package pkgfinal.year.tools.dataset_converter;


/**
 * Enumeration of the data formats that can be read by the database
 * converters. All output are to the PASD format.
 * <br/><br/>
 * For a sequence database, the following format can be converted to PASD:
 * CSV, IBMGenerator, Kosarak, Snake and BMS (see documentation for a description
 * of these formats).
 * <br/><br/>
 * For a transaction database, the following format can be converted to PASD:
 * CSV, ARF

@see TransactionDatabaseConverter
@see SequenceDatabaseConverter
* @author Saurabh Das
*/
public enum Formats {
	PASD, CSV_INTEGER, IBMGenerator, Kosarak, Snake, BMS, 
	ARFF, ARFF_WITH_MISSING_VALUES, PASD_SEQUENCE_DB, PASD_TRANSACTION_DB, TEXT
}
