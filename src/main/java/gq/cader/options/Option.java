/*	Theta
 *
 *  Always decaying,
 * an Athenian symbol
 * destroys your wallet 
 *
 */
package gq.cader.options;
import java.util.*;
abstract class Option extends Asset{

	public final String contractSymbol;
	public final String underlyingSymbol;
	public final double strikePrice;
	public final boolean isCallOption;
	public final String expiration;
	public final boolean isStockOption;
	public final boolean isForexOption;
	public final boolean isCommoditiesOption;

	public Option()
	{
		contractSymbol = null;
		underlyingSymbol = null;
		strikePrice = 0;
		isCallOption = false;
		isStockOption = false;
		isForexOption = false;
		isCommoditiesOption = false;
		expiration = null;
	}
	abstract public Option refresh();
	public String getContractSymbol()
	{
		return this.contractSymbol;
	}
	@Override
	public String getUnderlyingSymbol()
	{
		return this.underlyingSymbol;
	}
	public double getStrikePrice()
	{
		return strikePrice;
	}
	public String getExpiration()
	{
		return expiration;
	}
	public boolean isCallOption(){
		return isCallOption;
	}
}
