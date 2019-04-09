/**This class is for executing all the business logic required such that
 * this class takes a string and either throws an Exception or correctly instantiates an Asset. 
 * this class should never return a null asset
 * 
 */
package gq.cader.options;

import yahoofinance.*;
import java.util.regex.Pattern;
import java.util.*;
import java.util.IllegalFormatException;
public class AssetFactory{
	private final String incomingSymbol;
	private final String stockOptionRegex = "[A-Z][A-Z..]{1,3}?[A-Z]\\d{6}?[CP]\\d{8}";
	public AssetFactory(String s)throws Exception{

		if(!isValidAssetSymbol(s))
			throw  new Exception();

		incomingSymbol = s;

	}
	public StockOption newStockOption(){

		StockOption so = new StockOption(incomingSymbol);
				return so;

	}
	public boolean isValidAssetSymbol(String s){
		if(isValidStockOptionSymbol(s)&&hasOnlyOnePeriod(s))
			return true;
		try{
		YahooFinance finance = new YahooFinance();
		if(finance.get(s) != null)
			return true;
		}catch(Exception e){
		}
		return false;

	}
	public boolean isValidStockOptionSymbol(String s){
		//TODO ooh baby thats a spicy regex to refactor *so fun*
		return Pattern.compile(stockOptionRegex).matches(stockOptionRegex, s);
	}
	private boolean hasOnlyOnePeriod(String s){
		int numDot = 0;
		for(int i = 0; i < s.length(); i++){
			if (numDot>1)
				return false;
			if(s.charAt(i)=='.')
				numDot++;

		}

		return true;

	}
	public Stock getStock(){
		try{
			return new Stock(new YahooFinance().get(incomingSymbol));
		}catch(Exception e){
			return null;
		}
	}


}
