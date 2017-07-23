package org.jrichardsz.ia.bot.jarvis_t100.interpreter;


public interface Interpreter {

	public boolean understandInstruction(String input);
	
	public boolean existsPayload(String input);
	
}
