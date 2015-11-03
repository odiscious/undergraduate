import java.util.*;
/*
 * Recursive program
 * Assumptions: 
 * all values entered by the user will be
 * correct 
 * integer values: greater than 0 and not larger than 10, by user
 * alphabet characters of either y/n are entered - case sensitivity 
 * is accounted for.
 */
public class Recursion {
	public static void main(String[] args)
	{
		while(true)
		{
			System.out.println("Please enter a value, between 1 and 10 [inclusively] to find the Factorial of it: ");
			Scanner input = new Scanner(System.in);
			int num = input.nextInt();
			System.out.println("The Factorial of your value is: " + Factorial(num) + "\n\nWould you like"
					+ " to continue:? Y/N");
			String result = input.next();
			if(result.toUpperCase().compareTo("N") == 0)
			{
				System.out.println("Thanks, for stopping by.  End of line...");
				break;
			}
		}
		
	}
	public static int Factorial(int n)
	{
		if(n == 1)
		{
			return 1;
		}
		return n * Factorial(n-1);
	}

}
