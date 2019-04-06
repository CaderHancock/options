package gq.cader.options;

import yahoofinance.*;
import yahoofinance.quotes.stock.StockQuote;
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

class SearchFunction implements Function {
	public SearchFunction(String q, Screen s,TerminalPosition tp)throws java.io.IOException

	{
	String query = q;
	String name = "Search";
	YahooFinance f = new YahooFinance();
	Stock result = f.get(query);
	TerminalPosition functionBarPosition = tp;
	Screen screen = s;
	TerminalSize terminalSize = screen.getTerminalSize();
	printStockStat(result, screen);
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
	public void printStockStat(Stock stock, Screen screen)throws java.io.IOException

	{
		List<String> lineBuffer = new ArrayList<String>();
		StockQuote q = stock.getQuote();
		lineBuffer.add(stock.getName() + "   " + q.getPrice()+" (" + q.getChange() + ") ("+ q.getChangeInPercent() + "%)     " );
//		lineBuffer.add(" Bid:$" + q.getBid() + "x"+q.getBidSize()+"     Ask:$"+q.getAsk()+"x"+q.getAskSize() );
		lineBuffer.add(q.toString());
		lineBuffer.add(stock.getStats().toString());
		lineBuffer.add(stock.getDividend().toString());
		new MultiLinePrinter(lineBuffer, screen, infoScreenTopLeft);
	}
}
