package pkgfinal.year.algorithmmanager.descriptions;

import java.io.IOException;

import pkgfinal.year.algorithmmanager.DescriptionOfAlgorithm;
import pkgfinal.year.algorithmmanager.DescriptionOfParameter;
import pkgfinal.year.algorithms.frequentpatterns.apriori.AlgoApriori;

/**
 * This class describes the Apriori algorithm parameters. 
 * It is designed to be used by the graphical and command line interface.
 * 
 * @see AlgoApriori
 * @author Saurabh Das
 */
public class DescriptionAlgoApriori extends DescriptionOfAlgorithm {

	/**
	 * Default constructor
	 */
	public DescriptionAlgoApriori(){
	}

	@Override
	public String getName() {
		return "Apriori";
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

		// Applying the Apriori algorithm, optimized version
		pkgfinal.year.algorithms.frequentpatterns.apriori.AlgoApriori apriori = new pkgfinal.year.algorithms.frequentpatterns.apriori.AlgoApriori();
		apriori.runAlgorithm(minsup, inputFile, outputFile);
		apriori.printStats();
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
