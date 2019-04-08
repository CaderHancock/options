package gq.cader.options;
class OptionFactory{
	private final String incomingSymbol;
	public OptionFactory(String s){
		
		incomingSymbol = s;

	}
	public StockOption newStockOption(){
		
		//if (isValidStockOptionSymbol)
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

}
