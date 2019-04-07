package gq.cader.options;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.mockito.Mockito.*;

class optionsTest{

	StockOption so;
	@BeforeEach
	void setup() {
	
	so = new OptionFactory("APTI190405C00185000").newStockOption();
	}
	@Test
	public void testOptionFactoryWithStockOption(){
		
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
		assertFalse(so.isForexOption&&so.isCommoditiesOption);	
	}
	@Test
	public void testValidateStockOptionSymbol(){
	
	fail();
	}



}
