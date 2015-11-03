public class Driver{
	public static void main(String[] args)
	{
		ArrayList<String> students = new ArrayList<String>();
		
		System.out.println("Enter the number of students in this course: ");
		Scanner input = new Scanner(System.in);
		int sizeOfClass = input.nextInt();
		
		while(input.hasNext())
		{
			students.add(input.next());
		}
		System.out.println("The total number of students in the class is: " + sizeOfClass)
		System.out.println("The name of the students are (unordered): ");
		for(int i = 0; i < sizeOfClass; i++)
		{
			System.out.println(students.get(i));
		}
		System.out.println("Do you have any students to drop from this class?");
		Srring answer = input.next();
		boolean isTrue = true;
		if(answer.toLower() == "no")
		{
			isTrue = false;
		}
		ArrayList<String> dropped = new ArrayList<String>();
		while(isTrue)
		{
			System.out.println("Enter the name of the student who has dropped the class: ");
			String name = input.next();
			dropped.add(name);
			System.out.println("Do you have more students to drop from the class?"):
			if(input.next().toLower() == "no")
			{
				break;
			}
		}
		System.out.println("The number of students that dropped the class is: " + dropped.size());
		System.out.println("The names of the students that dropped the class are: ");
		for(int i = 0; i < dropped.size(); i++)
		{
			System.out.println(dropped.get(i));
		}
		
		
		
		
	}
}