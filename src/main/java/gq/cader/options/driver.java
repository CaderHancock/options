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


public class driver{
	public static void main(String[] args)throws java.lang.InterruptedException {

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


			terminal.flush();



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
				//stockPrinter = new StockPrinter(5,6,textGraphics,stocks,terminal);
				try{
					stockPrinterThread = new Thread(new StockPrinter(5,6,textGraphics,stocks,terminal));
					stockPrinterThread.run();   
				}catch (Exception e)
				{}
				terminal.flush();
				keyStroke = terminal.readInput();
				//	stockPrinterThread.interrupt();
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

