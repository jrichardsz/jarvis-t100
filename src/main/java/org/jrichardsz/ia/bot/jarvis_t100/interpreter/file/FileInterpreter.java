package org.jrichardsz.ia.bot.jarvis_t100.interpreter.file;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jrichardsz.ia.bot.jarvis_t100.interpreter.Interpreter;
/*
 * http://regexlib.com/Search.aspx?k=file+path&AspxAutoDetectCookieSupport=1
 * http://www.mkyong.com/regular-expressions/how-to-validate-image-file-extension-with-regular-expression/
 * */

public class FileInterpreter implements Interpreter{
	
	public Pattern instructionPattern  = Pattern.compile(".+read.+this.+file");
	public String payload;
	
	public boolean understandInstruction(String input){
		Matcher matcher = instructionPattern.matcher(input);
		return matcher.find();
	}
	
	public boolean existsPayload(String input){
		
		//search file name
		Pattern fileNamePattern  = Pattern.compile("([^\\\\/:*?\"<>|\r\n]+$)");
		Matcher matcher = fileNamePattern.matcher(input);
		boolean exist = matcher.find(); 
		
		if(!exist){
			return exist;
		}
		
		String fileName = matcher.group();
//		System.out.println("fileName_:"+fileName);
		
		Pattern startFilePattern  = Pattern.compile("(\\w:)|(/)");
		matcher = startFilePattern.matcher(input);
		
		
		
		if(matcher.find()){
//			System.out.println("path was found");
			String startOfFilePath = matcher.group();
//			System.out.println(input.indexOf(startOfFilePath));
//			System.out.println(input.lastIndexOf(fileName));
//			System.out.println(input.substring(input.indexOf(startOfFilePath), (input.indexOf(fileName)+fileName.length())));
			
			payload = input.substring(input.indexOf(startOfFilePath), (input.indexOf(fileName)+fileName.length()));
			
		}else{
			// there is not a windows or linux file path, only the name
			// file must be in the same path as jarvis (dangeours)
			payload = fileName;
		}
		
		return exist;
	}

	public String askForPayload() {
		return "There is no one file path in your instruction. Please give me the path of your file.";
	}
	
	public String getPayload() {
		return payload;
	}

	public void setPayload(String payload) {
		this.payload = payload;
	}
	
	public static void main(String[] args) {
		String instruction = "please read this file E:\\DyAGT\\SD01A_specV2.xls";
//		String instruction = "please read this file /abc/cde/SD01A_specV2.xls";
		System.out.println(instruction);
		FileInterpreter  fileInterpreter = new FileInterpreter();
		System.out.println("fileSynapsis.compute(input):"+fileInterpreter.understandInstruction(instruction));
		System.out.println("fileSynapsis.existsPayload(input):"+fileInterpreter.existsPayload(instruction));
		System.out.println("payload:"+fileInterpreter.getPayload());
		
	}	
	

}
