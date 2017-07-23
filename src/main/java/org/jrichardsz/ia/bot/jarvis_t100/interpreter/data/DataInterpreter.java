package org.jrichardsz.ia.bot.jarvis_t100.interpreter.data;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jrichardsz.ia.bot.jarvis_t100.interpreter.Interpreter;

public class DataInterpreter implements Interpreter{

	public Pattern instructionPattern  = Pattern.compile(".+show.+data");
	public String payload;
	
	@Override
	public boolean understandInstruction(String input) {
		Matcher matcher = instructionPattern.matcher(input);
		return matcher.find();
	}

	@Override
	public boolean existsPayload(String input) {
		return false;
	}

}
