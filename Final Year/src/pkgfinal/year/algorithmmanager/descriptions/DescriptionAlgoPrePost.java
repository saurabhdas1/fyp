package pkgfinal.year.algorithmmanager.descriptions;

import java.io.IOException;

import pkgfinal.year.algorithmmanager.DescriptionOfAlgorithm;
import pkgfinal.year.algorithmmanager.DescriptionOfParameter;

import pkgfinal.year.algorithms.frequentpatterns.fin_prepost.PrePost;

/**
 * This class describes the PrePost algorithm parameters. 
 * It is designed to be used by the graphical and command line interface.
 * 
 * @see PrePost
 * @author Saurabh Das
 */
public class DescriptionAlgoPrePost extends DescriptionOfAlgorithm {

	/**
	 * Default constructor
	 */
	public DescriptionAlgoPrePost(){
	}

	@Override
	public String getName() {
		return "PrePost";
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
		PrePost prepost = new PrePost();
		prepost.runAlgorithm(inputFile, minsup, outputFile);
		prepost.printStats();
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
