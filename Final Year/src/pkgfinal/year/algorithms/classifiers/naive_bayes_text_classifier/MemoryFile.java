package pkgfinal.year.algorithms.classifiers.naive_bayes_text_classifier;
import java.util.ArrayList;
/**
* This is an implementation of the Naive Bayes Document Classifier algorithm. 
* 
* @author Saurabh Das
*/

public class MemoryFile {
String classname;
String fileName;
ArrayList<String> content;
public String getClassname() {
	return classname;
}
public void setClassname(String classname) {
	this.classname = classname;
}
public String getFileName() {
	return fileName;
}
public void setFileName(String fileName) {
	this.fileName = fileName;
}
public ArrayList<String> getContent() {
	return content;
}
public void setContent(ArrayList<String> content) {
	this.content = content;
}
}
