package org.jrichardsz.ia.bot.jarvis_t100.interpreter.file;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public interface Reader {

	public HashMap<String, LinkedHashMap<Integer, List<?>>> loadInMemory(File fileName);
	
}
