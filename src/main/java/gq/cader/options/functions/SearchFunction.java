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

class SearchFunction implements Function
{
	public SearchFunction(String q, Screen s,TerminalPosition tp)
	{
	String query = q;
	String name = "Search";
	YahooFinance f = new YahooFinance();
	Stock result = f.get(query);
	TerminalPosition functionBarPosition = tp;
	Screen screen = s;
	TerminalSize terminalSize = screen.getTerminalSize();

	}
	public void drawInfoScreen( )
	{
	
	}
	public boolean run()
	{
		return true;
	}
	public String getName()
	{	
		return name;
	}
	private void printStockStat(Stock stock, Screen screen)
	{
		List<String> lineBuffer = new ArrayList<String>();
	
		lineBuffer.add(stock.getName() +"     "+ stock.getQuote().getPrice().toPlainString()+" (" + stock.getQuote().getChange().toPlainString() );
		lineBuffer.add("");
		lineBuffer.add("");
		lineBuffer.add();
		lineBuffer.add();
		lineBuffer.add();
		new MultiLinePrinter(lineBuffer, screen, infoScreenTopLeft);
	}
}
