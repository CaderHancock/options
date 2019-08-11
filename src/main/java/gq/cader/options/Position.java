package gq.cader.options;

class Position extends Asset{
	Asset asset;
	int quantity = 0;
	double averageCost;
	Position(Asset asset, int quantity){
		this.symbol = asset.getSymbol();
		this.quantity = quantity;
		this.asset = asset;
	}
	@Override
	public double getValue(){
		return asset.getValue()*quantity;
	}
}
