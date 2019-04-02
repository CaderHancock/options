
package gq.cader.options;
import java.math.*;
import yahoofinance.*; 

public class driver{

	public static void main(String[] args) throws java.io.IOException, java.lang.InterruptedException{

		//ghetto test to see if arg[0] is an option symbol else if arg[0] is an equity symbol or no args
		if (args.length == 1 && args[0].length() > 6){	
			option o = new option(args[0]);
			System.out.println(o.underlyingSymbol);
			System.out.println(o.strikePrice);
			//	String s = "SPY190401C00271000";
			System.out.println(o.expiration);	
			System.out.println("Is Call Option:" + o.isCallOption);

		}
		if (args.length == 1 && args[0].length() < 6){
			YahooFinance f = new YahooFinance();
			while(true){

				Stock stock = f.get(args[0]);
				BigDecimal price = stock.getQuote().getPrice();
				BigDecimal change = stock.getQuote().getChangeInPercent();
				BigDecimal peg = stock.getStats().getPeg();
				BigDecimal dividend = stock.getDividend().getAnnualYieldPercent();
				stock.print();
				Thread.sleep(1000);
				clearScreen();
			}
		}

	}
	public static void clearScreen() {  
		System.out.print("\033[H\033[2J");  
		System.out.flush();  
	} 

}
