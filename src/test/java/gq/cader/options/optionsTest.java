package gq.cader.options;

import static org.junit.jupiter.api.Assertions.*;
import java.util.IllegalFormatException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.mockito.Mockito.*;

class optionsTest{

	StockOption so;
	@BeforeEach
	void setup() {

		so = new OptionFactory("APTI190405C00185000").newStockOption();
		//co = new OptionFactory("").newCommoditiesOption();
		//fo = new OptionFactory("").newForexOption();

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
	//TODO Find more illegal cases
	@Test
	public void testValidateStockOptionSymbol(){


		assertThrows(IllegalFormatException.class, () -> {
			new OptionFactory("XXXXXXXXXXXXXXXX");});
		assertThrows(IllegalFormatException.class, () -> {
			new OptionFactory("APTI190405X00185000");});
		assertThrows(IllegalFormatException.class, () -> {
			new OptionFactory("0000190405C00185000");});



	}//TODO Find more illegal cases
	@Test
	public void testValidateForexOptionSymbol(){


		assertThrows(IllegalFormatException.class, () -> {
			new OptionFactory("");});
		assertThrows(IllegalFormatException.class, () -> {
			new OptionFactory("");});
		assertThrows(IllegalFormatException.class, () -> {
			new OptionFactory("");});



	}//TODO Find more illegal cases
	@Test	
	public void testValidateCommoditiesOptionSymbol(){


		assertThrows(IllegalFormatException.class, () -> {
			new OptionFactory("");});
		assertThrows(IllegalFormatException.class, () -> {
			new OptionFactory("");});
		assertThrows(IllegalFormatException.class, () -> {
			new OptionFactory("");});



	}



}
