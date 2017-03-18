package pkgfinal.year.algorithmmanager.descriptions;

import java.io.IOException;
import java.util.List;

import pkgfinal.year.algorithmmanager.DescriptionOfAlgorithm;
import pkgfinal.year.algorithmmanager.DescriptionOfParameter;
import pkgfinal.year.algorithms.timeseries.TimeSeries;
import pkgfinal.year.algorithms.timeseries.reader_writer.AlgoTimeSeriesReader;
import pkgfinal.year.gui.timeseriesviewer.TimeSeriesViewer;

/**
 * This class describes the algorithm to visualize a time series.
 * 
 * @see TimeSeriesViewer
 * @author Saurabh Das
 */
public class DescriptionAlgoTimeSeriesViewer extends DescriptionOfAlgorithm {

	/**
	 * Default constructor
	 */
	public DescriptionAlgoTimeSeriesViewer(){
	}

	@Override
	public String getName() {
		return "Vizualize_time_series";
	}

	@Override
	public String getAlgorithmCategory() {
		return "TIME SERIES MINING";
	}

	@Override
	public String getURLOfDocumentation() {
		return "";
	}

	@Override
	public void runAlgorithm(String[] parameters, String inputFile, String outputFile) throws IOException {

		String separator;
		if (parameters.length > 0 && "".equals(parameters[0]) == false) {
			separator = getParamAsString(parameters[0]);
		}else{
			separator = " ";
		}
		
		AlgoTimeSeriesReader reader = new AlgoTimeSeriesReader();
		List<TimeSeries> timeSeries = reader.runAlgorithm(inputFile, separator);

		TimeSeriesViewer viewer = new TimeSeriesViewer(timeSeries);
		viewer.setVisible(true);
	}

	@Override
	public DescriptionOfParameter[] getParametersDescription() {
        
		DescriptionOfParameter[] parameters = new DescriptionOfParameter[1];
		parameters[0] = new DescriptionOfParameter("separator", "(e.g. ',' , default: ' ')", String.class, true);
		return parameters;
	}

	@Override
	public String getImplementationAuthorNames() {
		return "Saurabh Das";
	}

	@Override
	public String[] getInputFileTypes() {
		return new String[]{"Time series database"};
	}

	@Override
	public String[] getOutputFileTypes() {
		return null;
	}

	
}
