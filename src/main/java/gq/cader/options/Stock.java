package gq.cader.options;

import yahoofinance.*;

class Stock extends Asset{
	YahooFinance finance = new YahooFinance();
	yahoofinance.Stock yahoo;
	public Stock(String s){
	this.assetType = AssetType.STOCK;	
	symbol = s;
	try{
	yahoo = finance.get(s);
	}catch(Exception e){}
	}
	public Stock(yahoofinance.Stock yahooStock){
	
	this.symbol = yahooStock.getSymbol();
	}
	public double getValue(){
	try{	
		return yahoo.getQuote(true).getPrice().doubleValue();
	}catch(Exception e){return 0;}
	}

}
