package gq.cader.options;
import java.util.Set;
import java.util.TreeSet;

class Portfolio extends Asset{

	private Set<Asset> portfolio;
	
	public Portfolio(){
		portfolio = new TreeSet<Asset>();
	}
	public Portfolio(Set<Asset> portfolio){
		this.portfolio = portfolio;
	}

	@Override
	public double getValue(){
		return portfolio.stream()
				.mapToDouble(x -> x.getValue())
				.sum();
	}
	public Set<Asset> getAssets()
	{
		return portfolio;
	}
}
