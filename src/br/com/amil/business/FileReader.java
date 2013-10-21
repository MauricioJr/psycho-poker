package br.com.amil.business;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FileReader {
	
	private static final String resourceFile = "src/main/resources/game.txt";

	public FileInputStream getResourceFile(String filePath) throws FileNotFoundException{
		String userDir = System.getProperty("user.dir");
		return new FileInputStream(userDir + filePath);
	}
	
	public List<String> getFileLine() throws IOException{
		String logLineContent = new String();
		List<String> resourceLines = new ArrayList<String>();
		
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(getResourceFile(resourceFile)));
		
		if((logLineContent = bufferedReader.readLine()) != null){
			
		}
			return null;
	}
}
