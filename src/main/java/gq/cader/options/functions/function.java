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

abstract class Function
{
//	abstract Function(Screen s, String... args);
	
	String name = null;
	public final TerminalPosition infoScreenTopLeft = new TerminalPosition(12,5);
	TerminalPosition functionBarPosition = null;
	Screen screen = null;
	TerminalSize terminalSize = screen.getTerminalSize();
//	abstract void drawInfoScreen()throws java.io.IOException;
//	abstract boolean run()throws java.io.IOException;
	public String getName()
	{
		return name;
	}
}
