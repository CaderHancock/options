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
public class MultiLinePrinter
{
	public MultiLinePrinter(List<String> lines, Screen screen, TerminalPosition startPos)
	{
		TextGraphics tg = screen.newTextGraphics();
		TerminalPosition workingPos = startPos.clone();
		for (int i = 0; i < lines.length(); i++)
		{
			tg.putString(lines.get(i), workingPos);
			workingPos = workingPos.withRelativeRow(1);
		}	



		screen.refresh();	
	}
}
