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
import java.io.IOException;

public class driver {
	public static void main(String[] args)throws java.io.IOException
	{
		boolean itsPartyTime = true;
		Screen screen = new DefaultTerminalFactory().createScreen();
		screen.startScreen();
		YahooFinance f = new YahooFinance();
		TextGraphics textGraphics = screen.newTextGraphics();
		TerminalSize terminalSize = screen.getTerminalSize();
		int columns = terminalSize.getColumns();
		int rows    = terminalSize.getRows();
		textGraphics.setForegroundColor(TextColor.ANSI.WHITE);
//		textGraphics.setBackgroundColor(TextColor.ANSI.BLACK);
		textGraphics.fill(' ');
		screen.refresh();
		//Begin Draw LOOP
		KeyStroke keyStroke = null;
		drawHeader(textGraphics,screen, columns,rows);
		while(itsPartyTime)
		{

			TerminalSize newSize = screen.doResizeIfNecessary();
			if(newSize != null)
			{ 
    				terminalSize = newSize; 
				columns = terminalSize.getColumns();
				rows    = terminalSize.getRows();

			}
			
			new SearchFunction("tsla", screen, Function.infoScreenTopLeft);
			keyStroke = screen.readInput();
		} 
	}

	private static void drawHeader(TextGraphics textGraphics, Screen screen,  int columns, int rows )throws java.io.IOException
	{
				textGraphics.putString(3,1, "ABBY 0.1.1" );
				textGraphics.drawLine(0,2,columns,2,'_' ); 
				screen.refresh();
		
	}


}
