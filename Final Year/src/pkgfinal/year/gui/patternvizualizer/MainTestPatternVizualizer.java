package pkgfinal.year.gui.patternvizualizer;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.text.ParseException;


/**
 * Class for testing the pattern vizualizer window using the "output.txt" file provided in this directory.
 * 
 * @author Saurabh Das
 */
public class MainTestPatternVizualizer {

	public static void main(String[] args) throws ParseException, IOException {
		// the path of the file containing patterns for this test
		String patternFilePath = fileToPath("test.txt");
		
		// create the frame
		PatternVizualizer frame = new PatternVizualizer(patternFilePath);
		frame.setVisible(true);
	}
	
	public static String fileToPath(String filename) throws UnsupportedEncodingException{
		URL url = MainTestPatternVizualizer.class.getResource(filename);
		 return java.net.URLDecoder.decode(url.getPath(),"UTF-8");
	}
}
