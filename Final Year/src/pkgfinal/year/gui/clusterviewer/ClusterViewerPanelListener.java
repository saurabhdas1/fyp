package pkgfinal.year.gui.clusterviewer;

import java.awt.Color;



/**
 * This interface should be implemented by classes that want to listen to a ClusterViewerPanel.
 * 
 * This class follows the "listener" design pattern.
 * 
 * @author Saurabh Das
 */
public interface ClusterViewerPanelListener {
	/** 
	 * Notify listeners of the new chart position
	 * @param x the x coordinate
	 * @param y the y coordinate
	 * @param colorUnderMouse the color of the pixel under the mouse
	 * @param objectUnderMouse 
	 */
    void notifyOfNewMousePosition(double x, double y, Color colorUnderMouse, String objectUnderMouse);

    /**
     * Notify listeners that the mouse is outside of the chart
     */
	void notifyMouseOutOfChart();
}