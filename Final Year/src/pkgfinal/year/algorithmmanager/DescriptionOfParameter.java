/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal.year.algorithmmanager;

/**
 * This class is used to describe an algorithm's parameter.
 * 
 * @see DescriptionOfAlgorithm
 * @author Saurabh Das
 */
public class DescriptionOfParameter {
    /** name of this parameter */
	public final String name;
	/** example value for this parameter */
	public final String example;
	/** type of parameter value */
	public final Class parameterType;
	/** this parameter is optional or not? */
	public final boolean isOptional;
	
	/**
	 * Constructor for this parameter
	 * @param name  the name of the parameter (a string)
	 * @param example a string providing an example value that this parameter could take
	 * @param parameterType the type of this parameter (e.g. Integer.class, Double.class, String.class...)
	 */
	public DescriptionOfParameter(String name, String example, Class parameterType, boolean isOptional){
		this.name = name;
		this.example = example;
		this.parameterType = parameterType;
		this.isOptional = isOptional;
	}
	
	@Override
	/**
	 * Obtain a String representation of this parameter description
	 * @return a String
	 */
	public String toString() {
		return "[" + name + ", " + example + ", " + parameterType + ", isOptional = " + isOptional + " ]";
	}

}

