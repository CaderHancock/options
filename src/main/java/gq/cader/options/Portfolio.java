package gq.cader.options;
import java.util.Set;

class Portfolio extends Asset{

	private Set<Asset> portfolio;
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
