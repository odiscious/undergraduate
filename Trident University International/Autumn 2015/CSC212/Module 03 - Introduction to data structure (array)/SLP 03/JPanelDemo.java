/*
 * Qtr:			Autumn 2015
 * Class:		CSC212
 * Professor:	Dr. Julian Achim
 * Programmer:	Odiscious Dozier
 * Date:		11/25/2015
 * 
 * class: 		JPanelDemo
 * extends: 	JFrame
 * implements:	ActionListener
 * 
 * Super class:			JFrame
 * Implementing class:	ActionListener
 * 
 * Use of - dialog boxes, text boxes, labels, and buttons.
 * 
 * Assumptions:
 * 1.	Students and exams must be of equal amounts
 * 2.	Since there is no student object to encapsulate student
 * data, students are structured from 1 - n; scores are
 * respective.
 * 3.	There is a check for correct input, but program just cycles
 * Integers are expected
 * 4.	Two ways to exit program - E/e typed into a text box or
 * clicking 'X' on the right corner of the Panel window
 * 5.	If no grades are entered, assume 'F'
 * 6.	If grades < 0, assume 'F'
 * Expected behavior: Insert requested data in the three text boxes,
 * click the button, and review results in a different window.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;

public class JPanelDemo extends JFrame implements ActionListener{
	
	private int check = 0;
	private int qtyStudents = 0;
	private int qtyExamScores;
	
	private int[][] studentData;
    private char[] letterGrade; //represents index + 1 as student # and associ
    //ated grade is the element value
	
	//all the pieces to add to the JPanel
	private JLabel lblExamScore = new JLabel("Please input your exam "
			+ "scores or type ‘E’ or ‘e’ to exit: ");
    private JLabel lblNumOfStudents = new JLabel("How many students "
    		+ "do you have? ");
    private JLabel lblNumOfExams = new JLabel("How many exam scores "
    		+ "do you have? ");
    private JLabel lblResults = new JLabel("The average letter grade "
    		+ "for each student is: "); //students by number
    private JTextField txtExamScores = new JTextField(20);
    private JTextField txtNumOfStudents = new JTextField(20);
    private JTextField txtNumOfExamScores = new JTextField(20);
    private JTextField txtResults = new JTextField(20);
    
    private JTextArea txtOutPut = new JTextArea();
    private JButton btnCompute = new JButton("Compute letter grade");
    

	//Not using an accessor or mutator because, there is no caller; as such, 
	//there is no need to force encapsulation. 
    private String[] letters = {"A", "B", "C", "D", "F"};
    
    // create a new panel with GridBagLayout manager
    private JPanel newPanel = new JPanel(new GridBagLayout());
	
     
    //super class and subclass - extending, not implementing
    public JPanelDemo() {
        super("Converting your exam score to a letter grade");
         btnCompute.addActionListener(this);
        
         
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);
         
        // add components to the panel
        constraints.gridx = 0;
        constraints.gridy = 0;     
        newPanel.add(lblNumOfStudents, constraints);
 
        constraints.gridx = 1;
        newPanel.add(txtNumOfStudents, constraints);
         
        constraints.gridx = 0;
        constraints.gridy = 1;    
        newPanel.add(lblNumOfExams, constraints);
         
        constraints.gridx = 1;
        newPanel.add(txtNumOfExamScores, constraints);
         
        constraints.gridx = 0;
        constraints.gridy = 2;
        newPanel.add(lblExamScore, constraints);
        
        
        constraints.gridx = 1;
        constraints.gridy = 2;
        newPanel.add(txtExamScores, constraints);
        
        
        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        newPanel.add(btnCompute, constraints);
         
        // set border for the panel
        newPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Student "
                		+ "Examination Panel"));
         
        // add the panel to this frame
        add(newPanel);
         
        pack();
        setLocationRelativeTo(null);
        
    }
    
    //Event listener for when the button is clicked; 
    public void actionPerformed(ActionEvent e) {  	
    	
    	//try block is designed to catch exceptions and display issues 
    	//to the user such as, erroneous inputs or no input at all
    	try{
	    	String numOfStudents = txtNumOfStudents.getText();
	    	String numOfExamScores = txtNumOfExamScores.getText();
	    	
	        String examScores = txtExamScores.getText(); //array of 
	        //scores from the input; use Scanner
	        
	        //preparing for next user input
	        txtNumOfStudents.setText("");
	        txtNumOfExamScores.setText("");
	        txtExamScores.setText("");
	        
	        //check for sentinel value E/e
	        if(examScores.toLowerCase().charAt(0) == 'e')
	        {
	        	newPanel.setEnabled(false);
	        	newPanel.setVisible(false);
	        	System.exit(0);
	        	return;
	        }
	        
	        //testing input data
	        qtyStudents = Integer.parseInt(numOfStudents);
	        qtyExamScores = Integer.parseInt(numOfExamScores);
	        
	        if((qtyStudents != qtyExamScores) | (qtyStudents < 1) |
	        		(qtyExamScores < 1)){
	        	//temporarily throw exception - can be modified to
	        	//behave different for erroneous user data
	        	throw new IllegalArgumentException();
	        }
	        else if(qtyStudents == 1)
	        {
	        	int temp = Integer.parseInt(examScores);
	        	calculateSingleGrade(temp);
	        	presentDataToUser();
	        }
	        else{
		        studentData = new int[qtyStudents][qtyExamScores];
		        
		        //fill student data with students 
		        for(int i = 0; i < qtyStudents; i++){
		        	studentData[0][i] = i+1;
		        }
		        
		        //add student grades to studentData
		        Scanner sc = new Scanner(examScores);
		        int count = 0;
		        while(sc.hasNext()){
		        	int temp = sc.nextInt();
		        	studentData[1][count] = temp;
		        	count++;
		        }
		        
		        calculateGrade(studentData);
		        presentDataToUser();
	        }
        }
        catch(Exception z)
        {
        	JFrame frame = new JFrame("All your bases are belong to us!!!");
            frame.setSize(400, 400);
            frame.setVisible(true);
            //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JOptionPane.showMessageDialog(frame, "Oops!  Check your input"
            		+ "values, please.  Click the"
            		+ " 'OK' button to continue.");
            frame.dispose();
        }
    	
    }
    
    /*
     * calculateGrade:
     * pre-condition:	students and scores must be the same qty
     * post-condition:	returns void; loads char[] field with 
     * student letter grades
     * params:	takes a two dimensional array of studentData
     */
    public void calculateGrade(int[][] scores)
    {
    	//set size of letter grade array
    	letterGrade = new char[qtyStudents];
    	 //deduce correct letter grade and 
        //set the letter grade text box
    	for(int i = 0; i < qtyStudents; i++){
    		
    		if(scores[1][i] >= 90 && scores[1][i] <= 100)
    		{
            	letterGrade[i] = 'A';  
    		}
    		else if(scores[1][i] >= 80 && scores[1][i] <= 89)
    		{
    			letterGrade[i] = 'B';
    		}
    		else if(scores[1][i] >= 70 && scores[1][i] <= 79)
    		{
    			letterGrade[i] = 'C';
    		}
    		else if(scores[1][i] >= 60 && scores[1][i] <= 69)
    		{
    			letterGrade[i] = 'D';
    		}
    		else 
    		{
    			letterGrade[i] = 'F';
    		}
    	}
        
    }
    
    /*
     * saves memory space on implementation
     */
    public void calculateSingleGrade(int score)
    {
    	letterGrade = new char[1];
    	if(score >= 90 && score <= 100)
		{
        	letterGrade[0] = 'A';  
		}
		else if(score >= 80 && score <= 89)
		{
			letterGrade[0] = 'B';
		}
		else if(score >= 70 && score <= 79)
		{
			letterGrade[0] = 'C';
		}
		else if(score >= 60 && score <= 69)
		{
			letterGrade[0] = 'D';
		}
		else 
		{
			letterGrade[0] = 'F';
		}
    }
    /*
     * presentDataToUser()
     * pre-condition: letter grades must have
     * previously been calculated.
     * post-condition: displays results to user
     * returns: void
     */
    public void presentDataToUser()
    {
    	JFrame frame = new JFrame("Here's the letter grades for the students: ");
        frame.setSize(800, 800);
        frame.setVisible(true);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        String toOut = "";
        for(int i = 0; i < letterGrade.length; i++){
        	toOut += "Student #: \t" + (i+1) + 
        			"\tStudent grade: \t" + letterGrade[i] + "\n";
        }
        
        txtOutPut.setLayout(new FlowLayout());
        txtOutPut.setText(toOut);
        frame.add(txtOutPut);
        JOptionPane.showMessageDialog(frame, "Whenever you're "
        		+ "ready to exit just click 'OK'.  \nEnd of line...");
        frame.dispose();
    }
}
