/*CSC230
* odiscious dozier
* professor Dr. Wu
* SLP 03
*/
import java.util.*;
public class StackAssignment {
	public static void main(String[] args)
	{
		Stack<Integer> values = new Stack<Integer>();
		values.push(5);
		values.push(4);
		values.push(3);
		values.push(2);
		values.push(1);
		
		Queue<Integer> poppedVals = new LinkedList<Integer>();
		for(int i = 1; i <= 5; i++)
		{
			poppedVals.add(values.pop());
			
		}
		for(int i = 1; i <= 5; i++)
		{
			values.push(poppedVals.poll());
			
		}
		System.out.println(values.toString());
	}
	

}
