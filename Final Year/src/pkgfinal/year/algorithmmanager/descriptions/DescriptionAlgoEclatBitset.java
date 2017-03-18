package pkgfinal.year.algorithmmanager.descriptions;

import java.io.IOException;

import pkgfinal.year.algorithmmanager.DescriptionOfAlgorithm;
import pkgfinal.year.algorithmmanager.DescriptionOfParameter;
import pkgfinal.year.algorithms.frequentpatterns.eclat.AlgoEclat_Bitset;
import pkgfinal.year.input.transaction_database_list_integers.TransactionDatabase;


/**
 * This class describes the EclatBitset algorithm parameters. 
 * It is designed to be used by the graphical and command line interface.
 * 
 * @see AlgoEclat_Bitset
 * @author Saurabh Das
 */
public class DescriptionAlgoEclatBitset extends DescriptionOfAlgorithm {

	/**
	 * Default constructor
	 */
	public DescriptionAlgoEclatBitset(){
	}

	@Override
	public String getName() {
		return "Eclat_bitset";
	}

	@Override
	public String getAlgorithmCategory() {
		return "FREQUENT ITEMSET MINING";
	}

	@Override
	public String getURLOfDocumentation() {
		return "";
	}

	@Override
	public void runAlgorithm(String[] parameters, String inputFile, String outputFile) throws IOException {
		double minsup = getParamAsDouble(parameters[0]);

		// Loading the transaction database
		TransactionDatabase database = new TransactionDatabase();
		try {
			database.loadFile(inputFile);
		} catch (IOException e) {
			e.printStackTrace();
		}

		AlgoEclat_Bitset algo = new AlgoEclat_Bitset();
		
		if (parameters.length >=2 && "".equals(parameters[1]) == false) {
			algo.setShowTransactionIdentifiers(getParamAsBoolean(parameters[1]));
		}
		
		algo.runAlgorithm(outputFile, database, minsup, true);
		algo.printStats();
	}

	@Override
	public DescriptionOfParameter[] getParametersDescription() {
        
		DescriptionOfParameter[] parameters = new DescriptionOfParameter[2];
		parameters[0] = new DescriptionOfParameter("Minsup (%)", "(e.g. 0.4 or 40%)", Double.class, false);
		parameters[1] = new DescriptionOfParameter("Show transaction ids?", "(default: false)", Boolean.class, true);
return parameters;
	}

	@Override
	public String getImplementationAuthorNames() {
		return "Saurabh Das";
	}

	@Override
	public String[] getInputFileTypes() {
		return new String[]{"Database of instances","Transaction database", "Simple transaction database"};
	}

	@Override
	public String[] getOutputFileTypes() {
		return new String[]{"Patterns", "Frequent patterns", "Frequent itemsets"};
	}
	
}
