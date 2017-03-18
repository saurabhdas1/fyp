package pkgfinal.year.algorithms.timeseries;


import pkgfinal.year.patterns.cluster.DoubleArrayInstance;

/**
 * This class represent a time-series.
 * It simply extends the DoubleArrayInstance class.
 * In the future it could contain other information, specifically
 *  relevant for a time series.
 * 
 * @author Saurabh Das */
public class TimeSeries extends DoubleArrayInstance{


	/**
	 * Constructor
	 * @param dataPoints the data points of the time series
	 */
	public TimeSeries(double[] dataPoints, String name){
		super(dataPoints,name);
	}

}
