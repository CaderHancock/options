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

import java.io.IOException;

/**
 * The second tutorial, using more complicated Terminal functionality
 * @author Martin
 */
public class driver{
	public static void main(String[] args) {
		/*
		   In this second tutorial, we'll expand on how to use the Terminal interface to provide more advanced
		   functionality.
		 */
		DefaultTerminalFactory defaultTerminalFactory = new DefaultTerminalFactory();
		Terminal terminal = null;
		try {
			terminal = defaultTerminalFactory.createTerminal();

			terminal.enterPrivateMode();

			terminal.clearScreen();

			terminal.setCursorVisible(true);

					final TextGraphics textGraphics = terminal.newTextGraphics();

					textGraphics.setForegroundColor(TextColor.ANSI.WHITE);
			textGraphics.setBackgroundColor(TextColor.ANSI.BLACK);
					textGraphics.putString(2, 1, "Abby version 0.0.1", SGR.BOLD);
			textGraphics.setForegroundColor(TextColor.ANSI.DEFAULT);
			textGraphics.setBackgroundColor(TextColor.ANSI.DEFAULT);
		//	textGraphics.putString(5, 3, "Terminal Size: ", SGR.BOLD);
		//	textGraphics.putString(5 + "Terminal Size: ".length(), 3, terminal.getTerminalSize().toString());

			/*
			   You still need to flush for changes to become visible
			 */
			terminal.flush();

			/*
			   You can attach a resize listener to your Terminal object, which will invoke a callback method (usually on a
			   separate thread) when it is informed of the terminal emulator window changing size. Notice that maybe not
			   all implementations supports this. The UnixTerminal, for example, relies on the WINCH signal being sent to
			   the java process, which might not make it though if you remote shell isn't forwarding the signal properly.
			 */
			terminal.addResizeListener(new TerminalResizeListener() {
					@Override
					public void onResized(Terminal terminal, TerminalSize newSize) {
					// Be careful here though, this is likely running on a separate thread. Lanterna is threadsafe in
					// a best-effort way so while it shouldn't blow up if you call terminal methods on multiple threads,
					// it might have unexpected behavior if you don't do any external synchronization
					textGraphics.drawLine(5, 3, newSize.getColumns() - 1, 3, ' ');
					textGraphics.putString(5, 3, "Terminal Size: ", SGR.BOLD);
					textGraphics.putString(5 + "Terminal Size: ".length(), 3, newSize.toString());
					try {
					terminal.flush();
					}
					catch(IOException e) {
					// Not much we can do here
					throw new RuntimeException(e);
					}
					}
					});

			textGraphics.putString(5, 4, "Search: ", SGR.BOLD);
			textGraphics.putString(5 + "Search: ".length(), 4, "<Pending>"); 

			terminal.flush();

			KeyStroke keyStroke = terminal.readInput();
			//Stack<String> userInput = new Stack<String>();
			String input = "";
			YahooFinance f = new YahooFinance();
			Stock searchRes;
			while((keyStroke.getKeyType() != KeyType.Escape)) {
				textGraphics.drawLine(5, 4, terminal.getTerminalSize().getColumns() - 1, 4, ' ');
				if(keyStroke.getKeyType() == KeyType.Enter)
				{ 
					searchRes = f.get(input);
					if (searchRes.getName() != null) 
					textGraphics.putString(5, 6, "Name: " + searchRes.getName() + "                         ", SGR.BOLD);
					//userInput.push(input.toString());
					input = "";
				}
				else if(keyStroke.getKeyType() != KeyType.Backspace)
					input = input.concat(Character.toString(keyStroke.getCharacter()));
				else
					input = input.substring(0 , input.length()-1);

				textGraphics.putString(5, 4, "Search: ", SGR.BOLD);
				textGraphics.putString(5 + "Search: ".length(), 4, input);
				terminal.flush();
				keyStroke = terminal.readInput();
			}

		}
		catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			if(terminal != null) {
				try {
					/*
					   The close() call here will exit private mode
					 */
					terminal.close();
				}
				catch(IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
