import java.util.*;
public class LinearSearchAlgorithm {
	//hard coded for testing
	//private static char[] letters = {'a', 'c', 'z', 'x', 'k', 'm', 'o', 'a', 'd', 'f'};
	private static char[] letters = new char[10];
	
	//Scanner needs to have global scope because, it needs to keep track of the running
	//program.  If it's embedded in a method, it will not keep in sync with the running
	//program and throw and error.
	private static Scanner console = new Scanner(System.in);
	public static void main(String[] args) {
		
		solicitLettersFromUser();
		System.out.println("What letter would you like to find in the list of letters? ");
		String letter = console.next().toLowerCase();
		
		
		int result = searchForLetter(letter.charAt(0));
		if(result == -1){
			System.out.println("Letter is not found");
			return;
		}
		System.out.println(result);
		console.close();
		
	}
	
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
	//returns -1 if not found; otherwise, 'n' the index at the location
	//of the letter that was found.
	//param: letter must be inserted as lower case
	public static int searchForLetter(char letter) {
		if(letters.length == 0){
			return -1;
		}
		for(int i = 0; i < letters.length; i++){
			if(letters[i] == letter){
				return i;
			}
		}
		return -1;
	}

}
