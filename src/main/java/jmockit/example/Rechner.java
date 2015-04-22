package jmockit.example;

public class Rechner {

	final Formatierer formatierer;
	
	public Rechner(final String format){
		this.formatierer=new Formatierer(format);
	}
	
	public String addiere(final int a, final int b){
		
		return formatierer.formatiere(a+b);
	}
	
}
