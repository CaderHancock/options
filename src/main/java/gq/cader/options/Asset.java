package gq.cader.options;
import java.util.*;

abstract class Asset{

String symbol;
public	double value = 0;

/**This default method throws an Exception so that i can extend all relevant classes before implementing the data API
 * but i want to make sure that the default method is never called because each asset is going to have a different api call.
 * TODO Abstract this method when data API integrated
 */
public double getValue(){
return value;
}
public String getSymbol(){
return symbol;
}

}


