package main.java.server;

import org.webharvest.definition.ScraperConfiguration;
import org.webharvest.runtime.Scraper;
import org.xml.sax.InputSource;


public class SimpleScrapper {
	static Scraper scraper;
	
	public static void main(String[] args){
		try {
		
			
			InputSource in =  new InputSource(SimpleScrapper.class.
					getClassLoader().getResourceAsStream("wizzairScrapperConfig.xml"));
			
			ScraperConfiguration config = 
					new ScraperConfiguration(in);
			
			
			scraper = new Scraper(config, "/");
			scraper.addVariableToContext("fromAirport", "IEV");
			scraper.addVariableToContext("toAirport", "GRO");
			scraper.addVariableToContext("fromDate", "10-11-2013");
			scraper.addVariableToContext("paxAdult", "1");
			scraper.addVariableToContext("paxChild", "0");
			scraper.addVariableToContext("paxInfant", "0");
			scraper.setDebug(true);
			scraper.execute();

			System.out.println(scraper.getContext().getVar("list"));
		
		
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

}
