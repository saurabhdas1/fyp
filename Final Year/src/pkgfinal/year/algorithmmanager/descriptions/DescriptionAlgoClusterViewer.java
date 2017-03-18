package pkgfinal.year.algorithmmanager.descriptions;

import java.io.IOException;
import java.util.List;

import javax.swing.JOptionPane;

import pkgfinal.year.algorithmmanager.DescriptionOfAlgorithm;
import pkgfinal.year.algorithmmanager.DescriptionOfParameter;
import pkgfinal.year.algorithms.clustering.clusterreader.AlgoClusterReader;
import pkgfinal.year.algorithms.timeseries.TimeSeries;
import pkgfinal.year.algorithms.timeseries.reader_writer.AlgoTimeSeriesReader;
import pkgfinal.year.gui.clusterviewer.ClusterViewer;
import pkgfinal.year.gui.timeseriesviewer.TimeSeriesViewer;
import pkgfinal.year.patterns.cluster.Cluster;

/**
 * This class describes the algorithm to visualize a set of clusters.
 * 
 * @see TimeSeriesViewer
 * @author Philippe Fournier-Viger
 */
public class DescriptionAlgoClusterViewer extends DescriptionOfAlgorithm {

	/**
	 * Default constructor
	 */
	public DescriptionAlgoClusterViewer(){
	}

	@Override
	public String getName() {
		return "Vizualize_clusters_of_instances";
	}

	@Override
	public String getAlgorithmCategory() {
		return "CLUSTERING";
	}

	@Override
	public String getURLOfDocumentation() {
		return "";
	}

	@Override
	public void runAlgorithm(String[] parameters, String inputFile, String outputFile) throws IOException {

		
		// Applying the  algorithm
		AlgoClusterReader algorithm = new AlgoClusterReader();
		List<Cluster> clusters = algorithm.runAlgorithm(inputFile);
		List<String> attributeNames =  algorithm.getAttributeNames();
		
		// Otherwise, we use the cluster viewer
		ClusterViewer viewer = new ClusterViewer(clusters, attributeNames);
		viewer.setVisible(true);

	}

	@Override
	public DescriptionOfParameter[] getParametersDescription() {
        
		DescriptionOfParameter[] parameters = new DescriptionOfParameter[0];
		return parameters;
	}

	@Override
	public String getImplementationAuthorNames() {
		return "Philippe Fournier-Viger";
	}

	@Override
	public String[] getInputFileTypes() {
		return new String[]{"Clusters"};
	}


	@Override
	public String[] getOutputFileTypes() {
		return null;
	}

	
}
