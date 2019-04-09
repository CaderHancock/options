package gq.cader.options;

import java.util.regex.Pattern;
import java.util.*;
import java.util.IllegalFormatException;
public class AssetFactory{
	private final String incomingSymbol;
	private final String stockOptionRegex = "[A-Z][A-Z..]{1,3}?[A-Z]\\d{6}?[CP]\\d{8}";
	public AssetFactory(String s)throws Exception{

		if(!isValidOptionSymbol(s))
			throw  new Exception();

		incomingSymbol = s;

	}
	public StockOption newStockOption(){

		StockOption so = new StockOption(incomingSymbol);
				return so;

	}
	public boolean isValidOptionSymbol(String s){
		return (isValidStockOptionSymbol(s)&&hasOnlyOnePeriod(s));

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
	return new Stock("");
	}


}
