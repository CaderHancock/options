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
	public static void main(String[] args)throws java.lang.InterruptedException {
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

			terminal.setCursorVisible(false);

			final TextGraphics textGraphics = terminal.newTextGraphics();

			textGraphics.setForegroundColor(TextColor.ANSI.WHITE);
			textGraphics.setBackgroundColor(TextColor.ANSI.BLACK);
			textGraphics.putString(2, 1, "Abby version 0.1", SGR.BOLD);
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
			Runnable stockPrinterThread;
			StockPrinter stockPrinter;
			List<Stock> stocks = new ArrayList<Stock>();
			List<String> namesInStocks = new ArrayList<String>();
			KeyStroke keyStroke = terminal.readInput();
			String input = "";
			YahooFinance finance = new YahooFinance();
			Stock stock;
			while((keyStroke.getKeyType() != KeyType.Escape)) {
				textGraphics.drawLine(5, 4, terminal.getTerminalSize().getColumns() - 1, 4, ' ');
				if(keyStroke.getKeyType() == KeyType.Enter)
				{
				if (!input.equalsIgnoreCase("CLEAR")){ 
					stock = finance.get(input);
					if (stock.getName() != null && !(namesInStocks.contains(stock.getName()))){

						stocks.add(stock);
						namesInStocks.add(stock.getName());
					}
					}else{
						stocks = new ArrayList<Stock>();	
						namesInStocks = new ArrayList<String>();
					}
					input = "";
				}
				else if(keyStroke.getKeyType() != KeyType.Backspace)
					input = input.concat(Character.toString(keyStroke.getCharacter()));
				else if(keyStroke.getKeyType() == KeyType.Backspace && input.length()>=1)
					input = input.substring(0 , input.length()-1);

				textGraphics.putString(5, 4, "Search: ", SGR.BOLD);
				textGraphics.putString(5 + "Search: ".length(), 4, input);
				//printStocks(5,6, stocks, textGraphics);
				stockPrinter = new StockPrinter(5,6,textGraphics,stocks,terminal);
				stockPrinterThread = new Thread(stockPrinter).start();
				terminal.flush();
				keyStroke = terminal.readInput();
				stockPrinterThread.interrupt();
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
	private static void printStocks(int x, int y, List<Stock> stocks, TextGraphics textGraphics){
		for(int i =0; i<stocks.size(); i++){
			textGraphics.putString(x, y, "Name: " + stocks.get(i).getName() + "                         ", SGR.BOLD);
			textGraphics.putString(x + 1, y + 1, "Price: $" + stocks.get(i).getQuote().getPrice().toString());
			textGraphics.putString(x + 1, y + 2, "Bid: $" + stocks.get(i).getQuote().getBid().toString() +"x"+stocks.get(i).getQuote().getBidSize().toString() + "    Ask: $" + stocks.get(i).getQuote().getAsk().toString()+"x"+stocks.get(i).getQuote().getAskSize().toString()+"                         " );
			y+=3;
		}
	}
}
