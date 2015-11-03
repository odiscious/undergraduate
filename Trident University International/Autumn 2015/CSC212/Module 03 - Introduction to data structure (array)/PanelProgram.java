/*
 * Qtr:			Autumn 2015
 * Class:		CSC212
 * Professor:	Dr. Julian Achim
 * Programmer:	Odiscious Dozier
 * Date:		10/21/2015
 * 
 * conditions: program expects all appropriate
 * input from the user via dialog box
 * 
 */
import java.awt.GridBagLayout;
import java.util.Scanner;
import javax.swing.*;

public class PanelProgram extends JPanel{
	
	//Not using an accessor or mutator because, there is no caller; as such, 
	//there is no need to force encapsulation. 
	private static String[] letters = {"A", "B", "C", "D", "F"};
	
	public static void main(String[] args) {
		// set look and feel to the system look and feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
         
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new JPanelDemo().setVisible(true);
            }
        });
		/*JPanel newPanel = new JPanel();
		newPanel.setLayout(new GridBagLayout());
		JLabel label = new JLabel("Welcome! Please input your exam "
				+ "score or type ‘E’ or ‘e’ to exit: ");
		JTextField examScore = new JTextField(20);
		 
		newPanel.add(label);
		newPanel.add(examScore);*/
		/*boolean stopped = false;
		Scanner input = new Scanner(System.in);
		//System.out.println("Welcome! Please input your exam score or type ‘E’ or ‘e’ to exit: ");
		String score = input.next();
		
		if(score.toLowerCase().charAt(0) == 'e' )
		{
			System.out.println("End of line...");
			return;
		}
		while(!stopped){
			int result = Integer.parseInt(score);
			
			if(result >= 90 && result <= 100)
			{
				System.out.println(letters[0]);
				
			}
			else if(result >= 80 && result <= 89)
			{
				System.out.println(letters[1]);
				
			}
			else if(result >= 70 && result <= 79)
			{
				System.out.println(letters[2]);
				
			}
			else if(result >= 60 && result <= 69)
			{
				System.out.println(letters[3]);
				
			}
			else 
			{
				System.out.println(letters[4]);
				
			}
			System.out.println("Hi, again.  Please input your exam score or "
					+ "type ‘E’ or ‘e’ to exit: ");
			score = input.next();
			if(score.toLowerCase().charAt(0) == 'e' )
			{
				stopped = true;
			}
		}
		System.out.println("End of line...");*/
	}

}
