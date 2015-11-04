/*
 * Qtr:			Autumn 2015
 * Class:		CSC212
 * Professor:	Dr. Julian Achim
 * Programmer:	Odiscious Dozier
 * Date:		11/2/2015
 * 
 * conditions: program expects all appropriate
 * input from the user via console
 * 
 * reference: see associated word document 
 */
import java.util.ArrayList;
import java.util.Scanner;

public class SelectionSortingAlgorythimDesc {
	//An array list does not necessarily need to have it's size specified in the constructor,
	//But, I set the limit to 10 to define its finite value as per the assignment.
	private static ArrayList<Integer> numbers = new ArrayList<Integer>(10);
	public static void main(String[] args) {
		//hard coded
		/*numbers.add(1);
		numbers.add(13);
		numbers.add(-2);
		numbers.add(54);
		numbers.add(238);
		numbers.add(34);
		numbers.add(65);
		numbers.add(10);*/
		//testing for 0 and 1 (size())
		//numbers.add(1);
		
		//solicit data from the user - assumes all valid inputs (no boundry testing)
		Scanner input = new Scanner(System.in);
		int count = 0;
		while(count < 10){
			count++;
			System.out.println("Please enter a real number: ");
			numbers.add(input.nextInt());
		}
		selectionSort(numbers);
		System.out.println(numbers.toString());
	}
	public static void selectionSort(ArrayList<Integer> x) {
		if(x.size() == 0 || x.size() == 1){
			return;
		}
		int index = 0;
		int temp = 0;
		//set max value and its index
		int max = numbers.get(0);
		
		
		//perform selection sort
		for(int i = 0; i < numbers.size(); i++){
			max = numbers.get(i);
			index = i;
			//interesting thought --> j can be set to either i or i + 1
			for(int j = i; j < numbers.size(); j++){
				
				if(max < numbers.get(j)){
					max = numbers.get(j);
					index = j;
				}
			}
			//swap the max value
			if(max > numbers.get(i))
			{
				temp = numbers.get(i);
				numbers.set(i, max);
				numbers.set(index, temp);
			}
		}
	}
}
