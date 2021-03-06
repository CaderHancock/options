package gq.cader.options;

import java.util.HashMap;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.converter.JavaTimeConversionPattern;
import org.junit.jupiter.api.BeforeEach;
import static org.mockito.Mockito.*;
import java.util.ArrayList;
class PortfolioTest{

	private Portfolio p;
	private Portfolio p1;
	private Stock stock, stock1;
	@BeforeEach
	void setup(){
		try{
			stock = new AssetFactory("AAPL").getStock();
			stock1 = new AssetFactory("AMZN").getStock();
			HashMap<String, Asset> hm = new HashMap<String, Asset>();
			hm.put(stock.getSymbol(), stock);
			hm.put(stock1.getSymbol(), stock1);
			p = new Portfolio(hm);
		}catch (Exception e){}
		Stock mock1 = mock(Stock.class);
		Stock mock2 = mock(Stock.class);
		when(mock1.getValue()).thenReturn(100.69);
		when(mock2.getValue()).thenReturn(320.0);
		HashMap<String, Asset> mocking = new HashMap<String, Asset>();
		mocking.put("foo", mock1);
		mocking.put("bar", mock2);
		p1 = new Portfolio(mocking);
	}
	@Test
	public void yolo(){
		assertTrue(p1.getValue()==420.69);
		System.out.println(p1.getValue());
	}



}
