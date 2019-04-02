import options.*;

public class driver{

public static void main(String[] args){
	option o = new option(args[0]);
	System.out.println(o.underlyingSymbol);
	System.out.println(o.strikePrice);
	//	String s = "SPY190401C00271000";
	//	System.out.println(s.substring(0, (s.length()-15)));	
	//	System.out.println(s.charAt(s.length()-9));
	}
}
