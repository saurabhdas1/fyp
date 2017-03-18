package pkgfinal.year.algorithmmanager.descriptions;

import java.io.IOException;

import pkgfinal.year.algorithmmanager.DescriptionOfAlgorithm;
import pkgfinal.year.algorithmmanager.DescriptionOfParameter;
import pkgfinal.year.algorithms.frequentpatterns.eclat.AlgoDEclat_Bitset;
import pkgfinal.year.input.transaction_database_list_integers.TransactionDatabase;


/**
 * This class describes the DEclatbitset algorithm parameters. 
 * It is designed to be used by the graphical and command line interface.
 * 
 * @see AlgoDEclat_Bitset
 * @author Saurabh Das
 */
public class DescriptionAlgoDEclatBitset extends DescriptionOfAlgorithm {

	/**
	 * Default constructor
	 */
	public DescriptionAlgoDEclatBitset(){
	}

	@Override
	public String getName() {
		return "dEclat_bitset";
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

		AlgoDEclat_Bitset algo = new AlgoDEclat_Bitset();
		algo.runAlgorithm(outputFile, database, minsup, true);
		algo.printStats();
	}

	@Override
	public DescriptionOfParameter[] getParametersDescription() {
        
		DescriptionOfParameter[] parameters = new DescriptionOfParameter[1];
		parameters[0] = new DescriptionOfParameter("Minsup (%)", "(e.g. 0.4 or 40%)", Double.class, false);
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
