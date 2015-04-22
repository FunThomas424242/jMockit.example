package jmockit.example;

import java.text.DecimalFormat;
 
public class Formatierer {
	
	final String pattern;
	
	public Formatierer(final String pattern){
		this.pattern=pattern;
	}

	public String formatiere(int intValue) {
		final DecimalFormat format=new DecimalFormat(pattern);
		return format.format(intValue);
	}

}