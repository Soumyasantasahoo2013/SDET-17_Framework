package com.crm.comcast.GenericUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import org.json.simple.parser.JSONParser;
import org.testng.annotations.Test;

/**
 * This class reads the data from JSON file
 * @author Chaitra
 *
 */
public class JSONFileUtility {
	
	/**
	 * This method reads the data from JSON file
	 * @author Chaitra
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	public String readDataFromJSON(String key) throws Throwable
	{   
		//Read the data from json
		FileReader inputFile = new FileReader(IPathConstants.JSONPATH);
		
		//parse the json object into java data stream
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(inputFile);
		
		//type cast the object into hashmap and read the data in key value format
		HashMap jobj=(HashMap)obj;
		String value = jobj.get(key).toString();
		return value;
	}

}
