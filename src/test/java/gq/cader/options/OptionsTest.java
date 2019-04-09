package gq.cader.options;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.mockito.Mockito.*;

class OptionsTest{

	StockOption so;
	@BeforeEach
	void setup() {

	try{
		so = new AssetFactory("APTI  190405C00185000").newStockOption();
		//co = new AssetFactory("").newCommoditiesOption();
		//fo = new AssetFactory("").newForexOption();
	}catch(Exception e){

		fail();
	}
	}
	@Test
	public void testAssetFactoryWithStockOption(){
		assertNotNull(so);
	}
	@Test
	public void testOpFacStockOptionFields(){
		assertNotNull(so.getUnderlyingSymbol());
		assertTrue(so.getUnderlyingSymbol().equals("APTI"));
		assertTrue(so.isCallOption);
		assertTrue(so.getStrikePrice() == 185);
	}
	@Test
	public void testStockOptionBoolTypes(){
		assertTrue(so.isStockOption);
		assertFalse(so.isForexOption||so.isCommoditiesOption);	
	}
	//TODO Find more illegal cases
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

	}//TODO Find more illegal cases
	@Test
	public void testValidateForexOptionSymbol(){
		assertThrows(Exception.class, () -> {
			new AssetFactory("");});
		assertThrows(Exception.class, () -> {
			new AssetFactory("");});
		assertThrows(Exception.class, () -> {
			new AssetFactory("");});

	}//TODO Find more illegal cases
	@Test	
	public void testValidateCommoditiesOptionSymbol(){
		assertThrows(Exception.class, () -> {
			new AssetFactory("");});
		assertThrows(Exception.class, () -> {
			new AssetFactory("");});
		assertThrows(Exception.class, () -> {
			new AssetFactory("");});
	}
}
