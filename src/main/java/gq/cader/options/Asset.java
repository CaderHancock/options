package gq.cader.options;
import java.util.*;

abstract class Asset{
AssetType assetType;
String symbol;
public	double value = 0;

public double getValue(){
return value;
}
public String getSymbol(){
return symbol;
}
public String getUnderlyingSymbol(){
	return symbol;
}

}


