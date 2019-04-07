package gq.cader.options;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

class optionsTest{

	@Test
	public void testStockOptionFactory(){
		
		StockOption so = new OptionFactory().newStockOption("AAPL190405C00185000");
		assertNotNull(so);

	}
}
