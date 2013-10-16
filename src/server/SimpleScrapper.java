package server;

import org.webharvest.definition.ScraperConfiguration;
import org.webharvest.runtime.Scraper;
import org.xml.sax.InputSource;


public class SimpleScrapper {
	static Scraper scrapper;
	
	public static void main(String[] args){
		try {
		
			
			InputSource in =  new InputSource(SimpleScrapper.class.
					getClassLoader().getResourceAsStream("wizzairScrapperConfig.xml"));
			
			ScraperConfiguration config = 
					new ScraperConfiguration(in);
			
			
			scrapper = new Scraper(config, "/");
			scrapper.addVariableToContext("fromAirport", "IEV");
			scrapper.addVariableToContext("toAirport", "GRO");
			scrapper.addVariableToContext("fromDate", "10-11-2013");
			scrapper.addVariableToContext("paxAdult", "1");
			scrapper.addVariableToContext("paxChild", "0");
			scrapper.addVariableToContext("paxInfant", "0");
			scrapper.setDebug(true);
			scrapper.execute();

			System.out.println(scrapper.getContext().getVar("list"));
		
		
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

}
