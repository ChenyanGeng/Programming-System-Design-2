// Name:Chenyan Geng
// USC loginid:cgeng	
// CS 455 PA2
// Spring 2013
import java.util.*;

public class PolyProg {
    public static void main(String[] args) {
	Poly[] polyarr = new Poly[10];
	for (int i = 0; i<polyarr.length; i++){  //Initialize polinimials to zero
	 polyarr[i] = new Poly();
	 }
	while(true){ 
	  System.out.print("cmd>"); 
	  Scanner in = new Scanner(System.in);
	  String command = in.next();               //command stores the action user types: create, print, add, eval, quit or help
	//  if (!(in.hasNextLine())){                 //Examine if the command is end    
	   int num = in.nextInt();
	   
	   if (isValidNum(num)){                                  //Examine if num is in valid state
	    if (command.compareToIgnoreCase("create")==0){        //When command is create 
	      doCreate(polyarr, num);
	    }
	    else if (command.compareToIgnoreCase("print")==0){   //When command is print
	      doPrint(polyarr, num);
	    }
	    else if (command.compareToIgnoreCase("add")==0){     //When command is add
	     int num2 = in.nextInt(), num3 = in.nextInt();
	     if (isValidNum(num2)&&isValidNum(num3)){            //Examine if num2, num3 are both in valid state
	       doAdd(polyarr, num,num2,num3);
	       }
	    }
	    else if (command.compareToIgnoreCase("eval")==0){    //When command is eval
	     doEval(polyarr, num);
	    }
	   }
//	  }
	  else{
	    if (command.compareToIgnoreCase("quit")==0){    //When command is quit
	     break;                                              //exit the loop of while(true)
	    }
	    else if (command.compareToIgnoreCase("help")==0){    //When command is help
	     doHelp();
	    }
	    else{                                                 //When the command is not valid
	     System.out.println("ERROR: Illegal command.  Type 'help' for command options.");
	    }
	   }
        		
	}
    }

/**
       Create the 'num'-th polynomial in the array 'arr' containing 10 polynomials.
	   The coefficients and exponents of each term is typed in by the user.
	   Aware of the two conditions below:
	   1. Enter odd number of values: we will abandon the last value of the input and make a warning information
	   2. Exponent entered is negative: we will change it to absolute value and make a warning information
    */
private static void doCreate(Poly[] arr, int num){
  arr[num] = new Poly();                         //Release the value of arr[num] in case 
  System.out.println("Enter a space-separated sequence of coeff-power pairs terminated by <nl>"); 
  Scanner coex = new Scanner(System.in); 
	    String line = coex.nextLine();           //Store the whole line entered as a String
	    Scanner lineScanner = new Scanner(line); //Read from the String
	    while(lineScanner.hasNextDouble()) {     //Read the values in couple
		double coe = lineScanner.nextDouble();   //Read coefficient first
		if (!lineScanner.hasNextDouble()){       //Test condition 1
		 System.out.println("WARNING: Miss the last exponent.");
		 break;
		}
		int exp = lineScanner.nextInt();         //Then read the exponent
		if (exp<0){                              //Test condition 2
		 exp = -1*exp; 
		 System.out.println("WARNING: Exponent should be positive.");
		 }
		arr[num] = arr[num].add(new Poly(new Term(coe,exp)));  //store the new term in arr[num]
	}
}

/**
        Print the 'num'-th polynomial in the array 'arr' containing 10 polynomials.
    */
private static void doPrint(Poly[] arr, int num){
 System.out.println(arr[num].toFormattedString());
 }
 
/**
        Add the 'num1'-th polynomial and the 'num2'-th polynomial then
		store the sum in the 'numsum'-th polynomial.
		
    */ 
private static void doAdd(Poly[] arr, int numsum, int num1, int num2){
 arr[numsum] = arr[num1].add(arr[num2]);
 }

/**
        Get the value of the 'num'-th polynomial in arry 'arr' at a given value of x.
		Then print the value out.
		
    */  
private static void doEval(Poly[] arr, int num){
 System.out.print("Enter a floating point value for x: ");
 Scanner e = new Scanner(System.in);  
 double x = e.nextDouble();             // get the entered value of x
 System.out.println(Double.toString(arr[num].eval(x)));
}
/**
        Print the help information
		
    */  
private static void doHelp(){
      System.out.println("There is an array of 10 polynomials whose initial value is the zero polynomial.");
	  System.out.println("Users are able to manipulate any of these polynomials by inputing the commands"); 
	  System.out.println("shown as below:");
	  System.out.println("create n       create the n-th polynomial (n belongs to [0,9]);");
	  System.out.println("print n        print the n-th polynomial (n belongs to [0,9]);");
	  System.out.println("add n1 n2 n3   n1-th polynomial = n2-th polynomial + n3-th polynomial"); 
	  System.out.println("              (n1,n2,n3 belongs to [0,9]);");
	  System.out.println("eval n         get the value of the n-th polynomial"); 
	  System.out.println("              when x in it equals a fixed value set by user (n belongs to [0,9]);");
	  System.out.println("quit           end the commands;");
	  }

/**
       Return true if the num belongs to [0,9]
    */
private static boolean isValidNum(int num){
 boolean re = true;
 if (num>9){
	 System.out.println("ERROR: illegal index for a poly.  must be between 0 and 9, inclusive");
	 re = false;
	}
	return re;
 }	
}
 
