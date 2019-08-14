package gq.cader.options;
import java.util.Map;
import java.util.HashMap;

class Portfolio extends Asset{

	private Map<String, Asset> portfolio;
	
	public Portfolio(){
		portfolio = new HashMap<String, Asset>();
	}
	public Portfolio(HashMap<String, Asset> portfolio){
		this.portfolio = portfolio;
	}

	@Override
	public double getValue(){
		return portfolio.entrySet().stream()
				//Get Map value<Asset>, then get Asset value
				.mapToDouble(x -> x.getValue().getValue())
				.sum();
	}
	public Map<String, Asset> getAssets()
	{
		return portfolio;
	}

	//TODO This  stuff
	public void addAsset(Asset a){
	}
	//TODO
	public void merge(Portfolio p){
	}
}
