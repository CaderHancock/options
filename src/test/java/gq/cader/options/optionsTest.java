package gq.cader.options;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

class optionsTest{

	@Test
	public void testOptionFactoryWithStockOption(){
		
		StockOption so = new OptionFactory().newStockOption("AAPL190405C00185000");
		assertNotNull(so);

	}
	@Test
	public void testOpFacStockOptionFields(){
	StockOption so = new OptionFactory().newStockOption("AAPL190405C00185000");
	fail();
	}
}
