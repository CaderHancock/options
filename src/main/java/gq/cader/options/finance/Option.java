package gq.cader.options;
import java.util.*;
abstract class Option{

	public final String contractSymbol;
	public final String underlyingSymbol;
	public final double strikePrice;
	public final boolean isCallOption;
	public final String expiration;
	public final boolean isStockOption;
	public final boolean isFxOption;
	public final boolean isCommoditiesOption;

	public Option()
	{
		contractSymbol = null;
		underlyingSymbol = null;
		strikePrice = 0;
		isCallOption = false;
		isStockOption = false;
		isFxOption = false;
		isCommoditiesOption = false;
		expiration = null;
	}
	abstract public Option refresh();
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
		return strikePrice;
	}
	public String getExpiration()
	{
		return expiration;
	}
}
