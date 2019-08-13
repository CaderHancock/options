package gq.cader.options;

import java.lang.IllegalArgumentException;

class Position extends Asset{

	private	Asset asset;
	private	int quantity = 0;
	private	double averageCost;

	Position(Asset asset, int quantity, double pricePaid){
		this.symbol = asset.getSymbol();
		this.quantity = quantity;
		this.asset = asset;
		this.averageCost = pricePaid;
	}
	@Override
	public double getValue(){
		return asset.getValue()*quantity;
	}
	public double getAverageCost(){
		return averageCost;
	}
	public void merge(Position position){
		if(this.asset.equals(position.asset)){
			this.quantity += position.quantity;
			this.averageCost = ((this.averageCost * this.quantity) + (position.averageCost * this.quantity)) / (this.quantity + position.quantity);
		}else{
		throw new IllegalArgumentException("Attempting to merge positions of different Assets");
		}
	}
}
