package gq.cader.options;

class Stock extends Asset{

	public Stock(String s){
	this.assetType = AssetType.STOCK;	
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
