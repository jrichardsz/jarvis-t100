package org.jrichardsz.ia.bot.jarvis_t100.interpreter.file;


public class LookupFileReader {

	public static Reader getReaderByExtension(String extension){
		if(extension.equals("xlsx")){
			return new ExcelReader();
		}else {
			return null;
		}
	}
}
