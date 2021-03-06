package gq.cader.options;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.mockito.Mockito.*;

class StockTest{ 

	Stock stock;
	@BeforeEach
	void setup(){
		try{
			stock = new AssetFactory("AAPL").getStock();
		}catch(Exception e){
		}

	}
	@Test
	public void testStockNotNull(){

		assertNotNull(stock);
	}
	@Disabled //api being fucky
	@Test
	public void testStockNotPoor(){
		assertTrue(stock.getValue()>0);
	}
	@Test
	public void testStockSymbolInitializedCorrectly(){
	assertTrue(stock.getSymbol().equals("AAPL"));
	}

}
