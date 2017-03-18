package pkgfinal.year.algorithms.classifiers.naive_bayes_text_classifier;
import java.util.ArrayList;

/** 
* This is an implementation of the Naive Bayes Document Classifier algorithm. 
* 
* @author Saurabh Das
*/

public class TestRecord {
private int recordId;
private String fullRecord;

private ArrayList<String> words;
public int getRecordId() {
	return recordId;
}
public ArrayList<String> getWords() {
	return words;
}	
public void setWords(ArrayList<String> words) {
	this.words = words;
}
public void setRecordId(int recordId) {
	this.recordId = recordId;
}
public String getFullRecord() {
	return fullRecord;
}
public void setFullRecord(String fullRecord) {
	this.fullRecord = fullRecord;
}
}
