package gq.cader.options;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.mockito.Mockito.*;

class AssetFactoryStockOptionTest{
	private final String validUnderCurrentRequirements = "AAPL  190405C00185000";	
	StockOption so;
	
	@BeforeEach//Test, make sure that a string that meets current requirements does not throw anything
	void setup() {
		try{
			so = new AssetFactory(validUnderCurrentRequirements).newStockOption();
		}catch(Exception e){
			fail();
		}
	}
	@Test
	public void testAssetFactoryStockOptionNotNull(){
		assertNotNull(so);
	}
	@Test
	public void testAssetFactoryStockOptionFields(){
		assertNotNull(so.getUnderlyingSymbol());
		assertTrue(so.getUnderlyingSymbol().equals("AAPL"));
		assertTrue(so.isCallOption);
		assertTrue(so.getStrikePrice() == 185);
	}
	@Test
	public void testAssetFactoryStockOptionBoolTypes(){
		assertTrue(so.isStockOption);
		assertFalse(so.isForexOption||so.isCommoditiesOption);	
	}
	//TODO Find more illegal cases 
	//Test illegal symbol format
	@Test
	public void testValidateStockOptionSymbol(){
		assertThrows(Exception.class, () -> {new AssetFactory("XXXXXXXXXXXXXXXX");});
		assertThrows(Exception.class, () -> {new AssetFactory("APTI  190405X00185000");});
		assertThrows(Exception.class, () -> {new AssetFactory(".PTI  190405C00185000");});
		assertThrows(Exception.class, () -> {new AssetFactory("A..I  190405C00185000");});
		assertThrows(Exception.class, () -> {new AssetFactory("A.T.  190405C00185000");});
		assertThrows(Exception.class, () -> {new AssetFactory("APT.  190405C00185000");});
		assertThrows(Exception.class, () -> {new AssetFactory("AP..I 190405C00185000");});
		assertThrows(Exception.class, () -> {new AssetFactory("  APTI192445C00185000");});
	}
	//Not all regular equities have options chains. Berkshire Hathaway Class A shares for example.
	//There is also a test case for private equity. If this code is ever integrated with something 
	//like bloomberg's api (that probably lists private companies with symbols) it should throw at NotTradeableThingException maybe??
	@Test
	public void testValidStockButNotTradedOnCBOE(){
		assertThrows(Exception.class, () -> {new AssetFactory("BRK.A 190405C00185000");}); //Not listed on CBOE
		assertThrows(Exception.class, () -> {new AssetFactory("APTI 190405C00185000");});  //Private companty with Bloomberg symbol
	}
	@Test
	public void testIfOptionIsExpired(){
		fail();
	}
	@Test
	public void testIfSymbolDateIsOnOptionChain(){
		fail();
	}
}
