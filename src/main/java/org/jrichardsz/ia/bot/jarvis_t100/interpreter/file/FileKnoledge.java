package org.jrichardsz.ia.bot.jarvis_t100.interpreter.file;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.commons.io.FilenameUtils;

public class FileKnoledge {
	
	private ArrayList<String> extensions;
	private String status;
	private HashMap<String, LinkedHashMap<Integer, List<?>>> data;
	
	public FileKnoledge() {
		enableKnowledge();
	}

	public void enableKnowledge() {
		extensions = new ArrayList<String>();
		extensions.add("xlsx");
	}

	public boolean isKnown(String filePath){
		
		String extension = FilenameUtils.getExtension(filePath);
		
		if(extension==null || extension.equals("")){
			status = "I dont understand an empty extension";
			return false;
		}
		
		File file = new File(filePath);
		
		if(file==null || !file.exists()){
			status = "File does not exist";
			return false;
		}
		
		if(extensions.contains(extension)){
			
			Reader reader = LookupFileReader.getReaderByExtension(extension);
			data = reader.loadInMemory(file);
			status = "Done";
			return true;
		}else {
			status = String.format("I dont understand files with %s extension", extension);
			return false;
		}
		
		
		
	}
	
	public String whatHappened(){
		return status;
	}

	public HashMap<String, LinkedHashMap<Integer, List<?>>> getData() {
		return data;
	}
	
	
}
