package gq.cader.options;

import yahoofinance.*;
import java.lang.*;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.terminal.Terminal;
import java.util.*;

class StockPrinter implements Runnable
{
	private final int x,y;
	private final TextGraphics textGraphics;
	private final List<Stock> stocks;
	private final Terminal terminal;
	public StockPrinter(int xx, int yy, TextGraphics tg, List<Stock> st, Terminal t)
	{
		x = xx;
		y = yy;
		textGraphics = tg;
		stocks = st;
		terminal = t;
	}
	public void run() throws java.lang.InterruptedException
	{
		while(true)
		{
			for(int i =0; i<stocks.size(); i++){
                        textGraphics.putString(x, y, "Name: " + stocks.get(i).getName() + "                         ", SGR.BOLD);
                        textGraphics.putString(x + 1, y + 1, "Price: $" + stocks.get(i).getQuote().getPrice().toString());
                        textGraphics.putString(x + 1, y + 2, "Bid: $" + stocks.get(i).getQuote().getBid().toString() +"x"+stocks.get(i).getQuote().getBidSize().toString() + "    Ask: $" + stocks.get(i).getQuote().getAsk().toString()+"x"+stocks.get(i).getQuote().getAskSize().toString()+"                         " );
                        y+=3;
                }
		terminal.flush();
		Thread.sleep(100);
			
		}	
	}
}
