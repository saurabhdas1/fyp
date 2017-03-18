package pkgfinal.year.algorithms.classifiers.naive_bayes_text_classifier;
import java.util.HashMap;

/** 
* This is an implementation of the Naive Bayes Document Classifier algorithm. 
* 
* @author Saurabh Das
*/
public class OccurrenceProbabilties {
	private String className;
	private HashMap<String,Double> occuranceMap;
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public HashMap<String, Double> getOccuranceMap() {
		return occuranceMap;
	}
	public void setOccuranceMap(HashMap<String, Double> occuranceMap) {
		this.occuranceMap = occuranceMap;
	}
}
