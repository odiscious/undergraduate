/*
 * Qtr:			Autumn 2015
 * Class:		CSC212
 * Professor:	Dr. Julian Achim
 * Programmer:	Odiscious Dozier
 * Date:		12/14/2015
 * 
 * conditions: program expects all appropriate
 * input from the user via dialog box
 * 
 * reference: see associated word document and
 * java file
 */
import java.awt.GridBagLayout;
import java.util.Scanner;
import javax.swing.*;

public class PanelProgram extends JPanel{
	
	private static String[] letters = {"A", "B", "C", "D", "F"};
	
	public static void main(String[] args) {
		// set look and feel to the system look and feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
        	//to see where things have gone astray
            ex.printStackTrace();
        }
         
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
            	//on the Heap
                new JPanelDemo().setVisible(true);
            }
        });
	}

}
