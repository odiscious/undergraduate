/*
 * Qtr:			Autumn 2015
 * Class:		CSC212
 * Professor:	Dr. Julian Achim
 * Programmer:	Odiscious Dozier
 * Date:		11/3/2015
 * 
 * conditions: program expects all appropriate
 * letters from the user via console
 * sub-condition: if multiple characters are entered, on the
 * same line within the console,
 * by the user, the program will read the first character
 * of the given string.
 * 
 * If similar char(s) are entered then, the program with
 * display the index value of each char's index found on a new line
 * 
 * reference: see associated word document 
 */

import java.util.*;
public class LinearSearchAlgorithm {
	
	//hard coded for testing
	//private static char[] letters = {'a', 'c', 'z', 'x', 'k', 'm', 'o', 'a', 'd', 'f'};
	
	//Initialized to size 10 via assignment specifications
	private static char[] letters = new char[10];
	
	//Scanner needs to have global scope because, it needs to keep track of the running
	//program.  If it's embedded in a method, it will not keep in sync with the running
	//program and throw and error.
	private static Scanner console = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		solicitLettersFromUser();
		System.out.println("What letter would you like to find in the list of letters? ");
		String letter = console.next().toLowerCase();
		
		
		String result = searchForLetter(letter.charAt(0));
		
		if(result.charAt(0) == '-'){
			System.out.println("Letter is not found");
			return;
		}
		System.out.println(result);
		console.close();
		
	}
	
	/*
	 * solicitLettersFromUser()
	 * post-condition: returns void
	 */
	public static void solicitLettersFromUser() {
		
		System.out.println("Hi!  Please enter a letter: ");
		letters[0] = console.next().toLowerCase().charAt(0);
		int count = 1;
		while(count <= 9){
			System.out.println("Please enter another letter: ");
			//grabs first letter of the string regardless of quantity of char 
			//within the string
			letters[count] = console.next().toLowerCase().charAt(0);
			count++;
		}
		
	}
	
	/*searchForLetter(char letter)
	 *param: letter must be inserted as lower case
	 *post-condition:returns "-1" if not found; otherwise, a string 
	 *representation of the index.
	 *If more than one char exists of the requested search, an index value
	 *is represented on each new line within the concatenated string that is 
	 *returned to the caller.
	 */
	public static String searchForLetter(char letter) {
		if(letters.length == 0){
			return "-1";
		}
		String out = "";
		for(int i = 0; i < letters.length; i++){
			if(letters[i] == letter){
				out += i + "\n";
			}
		}
		if(out == ""){
			out += "-1";
		}
		return out;
	}

}
