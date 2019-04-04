package gq.cader.options;

import yahoofinance.*;
import java.util.*;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.TerminalResizeListener;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.screen.*;
import com.googlecode.lanterna.TerminalPosition;

class SearchFunction extends Function {
	public SearchFunction(Screen s,String... args)throws java.io.IOException

	{
	String query = args[0];
	String name = "Search";
	YahooFinance f = new YahooFinance();
	Stock result = f.get(query);
	TerminalPosition functionBarPosition = new TerminalPosition(0,5);
	Screen screen = s;
	TerminalSize terminalSize = screen.getTerminalSize();
	printStockStat(result, screen);
	}
	
	private void drawInfoScreen()throws java.io.IOException
	{
	//		printStockStat(result, screen);
	}

	public boolean run()throws java.io.IOException
	{
	//	if(result != null)
	//	{
	//		drawInfoScreen();
		return true;
	//	}else 
	//		return false;
	}
	public String getName()
	{	
		return name;
	}
	public void printStockStat(Stock stock, Screen screen)throws java.io.IOException
	{
		List<String> lineBuffer = new ArrayList<String>();
	
		lineBuffer.add(stock.getName() +"     "+ stock.getQuote().getPrice().toPlainString()+" (" + stock.getQuote().getChange().toPlainString() + ")" );
		lineBuffer.add("");
		lineBuffer.add("");
//		lineBuffer.add();
//		lineBuffer.add();
//		lineBuffer.add();
		new MultiLinePrinter(lineBuffer, screen, infoScreenTopLeft);
	}
}
