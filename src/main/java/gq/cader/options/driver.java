
package gq.cader.options;
import java.math.*;
import yahoofinance.*; 

public class driver{

	public static void main(String[] args) throws java.io.IOException{
		if (args.length == 1){	
			option o = new option(args[0]);
			System.out.println(o.underlyingSymbol);
			System.out.println(o.strikePrice);
			//	String s = "SPY190401C00271000";
			System.out.println(o.expiration);	
			System.out.println("Is Call Option:" + o.isCallOption);
		

		YahooFinance f = new YahooFinance();
		Stock stock = f.get(o.underlyingSymbol);
		BigDecimal price = stock.getQuote().getPrice();
		BigDecimal change = stock.getQuote().getChangeInPercent();
		BigDecimal peg = stock.getStats().getPeg();
		BigDecimal dividend = stock.getDividend().getAnnualYieldPercent();
		stock.print();
	}}
}
