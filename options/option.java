/*
*Object class used to do stuff with Options contracts
* @author Cader.Hancock@gmail.com
*
*TODO
*Write methods to make api pulls
*"              " calculate greeks and IV
*"              " get values
**/
package options;
import java.util.*;


public class option{

	public final String contractSymbol, underlyingSymbol;
	public final double strikePrice;
	public final boolean isCallOption;	
	private double mark, bid, ask, change, percentChange, volume, openInterest, delta, theta, gamma, vega, rho, iv;
	/**
	* @param incomingSymbol The OCC symbol for the options contract represented by this class
	* @see <a href="https://en.wikipedia.org/wiki/Option_symbol">Options symbol</a>
	*/
	public option(String incomingSymbol){
		contractSymbol = incomingSymbol; 
		underlyingSymbol = incomingSymbol.substring(0,(incomingSymbol.length()-15));

		isCallOption = (contractSymbol.toUpperCase().charAt(contractSymbol.length()-9) == 'C');
		strikePrice = Double.parseDouble(contractSymbol.substring(contractSymbol.length()-8)) / 1000 ;
		
	}
	/** @return  3 element array of type double containing the contract's bid, ask, and mark prices */
	public double[] refreshQuote(){
		
		//TODO API calls and stuff
		double[] quote = new double[3];
		quote[0] = bid;
		quote[1] = ask;
		quote[2] = mark;	
		return quote;
	}

}
