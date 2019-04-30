package gq.cader.options;
import java.util.Set;

abstract class Portfolio extends Asset{

Set<Asset> portfolio;
abstract public double getValue();

}
