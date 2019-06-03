package gq.cader.options;
 
 import static org.junit.jupiter.api.Assertions.*;
 import org.junit.jupiter.api.Test;
 import org.junit.jupiter.api.BeforeEach;
 import static org.mockito.Mockito.*;
import java.util.ArrayList;
 class PortfolioTest{
	
	 Portfolio p;
	 @BeforeEach
	 void setup(){
		try{Stock stock = new AssetFactory("AAPL").getStock();
		Stock stock1 = new AssetFactory("AAPL").getStock();
		
		ArrayList<Asset> a = new ArrayList<Asset>();
		a.add(stock1);
		a.add(stock);
		}catch (Exception e){}
	 }

 }
