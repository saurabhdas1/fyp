package pkgfinal.year.algorithmmanager.descriptions;

import java.io.IOException;

import pkgfinal.year.algorithmmanager.DescriptionOfAlgorithm;
import pkgfinal.year.algorithmmanager.DescriptionOfParameter;
import pkgfinal.year.algorithms.frequentpatterns.fpgrowth.AlgoFPGrowth;


/**
 * This class describes the FPGrowth algorithm parameters. 
 * It is designed to be used by the graphical and command line interface.
 * 
 * @see AlgoFPGrowth
 * @author Saurabh Das
 */
public class DescriptionAlgoFPGrowth extends DescriptionOfAlgorithm {

	/**
	 * Default constructor
	 */
	public DescriptionAlgoFPGrowth(){
	}

	@Override
	public String getName() {
		return "FPGrowth_itemsets";
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
		AlgoFPGrowth algo = new AlgoFPGrowth();
		algo.runAlgorithm(inputFile, outputFile, minsup);
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
