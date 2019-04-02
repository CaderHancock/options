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
	public final Date expiration;

	//All these values are constantly changing and must only be accessed via methods	
	private double mark, bid, ask, change, percentChange, volume, openInterest, delta, theta, gamma, vega, rho, iv, underlyingSpotPrice ;

	/**
	* @param s The OCC symbol for the options contract represented by this class
	* @see <a href="https://en.wikipedia.org/wiki/Option_symbol">Options symbol</a>
	*/
	public option(String s){
		contractSymbol = s; 
		underlyingSymbol = s.substring(0,(s.length()-15));

		isCallOption = (s.toUpperCase().charAt(s.length()-9) == 'C');
		strikePrice = Double.parseDouble(s.substring(s.length()-8)) / 1000 ;
		expiration = null; //fix this		
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
