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
	public SearchFunction(String query, Screen s, TerminalPosition tp)
	{
	YahooFinance f = new YahooFinance();
	Stock result = f.get(query);
	String name = "Search";
	TerminalPosition functionBarPosition = tp;
	Screen screen = s; 
	TerminalSize terminalSize = screen.getTerminalSize();
	}
	public void drawInfoScreen()
	{}
	public void run()
	{}
	public String getName()
	{	
		return name;
	}
}
