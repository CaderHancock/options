package gq.cader.options;
import java.util.*;

abstract class Portfolio implements Asset{

Set<Asset> portfolio;
abstract public double getValue();

}
