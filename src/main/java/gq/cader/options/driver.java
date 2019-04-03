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

public class driver
{
	public static void main(String[] args)
	{
		boolean itsPartyTime = true;
		Screen screen = new DefaultTerminalFactory().createScreen();
		screen.startScreen();
		
		TextGraphics textGraphics = screen.newTextGraphics();
		TerminalSize terminalSize = screen.getTerminalSize();
		int columns = terminalSize.getColumns();
		int rows    = terminalSize.getRows();

		//Begin Draw LOOP
		while(itsPartyTime)
		{
			TerminalSize newSize = screen.doResizeIfNecessary();
			if(newSize != null)
			{ 
    				terminalSize = newSize; 
				columns = terminalSize.getColumns();
				rows    = terminalSize.getRows();

			}
		//Draw Header
			drawHeader(textGraphics,columns,rows);
					} 
	}

	private static void drawHeader(TextGraphics textGraphics, int columns, int rows )
	{
		textGraphics.setForegroundColor(TextColor.ANSI.BLACK);
		textGraphics.setBackgroundColor(TextColor.ANSI.WHITE);
		textGraphics.putString(3,1, "ABBY 0.1.1" );
	}

}
