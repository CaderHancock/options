package gq.cader.options;
import java.util.*;
interface Option{

	public final String contractSymbol = null;
       	public final String underlyingSymbol= null;
	public final Double strikePrice = null;
	public final Boolean isCallOption = null;
	public final String expiration= null;
	public final Boolean isFxOption = null;
	public final Boolean isCommoditiesOption = null;
	public Option refresh();
}
