package com.bridgelabz.csvRead;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.csvreader.CsvReader;
public class CSVReader 
{
	// creating method which will return hashMap having count for each sessionId list of PageId
	public Map<String, List<String>> csvReadMethod(String csvFilePath) 
	{
		// creating hashMap object for sessionId and pageId
		HashMap<String, List<String>> sessionWithPageIdHashMap = new HashMap<String, List<String>>();
		//.............Initializing Variables.............
		String  pageId ,sessionId;
		int csvSessionId, csvPageId;
		
		try 
		{
			// Initializing Predefined Properties class and making object of the same
			Properties prop = new Properties();
			String propFileName = "/home/bridgeit/Desktop/pageFlow/src/main/resources/config.properties";
			// passing propFileName to the FileInputStream class object 
			FileInputStream fis = new FileInputStream(propFileName);
			// calling load method of Properties class
				prop.load(fis);
			// ...............get the property value and store it into variable............
			csvPageId = Integer.parseInt(prop.getProperty("csv.pageid"));
			csvSessionId = Integer.parseInt(prop.getProperty("sessionId"));
			
			// Making Object of CsvReader class and reading csvFile
			CsvReader csvReaderObject = new CsvReader(csvFilePath, ',');
			
			// while loop goes till csvReaderObject has records
			while (csvReaderObject.readRecord())
			{ 
				// reading session id using  csvReaderObject
				sessionId = csvReaderObject.get(csvSessionId);
				// reading page id using  csvReaderObject
				pageId = csvReaderObject.get(csvPageId);
				// getting the value of hashMap and making a list of it
				List<String> pageIdList= sessionWithPageIdHashMap.get(sessionId);
				// if list is empty means for new sessionId make a new Page
				if(pageIdList== null)
				{
					// making new object of List of pageId
					pageIdList=new ArrayList<String>();
					// putting a key and value in hashMap
					sessionWithPageIdHashMap.put(sessionId, pageIdList);
				}
				// else pageId is added in already created pageIdList
				pageIdList.add(pageId);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		// returning sessionWithPageIdHashMap Object having pageId for each hashMap
		return sessionWithPageIdHashMap;
	}
}
	

