package com.model;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import java.util.logging.Logger;

public class ReadJsonUrl {
	
	private static final Logger LOG = Logger.getLogger(ReadJsonUrl.class.getName());

	/**
	 * This method read the JSON from the URL and returns it as a String
	 * @param urlString
	 * @return
	 * @throws Exception
	 */
	public static String readUrl(String urlString) throws Exception {
		
		String inline = ProgramConstants.EMPTY_STRING;
		try{
			URL url = new URL(urlString);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod(ProgramConstants.GET_METHOD);
			conn.connect();
			int responseCode = conn.getResponseCode();
			if (responseCode != 200) {

			} else {

				Scanner sc = new Scanner(url.openStream());
				while (sc.hasNext()) {
					inline += sc.nextLine();
				}
				conn.disconnect();
				sc.close();
			}
		} catch (Exception e) {
			LOG.info("Exception in readUrl method in class:ReadJsonUrl");
		}
		
		return inline;
	}

}
