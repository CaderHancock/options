package gq.cader.options;

import java.util.regex.Pattern;
import java.util.*;
import java.util.IllegalFormatException;
public class OptionFactory{
	private final String incomingSymbol;
	private final String stockOptionRegex = "[A-Z][A-Z..]{1,3}?[A-Z]\\d{6}?[CP]\\d{8}";
	public OptionFactory(String s)throws Exception{
	
		if(!isValidOptionSymbol(s))
			throw  new Exception();

		incomingSymbol = s;

	}
	public StockOption newStockOption(){
		
		StockOption so = new StockOption(incomingSymbol);
/*
		so.setContractSymbol(s);
		so.setUnderlyingSymbol(s.substring(0,(s.length()-15)));

		so.isCallOption = (s.toUpperCase().charAt(s.length()-9) == 'C');
		so.setStrikePrice(Double.parseDouble(s.substring(s.length()-8)) / 1000);
		StringBuilder sb = new StringBuilder(s.substring((s.length()-15), (s.length()-9)));
		so.setExpiration = sb.insert(0,"20").insert(4," ").insert(7, " ").toString();
*/		return so;

	}
	public boolean isValidOptionSymbol(String s){
	return isValidStockOptionSymbol(s);
	
	}
	public boolean isValidStockOptionSymbol(String s){
	//ooh baby thats spicy
	return Pattern.compile(stockOptionRegex).matches(stockOptionRegex, s);
	}


}
