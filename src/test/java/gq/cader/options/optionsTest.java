package gq.cader.options;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

class optionsTest{

	@Test
	public void testOptionFactoryWithStockOption(){
		
		StockOption so = new OptionFactory("AAPL190405C00185000").newStockOption();
		assertNotNull(so);

	}
	@Test
	public void testOpFacStockOptionFields(){
	StockOption so = new OptionFactory("AAPL190405C00185000").newStockOption();
	assertNotNull(so.getUnderlyingSymbol());
	assertTrue(so.getUnderlyingSymbol().equals("AAPL"));
	assertTrue(so.isCallOption);
	}
}
