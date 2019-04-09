package gq.cader.options;
import yahoofinance.*;

class Stock extends Asset{

	public Stock(String s){
	
	symbol = s;
	}
	public Stock(yahoofinance.Stock yahooStock){
	
	this.symbol = yahooStock.getSymbol();
	}
	public double getValue(){
	//TODO api calls 
	return value;
	}

}
