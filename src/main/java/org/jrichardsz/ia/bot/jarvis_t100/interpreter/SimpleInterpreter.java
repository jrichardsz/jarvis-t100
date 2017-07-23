package org.jrichardsz.ia.bot.jarvis_t100.interpreter;

import org.jrichardsz.ia.bot.jarvis_t100.interpreter.file.FileInterpreter;
import org.jrichardsz.ia.bot.jarvis_t100.interpreter.file.FileKnoledge;

public class SimpleInterpreter {
	
	public static String STATUS_DONE = "Done";
	public static String STATUS_I_DONT_UNDERSTAND = "I don't understand.";
	
	private FileInterpreter  fileInterpreter = new FileInterpreter();
	private FileKnoledge fileKnoledge;

	public String interpret(String input){
		
		if(fileInterpreter.understandInstruction(input)){
			
			if(fileInterpreter.existsPayload(input)){
				
				fileKnoledge = new FileKnoledge();
				
				if(fileKnoledge.isKnown(fileInterpreter.getPayload())){
					return STATUS_DONE;
				}else {
					return fileKnoledge.whatHappened();
				}
				
				
			}else {
				return fileInterpreter.askForPayload();
			}
			
		}else {
			return STATUS_I_DONT_UNDERSTAND;
		}
		
	}
}
