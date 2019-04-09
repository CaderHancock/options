package gq.cader.options;

import static org.junit.jupiter.api.Assertions.*;
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
	@Test
	public void testStockSymbolInitializedCorrectly(){
	assertTrue(stock.getSymbol().equals("AAPL"));
	}

}
