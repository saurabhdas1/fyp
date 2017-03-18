package pkgfinal.year.algorithmmanager.descriptions;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import pkgfinal.year.algorithmmanager.DescriptionOfAlgorithm;
import pkgfinal.year.algorithmmanager.DescriptionOfParameter;

import pkgfinal.year.algorithms.frequentpatterns.charm.AlgoCharm_Bitset;
import pkgfinal.year.input.transaction_database_list_integers.TransactionDatabase;

/**
 * This class describes the CharmBitset algorithm parameters. 
 * It is designed to be used by the graphical and command line interface.
 * 
 * @see AlgoCharm_Bitset
 * @author Saurabh Das
 */
public class DescriptionAlgoCharmBitset extends DescriptionOfAlgorithm {

	/**
	 * Default constructor
	 */
	public DescriptionAlgoCharmBitset(){
	}

	@Override
	public String getName() {
		return "Charm_bitset";
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
		AlgoCharm_Bitset algo = new AlgoCharm_Bitset();

		TransactionDatabase database = new TransactionDatabase();
		try {
			database.loadFile(inputFile);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if (parameters.length >=2 && "".equals(parameters[1]) == false) {
			algo.setShowTransactionIdentifiers(getParamAsBoolean(parameters[1]));
		}
		
		algo.runAlgorithm(outputFile, database, minsup, true, 10000);
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
		return new String[]{"Patterns", "Frequent patterns", "Frequent closed itemsets"};
	}
	
}
