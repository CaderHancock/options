package gq.cader.options;
import java.util.Set;

abstract class Portfolio extends Asset{

private Set<Asset> portfolio;
abstract public double getValue();
abstract public Set<Asset> getAssets();
}
