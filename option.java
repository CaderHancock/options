/*
//Object class used to do stuff with Options contracts
//Contructed using a string containing the OCC Option of the contract https://en.wikipedia.org/wiki/Option_symbol
//Written by Cader.Hancock@gmail.com
//
//TODO
//Write methods to make api pulls
//"              " calculate greeks and IV
//"              " get values
**/
package cader.options;

public class option{

	public String contractSymbol, underlyingSymbol;
	public double strikePrice;
	private double mark, bid, ask, change, percentChange, volume, openInterest, delta, theta, gamma, vega, rho, iv;
	
	//test value
	//contractSymbol = "SPY190401C00271000";


	public option(String incomingSymbol){
		underlyingSymbol = incomingSymbol.substring(0,(incomingSymbol.length()-16));
		
	}
}
