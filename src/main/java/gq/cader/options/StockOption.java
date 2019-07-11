/*
 *Object class used to do stuff with Options contracts
 * @author Cader.Hancock@gmail.com
 *
 **/
package gq.cader.options;
import java.util.*;


public class StockOption extends Option{

	public final String contractSymbol, underlyingSymbol;
	public final Double strikePrice;
	public final String expiration;

	//TODO All these values are constantly changing and must only be accessed via methods when finally implemented	
	private double mark, bid, ask, change, percentChange,  delta, theta, gamma, vega, rho, iv, underlyingSpotPrice ;
	private int volume, openInterest, bidSize, askSize;
	/**
	 * @param s The OCC symbol for the options contract represented by this class
	 * @see <a href="https://en.wikipedia.org/wiki/Option_symbol">Options symbol</a>
	 */
	public StockOption(String s){
		contractSymbol = s; 
		underlyingSymbol = s.substring(0,(s.length()-15)).replaceAll("\\s","");
		this.assetType = AssetType.STOCKOPTION;
		this.optionType = (s.toUpperCase().charAt(s.length()-9) == 'C') ? OptionType.CALL : OptionType.PUT;
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
