import java.util.Scanner;

public class Simpletron
{
  public static void main(String[] args)
   {
     if (args.length != 7)
	  System.out.println("Error: please enter required amount of values (i.e. 7)");
	  
	 else
	{
	  System.out.println("***  Welcome to Simpletron!!!  ***");
	  System.out.println("***  Please enter your program one instruction  ***");
	  System.out.println("***  (or date word) at a time. I will display  ***");
	  System.out.println("***  the location number and a question mark (?).  ***");
      System.out.println("***  You then type the word for that location  ***");
      System.out.println("***  Type -9999 to stop entering your program.  ***");
	  
	  int[] rom = new int[100];
	  
	  Scanner get = new Scanner(System.in);
	  
	  
	  for (int input = 0; input < args.length; input++)
	      {
             rom[input] = Integer.parseInt(args[input]);
		  }
      
	  
	  for (int input = 0; input < args.length; input++)
	      {
             System.out.printf("%d   ?   +%d%n", input, rom[input]);
		  }
		  
      		  
	  System.out.println("***  Program loading completed  ***"); 
	  System.out.println("***  Program execution begins  ***");
	  
	  int instructionCounter = 0;
	  int instructionRegister;
	  int opeCode;
	  int operand;
	  int accumulator;
	  
	  final int Read = 10, Write = 11, Load = 20, Store = 21, Add = 30, Sub = 31, Div = 32, Multiply = 33, Move = 40, MoveNeg = 41, MoveZero = 42, Stop = 43;
	   
	  while( instructionCounter != 99 )
	    {
		   
	       instructionRegister = rom[instructionCounter];
	       opeCode = instructionRegister / 100;
	       operand = instructionRegister % 100;
		   accumulator = 0;
		   
		   System.out.println("\n\nREGISTERS: ");
		   System.out.printf("accumulator            %d%n", accumulator);
		   System.out.printf("instructionCounter     %d%n", instructionCounter);
           System.out.printf("instructionRegister    %d%n", instructionRegister);
           System.out.printf("operationCode          %d%n", opeCode);
           System.out.printf("operand                %d%n%n%n", operand);
		   
		   switch(opeCode)
			{
					
				case Read:
				 {
					System.out.println("Enter an integer");
					rom[operand] = get.nextInt();
				System.out.printf("The integer you entered is %d", rom[operand]);
					break;
				 }
				
				case Write:
				 {
					System.out.printf("Current operation code is %d%n", rom[operand]);	
					break;
				 } 
				
				case Load:
				 {
					accumulator = rom[operand];
					break;
				 }
				
				case Store:
				 {
					rom[operand] = accumulator;
					break;
				 }
				
				case Add:
				 {
					accumulator = accumulator + rom[operand];
					break;
			   	 }
				
				case Sub:
				 {
					accumulator = accumulator + rom[operand];
					break;
				 }
				
				case Div:
				 {
					accumulator = accumulator / rom[operand];
					break;
				 }
				 
				case Multiply:
				 {
					accumulator = accumulator * rom[operand];
					break;
				 }
				
				case Move:
				 {
					instructionCounter = operand;
					break;
				 }
				
				case MoveNeg:
				 {
					if(accumulator < 0)
					{
						instructionCounter = operand;	
					}
					
					break;
				 }
				
				case MoveZero:
				 {
					if(accumulator == 0)
					{
						instructionCounter = operand;	
					}
					break;
				 }
				case Stop:
			  	 {
					break;
				 }
			}
				instructionCounter++;
		}
	
        for(int input = 0; input < args.length; input++)
		{
		    System.out.printf("%d  ?   +%d%n", input, rom[input]);
        }		
	
	}
		

	}

}
		   
		   
		   
		   