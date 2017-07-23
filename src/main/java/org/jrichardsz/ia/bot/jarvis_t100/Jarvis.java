package org.jrichardsz.ia.bot.jarvis_t100;

import java.util.Scanner;

import org.jrichardsz.ia.bot.jarvis_t100.interpreter.SimpleInterpreter;

/**
 * By Jricahrdsz
 */
public class Jarvis
{
	
  private String username = null;	
  private SimpleInterpreter simpleInterpreter = new SimpleInterpreter();

  public static void main (String[] args)
  {

	try{
		
		Jarvis bot = new Jarvis();
		
		bot.execute();
	}catch(Exception e){
		e.printStackTrace();
	}
  
  }
  
  public void execute() throws Exception{
	  
    // create a scanner so we can read the command-line input
    Scanner scanner = new Scanner(System.in);

    //  prompt for the user's name
    System.out.print("Enter your name: ");

    // get their input as a String
    username = scanner.nextLine();

    // prompt for their age
    System.out.println("Hi "+username +"\n");
	System.out.println("What can I do for you? : ");

	boolean exitBoot = false;
	
	while(!exitBoot){
		
		// get their input as a String
		System.out.print("\n\n>");
		String input = scanner.nextLine();
		
		if(input != null && input.equals("bye")){
			exitBoot = true;
		}
		
		System.out.print(simpleInterpreter.interpret(input));
		
		Thread.sleep(3000);
		
	}	
	
	scanner.close();
	  
  }

}