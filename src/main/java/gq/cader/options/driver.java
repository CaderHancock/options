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
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.terminal.TerminalResizeListener;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.screen.*;
import java.io.IOException;

public class driver {
	public static void main(String[] args)throws java.io.IOException
	{	
		boolean itsPartyTime = true;
		YahooFinance f = new YahooFinance();
		Thread currentFunction = null;
		Screen screen = new DefaultTerminalFactory().createScreen();
		screen.startScreen();
		TextGraphics textGraphics = screen.newTextGraphics();
		TerminalSize terminalSize = screen.getTerminalSize();
		int columns = terminalSize.getColumns();
		int rows    = terminalSize.getRows();
		final TerminalPosition searchBar = new TerminalPosition(1,5);
		textGraphics.setForegroundColor(TextColor.ANSI.WHITE);
//		textGraphics.setBackgroundColor(TextColor.ANSI.BLACK);
		textGraphics.fill(' ');
		screen.refresh();
		//Begin Draw LOOP
		KeyStroke keyStroke = null;
		String input = "";
		String cachedSearch = null;
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
			
			keyStroke = screen.readInput();

			if(keyStroke.getKeyType() == KeyType.Escape)
				itsPartyTime = false;

			if(keyStroke.getKeyType() == KeyType.Character && input.length()<11)
			{
				input = input.concat(Character.toString(keyStroke.getCharacter()));
				textGraphics.putString(searchBar, input	);
			}
			if(keyStroke.getKeyType() == KeyType.Backspace && input.length()>0)
			{	
				input = input.substring(0 , input.length()-1);
				textGraphics.drawLine(searchBar, searchBar.withRelativeColumn(11), ' ');
				textGraphics.putString(searchBar, input	);
			}
			if(keyStroke.getKeyType() == KeyType.Enter)
			{
				cachedSearch = input;
				input = "";
				textGraphics.drawLine(searchBar, searchBar.withRelativeColumn(11), ' ');
				new SearchFunction(cachedSearch, screen, Function.infoScreenTopLeft );
			}
			screen.refresh();
		} 
	}

	private static void drawHeader(TextGraphics textGraphics, Screen screen,  int columns, int rows )throws java.io.IOException
	{
				textGraphics.putString(3,1, "ABBY 0.1.1" );
				textGraphics.drawLine(0,2,columns,2,'_' ); 
				screen.refresh();
		
	}


}
