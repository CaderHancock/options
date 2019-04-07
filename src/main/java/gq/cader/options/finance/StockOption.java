/*
 *Object class used to do stuff with Options contracts
 * @author Cader.Hancock@gmail.com
 *
 *TODO
 *Write methods to make api pulls
 *"              " calculate greeks and IV
 *"              " get+set methods 
 **/
package gq.cader.options;
import java.util.*;


public class StockOption extends Option{

	public final String contractSymbol, underlyingSymbol;
	public final Double strikePrice;
	public final boolean isCallOption;
	public final String expiration;
	public final boolean isStockOption = true;
	public final boolean isForexOption = false;
	public final boolean isCommoditiesOption = false;

	//All these values are constantly changing and must only be accessed via methods	
	private double mark, bid, ask, change, percentChange, volume, openInterest, delta, theta, gamma, vega, rho, iv, underlyingSpotPrice ;

	/**
	 * @param s The OCC symbol for the options contract represented by this class
	 * @see <a href="https://en.wikipedia.org/wiki/Option_symbol">Options symbol</a>
	 */
	public StockOption(String s){
		contractSymbol = s; 
		underlyingSymbol = s.substring(0,(s.length()-15));

		isCallOption = (s.toUpperCase().charAt(s.length()-9) == 'C');
		strikePrice = Double.parseDouble(s.substring(s.length()-8)) / 1000 ;
		StringBuilder sb = new StringBuilder(s.substring((s.length()-15), (s.length()-9)));	
		expiration = sb.insert(0,"20").insert(4," ").insert(7, " ").toString();
	}

	public Option refresh(){
		return null;
	}
	public String getContractSymbol()
	{       
		return this.contractSymbol;
	}
	public String getUnderlyingSymbol()
	{
		return this.underlyingSymbol;
	}
	public double getStrikePrice()
	{
		return this.strikePrice;
	}
	public String getExpiration()
	{
		return this.expiration;
	}
}
