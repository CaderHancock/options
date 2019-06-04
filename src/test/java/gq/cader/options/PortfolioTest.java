package gq.cader.options;

 import java.util.HashMap;
 import static org.junit.jupiter.api.Assertions.*;
 import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.converter.JavaTimeConversionPattern;
import org.junit.jupiter.api.BeforeEach;
import java.util.ArrayList;
 class PortfolioTest{
	
	 Portfolio p;
	 Stock stock, stock1;
	 @BeforeEach
	 void setup(){
		try{stock = new AssetFactory("AAPL").getStock();
		stock1 = new AssetFactory("AMZN").getStock();
		HashMap<String, Asset> hm = new HashMap<String, Asset>();
		hm.put(stock.getSymbol(), stock);
		hm.put(stock1.getSymbol(), stock1);
		p = new Portfolio(hm);
		}catch (Exception e){}
	 }
	 @Test
	 public void yolo(){
		 System.out.println(p.getValue());
		 System.out.println(stock.getValue());
		 System.out.println(stock1.getValue());
		 // AssertTrue(p.getValue()>0);
	 }



 }
