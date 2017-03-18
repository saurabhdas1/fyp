package pkgfinal.year.algorithmmanager.descriptions;

import java.io.IOException;

import pkgfinal.year.algorithmmanager.DescriptionOfAlgorithm;
import pkgfinal.year.algorithmmanager.DescriptionOfParameter;
import pkgfinal.year.algorithms.frequentpatterns.fin_prepost.FIN;


/**
 * This class describes the FIN algorithm parameters. 
 * It is designed to be used by the graphical and command line interface.
 * 
 * @see FIN
 * @author Saurabh Das
 */
public class DescriptionAlgoFIN extends DescriptionOfAlgorithm {

	/**
	 * Default constructor
	 */
	public DescriptionAlgoFIN(){
	}

	@Override
	public String getName() {
		return "FIN";
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
		FIN algo = new FIN();
		algo.runAlgorithm(inputFile, minsup, outputFile);
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
		return "Zhihong Deng";
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
