package gq.cader.options;

public class driver{

public static void main(String[] args){
	option o = new option(args[0]);
	System.out.println(o.underlyingSymbol);
	System.out.println(o.strikePrice);
	//	String s = "SPY190401C00271000";
		System.out.println(o.expiration);	
		System.out.println("Is Call Option:" + o.isCallOption);
	}
}
