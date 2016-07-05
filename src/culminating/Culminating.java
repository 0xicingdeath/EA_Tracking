/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package culminating;

import java.awt.BorderLayout; //import for borderLayout. 
import java.awt.Color; //import for color. 
import java.awt.Font; //import for font. 
import java.awt.GridLayout; //import for gridLayout. 
import java.awt.event.MouseEvent; //import for mouse event. 
import java.awt.event.MouseListener; //import for mouseListener. 
import java.awt.event.WindowAdapter; //import for windowAdapter. 
import java.awt.event.WindowEvent; //import for windowEvent. 
import java.io.BufferedReader; //import for BufferedReader.
import java.io.FileReader; //import for FileReader. 
import java.io.FileWriter; //import for FileWriter. 
import java.io.PrintWriter; //import for PrintWriter. 
import java.util.LinkedList; //import for Linked list. 
import javax.swing.ImageIcon; //image of ImageIcon. 
import javax.swing.JButton; //import for Jbutton
import javax.swing.JComboBox; //import for JComboBox. 
import javax.swing.JFrame; //import for JFrame 
import javax.swing.JLabel; //import for JLabels
import javax.swing.JOptionPane; //import for JOptionPane. 
import javax.swing.JPanel; //import for JPanel
import javax.swing.JScrollPane; //import for JScroll Pane.  
import javax.swing.JTextArea; //import for JTextArea. 
import javax.swing.JTextField; //import for JTextField. 
import javax.swing.JTextPane; //import forJTextPane
import javax.swing.WindowConstants; //import for WindowConstants. 

/**
 *
 * @author nataliechin
 */
public class Culminating implements MouseListener
{
    /**Note for future EA Member: 
     *  We have declared everything in this class (but the main method) as private for a reason - so please follow the trend if you are adding things :) 
     */
    
        //Declaration for Fonts
        Font titleFont = new Font("Arial", Font.BOLD, 14); 
        Font tableTitleFont = new Font ("Arial", Font.BOLD, 20);
        Font mainFont = new Font ("Arial", Font.PLAIN, 14);
    
        //Declaration for Colours
        private Color mainScreenGreen = new Color (73, 144, 9); 
        private Color moss = new Color (71, 144, 83); 
        private Color aqua = new Color (118, 214, 252);
        private Color blue = new Color (27, 74, 251); 
        private Color lightOrange = new Color(250, 212, 120); 
        private Color lightPink = new Color(235, 135, 215);
    
        private boolean tracing = true, found = false; ; 
        private LinkedList teachers = new LinkedList(); 
        private int numberOfEntries = 0; 
        
        //Declaration for instructions screen
        private JFrame instructionsFrame = new JFrame("Instructions");
        private JPanel instructionsPanel = new JPanel(new BorderLayout());
        private JTextArea instructionsText = new JTextArea();        
        
        //Declaration for things in the menu: 
    	private JFrame menuFrame = new JFrame("EA Teacher Report Card");
    	private JPanel menuPanel = new JPanel(new BorderLayout());
    	private JPanel menuSouth = new JPanel(new GridLayout(4,1));
		
        //buttons on the menu
        //buttons on the menu
    	private JButton instructionsButton = new JButton("Instructions");
    	private JButton insertEntryButton = new JButton("Insert Entry");
        private JButton editEntryButton = new JButton("Edit Entries");
    	private JButton viewEntryButton = new JButton("View All Entries");
    	private JButton exportButton = new JButton("Export Table");
        private JButton deleteButton = new JButton("Delete an Entry");
        //private JButton exitButton = new JButton("Exit Program");
    	
    	//things for inserting an entry
    	private JFrame insertEntryFrame = new JFrame("Insert Entry");
    	private JPanel insertEntryPanel = new JPanel(new BorderLayout());   
        private JPanel insertEntryNorthGrid = new JPanel(new GridLayout(14,0));        
        
        //everything that shows up on the Insert Entry frame (in order of appearance)
        private JTextField teacherName = new JTextField();
        
        private JLabel sunBlindsLabel = new JLabel("Sun and Blinds Level");
        private JLabel ventHeatLabel= new JLabel("Vents and Heat Level");
        private JLabel recycleGarbageLabel= new JLabel("Recycling and Garbage Level");
        private JLabel ecoriculumnLabel= new JLabel("Ecoriculumn Level");
        private JLabel posterLabel= new JLabel("Poster Level");
        private JLabel computerLabel= new JLabel("Computer Monitor Level");
        private JTextArea comments = new JTextArea();
        
        private JButton addEntryButton = new JButton("Add/Edit Entry");
        
        //arrays for drop down list
        private int [] sunBlindsLevels = {1, 2, 3, 4};
        private int [] ventHeatLevels = {1, 2, 3, 4};
        private int [] recycleGarbageLevels = {1, 2, 3, 4};
        private int [] ecoriculumnLevels = {1, 2, 3, 4};
        private int [] posterLevels = {1, 2, 3, 4};
        private int [] computerLevels = {1, 2, 3, 4};       
        
        //declaring the drop down lists and filling them with the arrays
        //int arrays are put into the drop down lists in the method initialiseBoxes()
        private JComboBox sunBlindsDrop = new JComboBox();
        private JComboBox ventHeatDrop = new JComboBox();
        private JComboBox recycleGarbageDrop = new JComboBox();
        private JComboBox ecoriculumnDrop = new JComboBox();
        private JComboBox posterDrop = new JComboBox();
        private JComboBox computerDrop = new JComboBox();
        
        
        //declaring frames, panels, gridlayouts, etc for the editEntry Frame
        private JFrame editEntryFrame = new JFrame("Edit Entry"); 
        private JPanel editEntryPanel = new JPanel(new BorderLayout());   
        private JPanel editEntryNorthGrid = new JPanel(new GridLayout(14,0));
        
        private JComboBox teacherNamesDrop = new JComboBox();
        
        //labels for the editFrame
        private JLabel editSunBlindsLabel = new JLabel("Sun and Blinds Level");
        private JLabel editVentHeatLabel= new JLabel("Vents and Heat Level");
        private JLabel editRecycleGarbageLabel= new JLabel("Recycling and Garbage Level");
        private JLabel editEcoriculumnLabel= new JLabel("Ecoriculumn Level");
        private JLabel editPosterLabel= new JLabel("Poster Level");
        private JLabel editComputerLabel= new JLabel("Computer Monitor Level");
        private JTextArea editComments = new JTextArea();
        
        //button to actually edit the entry
        private JButton editButton = new JButton("Edit Entry");
        
        //arrays for editFrame's drop down list
        private int [] editSunBlindsLevels = {1, 2, 3, 4};
        private int [] editVentHeatLevels = {1, 2, 3, 4};
        private int [] editRecycleGarbageLevels = {1, 2, 3, 4};
        private int [] editEcoriculumnLevels = {1, 2, 3, 4};
        private int [] editPosterLevels = {1, 2, 3, 4};
        private int [] editComputerLevels = {1, 2, 3, 4}; 
        
        //creating ComboBoxes for the editFrame
        private JComboBox editSunBlindsDrop = new JComboBox();
        private JComboBox editVentHeatDrop = new JComboBox();
        private JComboBox editRecycleGarbageDrop = new JComboBox();
        private JComboBox editEcoriculumnDrop = new JComboBox();
        private JComboBox editPosterDrop = new JComboBox();
        private JComboBox editComputerDrop = new JComboBox();        

        //array used for writing to a file
        private Object [] outFileArray = new Object[8];        
        
    //Declaration for Initialize Method: 
        //TeacherList teachers = new TeacherList(); 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        new Culminating(); 
    } //end of main method. 
    
    Culminating()
    {
    	instructionsButton.addMouseListener(this);
    	insertEntryButton.addMouseListener(this);
        editEntryButton.addMouseListener(this);
    	viewEntryButton.addMouseListener(this);
    	exportButton.addMouseListener(this);
        addEntryButton.addMouseListener(this);//button clicked when form is filled out
        deleteButton.addMouseListener(this); 
        editButton.addMouseListener(this);

        readFromFile();  //The first thing that the program does is get the information from the last save. 
    	menu(); //Runs the menu method. 
        insertEntry();         //Runs the insertEntry method. 
        editEntry();
        //menu(); 
    } //end of culminating constructor method. 
    
    private void menu()
    {
        JPanel centrePanel = new JPanel(); 
            centrePanel.setBackground(mainScreenGreen); 
        JLabel pic = new JLabel(new ImageIcon("S.png")); 
        centrePanel.add(pic); 
        //pic.setBackground(mainScreenGreen); 
        //pic.setForeground(mainScreenGreen); 
        instructionsButton.setForeground(mainScreenGreen); 
            instructionsButton.setFont(mainFont);
        insertEntryButton.setForeground(mainScreenGreen); 
            insertEntryButton.setFont(mainFont);
        editEntryButton.setForeground(mainScreenGreen);
            editEntryButton.setFont(mainFont);
        viewEntryButton.setForeground(mainScreenGreen); 
            viewEntryButton.setFont(mainFont);
        deleteButton.setForeground(mainScreenGreen);
            deleteButton.setFont(mainFont);
        exportButton.setForeground(mainScreenGreen);
            exportButton.setFont(mainFont); 
        

    	//adding buttons to BorderLayout.SOUTH, then to menuPane
        menuSouth.add(instructionsButton);
        menuSouth.add(insertEntryButton);
        menuSouth.add(editEntryButton);
        menuSouth.add(viewEntryButton);
        menuSouth.add(deleteButton);
        menuSouth.add(exportButton);
        //menuSouth.add(exitButton);
        menuPanel.add(menuSouth, BorderLayout.SOUTH);
        menuSouth.setBackground(mainScreenGreen); 
        menuSouth.setForeground(blue); 
        menuPanel.setBackground(mainScreenGreen);
        menuPanel.add(menuSouth, BorderLayout.SOUTH);
        menuPanel.add(centrePanel, BorderLayout.CENTER);

        //setting welcomeFrame
        menuFrame.setSize(800,725);
        menuFrame.setContentPane(menuPanel);
        menuFrame.setResizable(true);
        menuFrame.setVisible(true);
	
        menuFrame.addWindowListener
        (new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                int x = JOptionPane.showConfirmDialog(menuFrame, "Would you like to save your changes?", "Save?", JOptionPane.YES_NO_OPTION);                
                
                if (x == 0) 
                {
                    /** Vivian: Insert the code for the writeToFile method you need beforehand (ie: creating the object array)
                     * 
                     */
                    writeToFile();
                    //print out JOptionPane saying that it has been saved to a file. 
                    
                    System.exit(0); 
                } //end of if statement
                
                else 
                {
                       System.exit(0); 
                } //end of else statement  
            }
        }); 
    } //end of menu method. 
    
    private void initialiseBoxes()
    {
        for(int box=0; box<4; box++)
        {
            sunBlindsDrop.addItem(box+1);
            ventHeatDrop.addItem(box+1);
            recycleGarbageDrop.addItem(box+1);
            ecoriculumnDrop.addItem(box+1);
            posterDrop.addItem(box+1);
            computerDrop.addItem(box+1);
           
        } //end of for loop
    } //end of initialize boxes method. 
    
    private void initialiseEditingBoxes()
    {
        for(int box=0; box<4; box++)
        {
            editSunBlindsDrop.addItem(box+1);
            editVentHeatDrop.addItem(box+1);
            editRecycleGarbageDrop.addItem(box+1);
            editEcoriculumnDrop.addItem(box+1);
            editPosterDrop.addItem(box+1);
            editComputerDrop.addItem(box+1);
           
        } //end of for loop
    }
    
    private void removeBoxValues()
    {
        sunBlindsDrop.removeAllItems();
        ventHeatDrop.removeAllItems();
        recycleGarbageDrop.removeAllItems();
        ecoriculumnDrop.removeAllItems();
        posterDrop.removeAllItems();
        computerDrop.removeAllItems();
    }//end of removeBoxValues method. 
    
    private void removeEditingBoxValues()
    {
        editSunBlindsDrop.removeAllItems();
        editVentHeatDrop.removeAllItems();
        editRecycleGarbageDrop.removeAllItems();
        editEcoriculumnDrop.removeAllItems();
        editPosterDrop.removeAllItems();
        editComputerDrop.removeAllItems();
    }
    
/****************************************************************************************************************************************************************************
     * Description of Method - This method is run after the teachers linked list has changed in length. 
     * Author - Natalie. 
     * Precondition - The linked list teacher has to exist, and this method will update the ComboBox in the edit frame. 
     * PostCondition - The ComboBox will be updated. 
     ****************************************************************************************************************************************************************************/        
    
    private void setTeachers()
    {
        /** Created a new method here so the teacherNamesDrop would be updated
         *  This method is also called in the addEntry button. 
         * 
         */
        
        String [] array = new String[teachers.size()]; //Temporary array that was created to store all the teacher's names. 
        teacherNamesDrop.removeAllItems(); //Removing all the previous items inside the ComboBox for the name of the teachers. 
        for (int i = 0; i<teachers.size(); i++)
        {
            array[i] = new String(); //initializes new string. 
            Node newNode = (Node)(teachers.get(i)); //newNode is equivalent to node in linked list. 
            array[i] = newNode.getTeacherName();  //array is equal to that node's teacher. 
            
            teacherNamesDrop.addItem(array[i]); //adds the string inside that array into the teacher's name combo box. 
            
        } //end of for loop.         
            teacherNamesDrop.setForeground(mainScreenGreen);        
    } //end of setTeachers method. 
    
    private void editEntry()
    {
        //writeToFile(); 
        //readFromFile();
        initialiseEditingBoxes();
        setTeachers(); 
        
        editComments.setText("Place comments here");            
                editComments.setFont(mainFont);
            
            editEntryNorthGrid.setBackground(mainScreenGreen); 
            editEntryNorthGrid.setForeground(blue);
            
            //adding labels and drop down menus to the north GridLayout
            teacherName.setForeground(mainScreenGreen);
            editEntryNorthGrid.add(teacherNamesDrop);
            
            editSunBlindsLabel.setForeground(Color.white);  
                editSunBlindsLabel.setFont(titleFont);  
                editSunBlindsLabel.setBackground(mainScreenGreen);
            editEntryNorthGrid.add(editSunBlindsLabel);
                editSunBlindsDrop.setFont(mainFont);
                editSunBlindsDrop.setBackground(Color.white); 
                editSunBlindsDrop.setForeground(mainScreenGreen);            
            editEntryNorthGrid.add(editSunBlindsDrop);
            
            editVentHeatLabel.setForeground(Color.white); 
                editVentHeatLabel.setFont(titleFont);
            editEntryNorthGrid.add(editVentHeatLabel);
                editVentHeatDrop.setFont(mainFont);
                editVentHeatDrop.setBackground(Color.white); 
                editVentHeatDrop.setForeground(mainScreenGreen); 
            editEntryNorthGrid.add(editVentHeatDrop);
            
            editRecycleGarbageLabel.setForeground(Color.white); 
                editRecycleGarbageLabel.setFont(titleFont);
            editEntryNorthGrid.add(editRecycleGarbageLabel);
                editRecycleGarbageDrop.setFont(mainFont);
                editRecycleGarbageDrop.setBackground(Color.white);
                editRecycleGarbageDrop.setForeground(mainScreenGreen); 
            editEntryNorthGrid.add(editRecycleGarbageDrop);
            
            editEcoriculumnLabel.setFont(titleFont);
            editEcoriculumnLabel.setForeground(Color.white); 
            editEntryNorthGrid.add(editEcoriculumnLabel);
                editEcoriculumnDrop.setFont(mainFont);
                editEcoriculumnDrop.setBackground(Color.white); 
                editEcoriculumnDrop.setForeground(mainScreenGreen); 
            editEntryNorthGrid.add(editEcoriculumnDrop);
            
            editPosterLabel.setFont(titleFont);
            editPosterLabel.setForeground(Color.white); 
            editEntryNorthGrid.add(editPosterLabel);
                editPosterDrop.setFont(mainFont);
                editPosterDrop.setBackground(Color.white); 
                editPosterDrop.setForeground(mainScreenGreen);
            editEntryNorthGrid.add(editPosterDrop);
            
            editComputerLabel.setFont(titleFont);
            editComputerLabel.setForeground(Color.white); 
            editEntryNorthGrid.add(editComputerLabel);
                editComputerDrop.setFont(mainFont);
                editComputerDrop.setBackground(Color.white); 
                editComputerDrop.setForeground(mainScreenGreen);
            editEntryNorthGrid.add(editComputerDrop);

            editEntryPanel.add(editEntryNorthGrid, BorderLayout.NORTH);
                editComments.setBackground(Color.white);
                editComments.setForeground(mainScreenGreen);
                editComments.setFont(mainFont);
            editEntryPanel.add(editComments, BorderLayout.CENTER);
            addEntryButton.setBackground(Color.white); 
            addEntryButton.setForeground(mainScreenGreen);
            addEntryButton.setFont(mainFont);
            editEntryPanel.add(editButton, BorderLayout.SOUTH);

            //setting the insertEntryFrame
            editEntryFrame.setSize(450,600);
            editEntryFrame.setContentPane(editEntryPanel);
            editEntryFrame.setResizable(false);
            editEntryFrame.setVisible(false);

            editEntryFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }    
    
    private void instructions()
    {
        JTextPane instruct = new JTextPane(); 
        instruct.setContentType("text/html");
        //instruct.setText("<html><centre><p style = \font-size: " +12+ "color:" + blue + "INTRODUCTION\nHere you will find explanations for everything that is included in this program, ordered by their buttons on the menu screen. Simply close this window when you are done.\n\nContent:\n   1. Insert or Edit Entry\n   2. View All Entries\n   3. Export Table\n\n1. INSERT OR EDIT ENTRY\n\nLegend\n\nSunlight and Blinds\nConsider what is being used to light up the classroom. Is it mostly artificial light or natural sunlight?\nLevel 1=All lights are on; Level 4=All lights are off \n\nVents and Heat\nMake sure that the vents are not blocked by jackets/sweaters/bags etc so that air can pass through. The point here is to make sure that heat is conserved. \n\nRecycling and Garbage\nTo see how much of the recyling and garbage are in their proper bins.\n\nEcoriculumn \nThis is seeing how well the teacher applies environmental topics into their lesson plans/curriculumn.\nLevel 1=Doesn't apply to learning at all; Level 4=Exceeds Expectations(this will vary according to the subject. The Environmental Alliance member must use his/her own judgment)\n\nPosters\nTo see how many posters the teacher has in the room that helps students become aware of the environment. (signs for the recycling/garbage bins, eco facts, awareness posters, etc)\nLevel1=No posters; Level 4=More than 4 posters\n\nComputer Monitors\nSee how many monitors that aren't being used are on. \nLevel 1=0-59% are off\nLevel 2=60-69% are off\nLevel 3=70-79% are off\nLevel 4=80-100% are off.\n\n\n2. VIEW ALL ENTRIES\n\nAfter you have entered the teacher’s “ranks”, you can view them in a table format. When you click on certain headings, it will be sorted according to that field. In the table, the respective E.A. member will be able to view all of the teachers, their “rankings” for the categories and their respective comments. In addition, it will show the date of the most recent addition on each of the teachers. \n\n\n3. EXPORT TABLE\n\nThis will allow the information you saved to be exported to HTML. All of the files will be placed in a folder named “Teachers.” All individual files will be created using the teacher’s names. You will have to manually send these results to the teachers via tdsb.on.ca.\n\n\n\n\n\n\n\n\u00A9 Natalie Chin & Vivian Luu 2014. <\\p><\\centre><\\html>");
        instructionsText.setFont(mainFont);
        instructionsText.setText("INTRODUCTION\nHere you will find explanations for everything that is included in this program, ordered by their buttons on the menu screen. Simply close this window when you are done.\n\nContent:\n   1. Insert or Edit Entry\n   2. View All Entries\n   3. Export Table\n\n1. INSERT OR EDIT ENTRY\n\nLegend\n\nSunlight and Blinds\nConsider what is being used to light up the classroom. Is it mostly artificial light or natural sunlight?\nLevel 1=All lights are on; Level 4=All lights are off \n\nVents and Heat\nMake sure that the vents are not blocked by jackets/sweaters/bags etc so that air can pass through. The point here is to make sure that heat is conserved. \n\nRecycling and Garbage\nTo see how much of the recyling and garbage are in their proper bins.\n\nEcoriculumn \nThis is seeing how well the teacher applies environmental topics into their lesson plans/curriculumn.\nLevel 1=Doesn't apply to learning at all; Level 4=Exceeds Expectations(this will vary according to the subject. The Environmental Alliance member must use his/her own judgment)\n\nPosters\nTo see how many posters the teacher has in the room that helps students become aware of the environment. (signs for the recycling/garbage bins, eco facts, awareness posters, etc)\nLevel1=No posters; Level 4=More than 4 posters\n\nComputer Monitors\nSee how many monitors that aren't being used are on. \nLevel 1=0-59% are off\nLevel 2=60-69% are off\nLevel 3=70-79% are off\nLevel 4=80-100% are off.\n\n\n2. VIEW ALL ENTRIES\n\nAfter you have entered the teacher’s “ranks”, you can view them in a table format. When you click on certain headings, it will be sorted according to that field. In the table, the respective E.A. member will be able to view all of the teachers, their “rankings” for the categories and their respective comments. In addition, it will show the date of the most recent addition on each of the teachers. \n\n\n3. EXPORT TABLE\n\nThis will allow the information you saved to be exported to HTML. All of the files will be placed in a folder named “Teachers.” All individual files will be created using the teacher’s names. You will have to manually send these results to the teachers via tdsb.on.ca.\n\n\n\n\n\n\n\n\u00A9 Natalie Chin & Vivian Luu 2014");
        instructionsText.setEditable(true);
        instructionsText.setLineWrap(true);
	instructionsText.setWrapStyleWord(true);
        instructionsText.setBackground(mainScreenGreen);
        instructionsText.setForeground(Color.white);
        JScrollPane scroll = new JScrollPane(instructionsText);
        scroll.setBackground(mainScreenGreen);
        scroll.setForeground(blue);
        instructionsPanel.setForeground(blue); 
        instructionsPanel.setBackground(mainScreenGreen);
        instructionsPanel.add(scroll, BorderLayout.CENTER);
        
         //setting welcomeFrame
        instructionsFrame.setSize(400,400);
        instructionsFrame.setContentPane(instructionsPanel);
        instructionsFrame.setResizable(false);
        instructionsFrame.setVisible(false);
        
    } //end of instructions method. 
    
/****************************************************************************************************************************************************************************
     * Description of Method - This method runs right at the beginning, when the program is first run to get the data from the text file, "OutFile.txt"
     * Author - Natalie. 
     * Precondition - This method relies heavily on the LinkedList teacher (so it has to exist); the text file must exist and contain the information printed in the order outlined below; 
     * PostCondition - The linked list will contain all the saved teachers and their levels and information
     ****************************************************************************************************************************************************************************/        

    private void readFromFile()
    {
//        teachers.clear();
        try
        {
            BufferedReader infile = new BufferedReader(new FileReader("OutFile.txt")); 
            numberOfEntries = Integer.parseInt(infile.readLine()); 
            
            /* Note for Future Environmental Alliance Member: 
            * In the writeToFile method, the first thing that is printed is the number of teachers. Therefore, this for loop will run each time for different teachers. 
            *That being said, DO NOT touch the text file as the program WILL crash if a line is removed. 
            *This is the order that it reads in: 
                numberOfTeachers
                name
                sunlight
                recycling
                posters
                monitor
                comments about teacher
            */
            for (int i = 0; i<numberOfEntries; i++) 
            {
                String tempName = infile.readLine(); 
                    if (tracing) System.out.println("//Read in the name of the teacher: " +tempName);
                byte sunlight = Byte.parseByte(infile.readLine()); 
                    if (tracing) System.out.println("//Read in the sunlight level of the teacher: " +sunlight);
                byte vents = Byte.parseByte(infile.readLine()); 
                    if (tracing) System.out.println("//Read in the vents level of the teacher: " +vents);
                byte recycling = Byte.parseByte(infile.readLine()); 
                    if (tracing) System.out.println("//Read in the recycling level of the teacher: " +recycling);
                byte curriculumn = Byte.parseByte(infile.readLine());
                    if (tracing) System.out.println("//read in the curriculumn level of the teacher: " +recycling);
                byte posters = Byte.parseByte(infile.readLine()); 
                    if (tracing) System.out.println("//read in the poster level of the teacher: " +posters);
                int monitor = Integer.parseInt(infile.readLine());
                    if (tracing) System.out.println("//read in the monitor level of the teacher: " +monitor);
                String commentTeacher = infile.readLine(); 
                    if (tracing) System.out.println("Read in the commentTeacher level of the teacher: " +commentTeacher);
                
                //Creation of the Node
                if (tracing) System.out.println("Node is about to be created with the following values: " +tempName+ " "+ sunlight +" " + vents+ " "+ recycling+" "+posters+ "" +monitor + "" +commentTeacher);
                Node tempNode = new Node(tempName, sunlight, vents, recycling, curriculumn, posters, monitor, commentTeacher);
                if (tracing) System.out.println(tempNode);
                
                //Adding the node to the linked list. 
                if (tracing) System.out.println("Size of the teacher linked list before adding: " +teachers.size());
                
                teachers.add(tempNode);
                
                if (tracing) System.out.println("Added the newNode to the teachers after adding: " +teachers.size());
                
            } //end of for loop
            
        } //end of try statement. 
        catch (Exception e)
        {
            e.printStackTrace();  //this line will print the crash error, and will point directly to what is causing the problem. 
            System.out.println("Encountered an exception: " +e); 
        } //end of catch statement. 
    } //end of readToFile method. 
    
    private void insertEntry()
    {
            initialiseBoxes();
            teacherName.setText("Type the first name of the teacher here (eg. Ryk)");
                teacherName.setFont(mainFont);
            comments.setText("Place comments here");            
                comments.setFont(mainFont);
            
            insertEntryNorthGrid.setBackground(mainScreenGreen); 
            insertEntryNorthGrid.setForeground(blue);
            
            //adding labels and drop down menus to the north GridLayout
            teacherName.setForeground(mainScreenGreen);
            insertEntryNorthGrid.add(teacherName);
            
            sunBlindsLabel.setForeground(Color.white); 
                sunBlindsLabel.setFont(titleFont);
            insertEntryNorthGrid.add(sunBlindsLabel);
                sunBlindsDrop.setFont(mainFont);
                sunBlindsDrop.setBackground(Color.white); 
                sunBlindsDrop.setForeground(mainScreenGreen);            
            insertEntryNorthGrid.add(sunBlindsDrop);
            
            ventHeatLabel.setForeground(Color.white); 
                ventHeatLabel.setFont(titleFont);
            insertEntryNorthGrid.add(ventHeatLabel);
                ventHeatDrop.setFont(mainFont);
                ventHeatDrop.setBackground(Color.white); 
                ventHeatDrop.setForeground(mainScreenGreen); 
            insertEntryNorthGrid.add(ventHeatDrop);
            
            recycleGarbageLabel.setForeground(Color.white); 
                recycleGarbageLabel.setFont(titleFont);
            insertEntryNorthGrid.add(recycleGarbageLabel);
                recycleGarbageDrop.setFont(mainFont);
                recycleGarbageDrop.setBackground(Color.white);
                recycleGarbageDrop.setForeground(mainScreenGreen); 
            insertEntryNorthGrid.add(recycleGarbageDrop);
            
            ecoriculumnLabel.setFont(titleFont);
            ecoriculumnLabel.setForeground(Color.white); 
            insertEntryNorthGrid.add(ecoriculumnLabel);
                ecoriculumnDrop.setFont(mainFont);
                ecoriculumnDrop.setBackground(Color.white); 
                ecoriculumnDrop.setForeground(mainScreenGreen); 
            insertEntryNorthGrid.add(ecoriculumnDrop);
            
            posterLabel.setFont(titleFont);
            posterLabel.setForeground(Color.white); 
            insertEntryNorthGrid.add(posterLabel);
                posterDrop.setFont(mainFont);
                posterDrop.setBackground(Color.white); 
                posterDrop.setForeground(mainScreenGreen);
            insertEntryNorthGrid.add(posterDrop);
            
            computerLabel.setFont(titleFont);
            computerLabel.setForeground(Color.white); 
            insertEntryNorthGrid.add(computerLabel);
                computerDrop.setFont(mainFont);
                computerDrop.setBackground(Color.white); 
                computerDrop.setForeground(mainScreenGreen);
            insertEntryNorthGrid.add(computerDrop);

            insertEntryPanel.add(insertEntryNorthGrid, BorderLayout.NORTH);
                comments.setBackground(Color.white);
                comments.setForeground(mainScreenGreen);
                comments.setFont(mainFont);
            insertEntryPanel.add(comments, BorderLayout.CENTER);
            addEntryButton.setBackground(Color.white); 
            addEntryButton.setForeground(mainScreenGreen);
            addEntryButton.setFont(mainFont);
            insertEntryPanel.add(addEntryButton, BorderLayout.SOUTH);

            //setting the insertEntryFrame
            insertEntryFrame.setSize(450,600);
            insertEntryFrame.setContentPane(insertEntryPanel);
            insertEntryFrame.setResizable(false);
            insertEntryFrame.setVisible(false);

            insertEntryFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    } //end of the insertEntry method. 
    
/****************************************************************************************************************************************************************************
     * Description of Method - This method is all the code for displaying the table and viewing it. 
     * Author - Natalie. 
     * Precondition - The linked list has to have some kind of value (if it does not, we'll print an error message on the screen). 
     * PostCondition - The user will see all the teachers and their "marks" and comments formatted (relatively) neatly in a table. 
     ****************************************************************************************************************************************************************************/        
    
        
    private void display()
    {
        if (tracing) System.out.println("||Teacher Size: " +teachers.size());
          JFrame displayFrame = new JFrame(); 
          JPanel displayPanel = new JPanel(new BorderLayout());
          JPanel gridPanelCentre = new JPanel(new GridLayout(teachers.size()+1, 8)); 
            gridPanelCentre.setBackground(mainScreenGreen);
            gridPanelCentre.setForeground(Color.white);
          JLabel [][] gridCentre = new JLabel[teachers.size()+1][8];         
          JScrollPane scrollPane; 
          
          
                      
         // The following for loop initializes all the headings that are required for the table: Teacher Name, Blinds, Vents, Garbage, Curriculumn, Posters, Monitors, and Comments

         for (int column = 0; column<8; column++)
         {
                     gridCentre[0][column] = new JLabel();     
                     gridCentre[0][column].setBackground(Color.white);
                     gridCentre[0][column].setForeground(Color.white);
                     gridCentre[0][column].setFont(tableTitleFont);
                     if (column == 0)gridCentre[0][column].setText("Teacher Name");
                     else if (column == 1) gridCentre[0][column].setText("Blinds"); 
                     else if (column == 2) gridCentre[0][column].setText("Vents"); 
                     else if (column == 3) gridCentre[0][column].setText("Garbage"); 
                     else if (column == 4) gridCentre[0][column].setText("Curriculumn"); 
                     else if (column == 5) gridCentre[0][column].setText("Posters"); 
                     else if (column == 6) gridCentre[0][column].setText("Monitors Off"); 
                     else if (column == 7) gridCentre[0][column].setText("Comments");  
                     gridPanelCentre.add(gridCentre[0][column]);
         } //end of column
          
         Node temp; 
         if (tracing) System.out.println("|||Teacher Size: " +teachers.size());
         
         //The following for loop adds all the other entries that are required - but because the headings have taken up position [0], it prints it in the position+1 (and the arrays are already declared for the size+1). :) 
         for (int row = 0; row<teachers.size(); row++)
         {
             for (int column = 0; column<8; column++)
             {
                
                 
                 if (tracing) System.out.println("Value of row: " +row+" and value of column: " +column); 
                 gridCentre[row+1][column] = new JLabel();     
                 temp = (Node)(teachers.get(row));  
                 
                     if (tracing) System.out.println("Value inside [before adding]: " +row+1+ ", "+column+" is: " +gridCentre[row+1][column].getText()); 
                     
                    if (column == 0)gridCentre[row+1][column].setText(temp.getTeacherName());
                    else if (column == 1) gridCentre[row+1][column].setText(""+temp.getSunlight());
                    else if (column == 2) gridCentre[row+1][column].setText(""+temp.getVents());
                    else if (column == 3) gridCentre[row+1][column].setText(""+temp.getRecycling());
                    else if (column == 4) gridCentre[row+1][column].setText(""+temp.getCurriculumn()); 
                    else if (column == 5) gridCentre[row+1][column].setText(""+temp.getPosters());
                    else if (column == 6) gridCentre[row+1][column].setText(""+temp.getMonitors()); 
                    else if (column == 7) gridCentre[row+1][column].setText(""+temp.getComments());
                    
                     if (tracing) System.out.println("Value inside [after adding]: " +row+1+ ", "+ column+" is: " +gridCentre[row+1][column].getText());                    
                 
                    gridCentre[row+1][column].setFont(mainFont);
                    gridCentre[row+1][column].setBackground(mainScreenGreen);
                    if ((row+1)%2 == 0)gridCentre[row+1][column].setForeground(Color.white);                     
                    else gridCentre[row+1][column].setForeground(aqua);
                    gridPanelCentre.add(gridCentre[row+1][column]);                  
             } //end of for loop for the column. 
         } //end of for loop for the row. 
         
         //Declaration for the scroll pane to be around the gridPanelCentre (so that there can be both horizontal and vertical scrollers)
         scrollPane = new JScrollPane(gridPanelCentre);
         scrollPane.setBackground(mainScreenGreen);
         scrollPane.setForeground(Color.white);
         
         displayPanel.setBackground(mainScreenGreen);
         displayPanel.add(scrollPane, BorderLayout.CENTER); 
         displayFrame.setBackground(mainScreenGreen);
         displayFrame.setForeground(Color.white);
         displayFrame.setContentPane(displayPanel); 
         displayFrame.setSize(1500, 800); 
         displayFrame.setVisible(true); 
         displayFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
         
    } //end of display method. 
    
    
/****************************************************************************************************************************************************************************
     * Description of Method - This method runs right at the beginning, when the program is first run to get the data from the text file, "OutFile.txt"
     * Author - Natalie. 
     * Precondition - This method relies heavily on the LinkedList teacher (so it has to exist); the text file must exist and contain the information printed in the order outlined below; 
     * PostCondition - The linked list will contain all the saved teachers and their levels and information
     ****************************************************************************************************************************************************************************/            
    
    private void export()
    {
        //String tempName; 
        try
        {
            for (int i = 0; i<teachers.size(); i++)  //This for loop only runs for the values between 0-teachers.size(); 
            {
                Node tempNode = (Node)(teachers.get(i));  //creates a temporary node that is equivalent to that node at that position. 
                
                PrintWriter export = new PrintWriter(new FileWriter(""+tempNode.getTeacherName()+".html")); //declares a printWriter (in which a new FileWriter is created each time the loop runs). 
                
                String introduction = "Hello " +tempNode.getTeacherName()+ "! \n "
                        + " We hope you are doing well - these are the latest results for the Environmental Alliance Teacher Report Card. \n "
                        + "As a brief overview of the different headings, here are the things we are looking for: \n "
                        + ""; 

                String firstLine = "<html><head>"; //the first line required in html code. 
                String yourMarks = "<h1> "+tempNode.getTeacherName()+ "'s Marks </h1>";
                String sunlightLine = "<h2>Level for Sunlight</h2> " 
                        +"Members will be checking whether your classroom is relying on lights or natural sunlight."+ 
                        "<p> "+tempNode.getSunlight()+" </p>"; //Heading: Level for Sunlight; Paragraph: Value for sunlight
                String ventsLine = "<h2> Level for Vents </h2>"
                        +"Members will be checking whether the vents have been covered by articles of clothing or bags."+
                        " <p>" +tempNode.getVents()+" </p>";  //Heading: Level for Vents; Paragraph: Value for vents. 
                String recyclingLine = "<h2> Level for Recycling </h2>"+
                        "Members will be peering into your garabge and recycling bins to see whether majority of items are in the right places (ie: coffee cups in the garbage)"
                        +"<p>" +tempNode.getRecycling()+" </p>";  //Heading: Level for Recycling; Paragraph: Value for Vents
                String curriculumn = "<h2> Level for Eco-Curriculumn </h2>"
                        +"Members will be seeing how many of your lesson plans involve environmental aspects."
                        +"<p>" +tempNode.getCurriculumn()+" </p>";  //Heading: Level for Eco-Curriculum; Paragraph: value for eco-curriculumn
                String posters = "<h2> Level for Posters </h2>"
                       + "Members will be seeing how many posters you have in your classroom regarding environmental issues (recycling/garbage, eco facts, awareness, etc). " 
                       +"<p>" +tempNode.getPosters()+" </p>";  //Heading: Level for Posters; Paragraph: value for posters. 
                String monitorsOff = "<h2> Monitors </h2>"
                        + "Members will be seeing how many computers are not in use, with their monitors still on. " 
                        +"<p>" +tempNode.getMonitors()+" </p>";  //Heading: Monitors; Paragraph: value for monitors. 
                String comment = "<h2> Comments </h2> <p>" +tempNode.getComments()+" </p>";  //Heading: Comments; Paragraph: [insert comments here.]. 
                String lastLine = "</head></html>";  //the last line of code required in html coding.     
                String attention  = "<h1> Attention</h1> "
                        +" <p> If you are lacking posters, you may contact an E.A Representative, which includes (but is not limited to): Danielle Cao, Ana Vila or Kannan Gnanasegaram. </p>" + 
                        "<p> If you have any questions on the marks, feel free to contact a member of Environmental Alliance. </p>"; 
                
                export.println(firstLine); 
                export.println(yourMarks); 
                export.println(introduction);
                export.println(sunlightLine);
                export.println(ventsLine);
                export.println(recyclingLine);
                export.println(curriculumn);
                export.println(posters);
                export.println(monitorsOff);
                export.println(comment);
                export.println(lastLine);
                export.println(attention); 
                
                export.close();
                
            } //end of for loop. 
                JOptionPane.showMessageDialog(menuFrame, "Entries have been exported to HTML. \n They are in the project folder where the project is saved.", "Exported", JOptionPane.INFORMATION_MESSAGE);            
        } //end of try statement
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(menuFrame, "The entries could not be exported to HTML.", "Error!", JOptionPane.ERROR_MESSAGE);            
            e.printStackTrace();
        } //end of catch statement. 
            
    } //end of export method. 
    
    private void writeToFile()
    {
        try
        {
            PrintWriter outFile = new PrintWriter(new FileWriter("OutFile.txt"));
            outFile.println(teachers.size());
            for(int i = 0; i<teachers.size(); i++)
            {
                Node out = (Node)(teachers.get(i));
                outFile.println(""+out.getTeacherName());
                outFile.println(""+out.getSunlight());
                outFile.println(""+out.getVents());
                outFile.println(""+out.getRecycling());
                outFile.println(""+out.getCurriculumn());
                outFile.println(""+out.getPosters());
                outFile.println(""+out.getMonitors());
                outFile.println(""+out.getComments());
            } //end of for loop
            
            outFile.close();
        }
        catch(Exception e)
        {
            System.out.println("writeToFile crashed");
        }
    } //end of the writeToFile method.      
    
    @Override
    public void mouseClicked(MouseEvent whatClicked) throws NullPointerException
    {
        if(whatClicked.getSource()==instructionsButton) // if instructions button component was clicked 
        {
            instructions();
            instructionsFrame.setVisible(true);            
        }//instructions button clicked

        if(whatClicked.getSource()==insertEntryButton) // if insert Entry component was clicked 
        {	
             insertEntryFrame.setVisible(true);
        }

        if(whatClicked.getSource()==viewEntryButton) // if view entry button component was clicked 
        {
            if (tracing) System.out.println("In the viewEntry mouseListener method. ");
            display(); 
        }

        if(whatClicked.getSource()==exportButton) // if export button component was clicked 
        {
            export(); 
        }
        
        if(whatClicked.getSource()==addEntryButton) // if form is finished and button was pressed 
        {  
            
            boolean add = true; 

            if(tracing)System.out.println("\naddEntry button has been pressed\n");
            
            String teacher = teacherName.getText(); 
            
            //getting the values selected from JComboBoxes and put them into byte variables
            byte sun = (byte)(sunBlindsDrop.getSelectedIndex()+1);//+1 is to make the index number match with the levels again
            byte vent = (byte)(ventHeatDrop.getSelectedIndex()+1);
            byte recycle = (byte)(recycleGarbageDrop.getSelectedIndex()+1);
            byte ecoriculumn = (byte)(ecoriculumnDrop.getSelectedIndex()+1);
            byte poster = (byte)(posterDrop.getSelectedIndex()+1);
            int computer = (byte)(computerDrop.getSelectedIndex()+1);

            String comment = comments.getText();

            //NOTE FOR FUTURE EA MEMBER: 
            //this line of code would also work, casting it to an Integer object:
            //Then use .intValue to get the num out of the object and cast it to a byte.
            //byte sun = (byte)(((Integer)sunBlindsDrop.getSelectedItem()).intValue());
            Node info = new Node(teacher, sun, vent, recycle, ecoriculumn, poster, computer, comment);          
            
  
            for(int i=0; i<teachers.size(); i++) //for loop to go through the teachers. 
            {
                Node test = (Node)(teachers.get(i));
                
                if(teacher.equalsIgnoreCase(test.getTeacherName())) //comparing the teacherName to the node.  
                {
                    add = false; 
                }
            }//end for loop
            
            if (add == true) teachers.add(info);
            
            JOptionPane.showMessageDialog(insertEntryFrame, "outside loop Your entry has been added. \n The form will be reset for the next entry.", "Entry Added", JOptionPane.INFORMATION_MESSAGE);
            teacherName.setText("Type the first name of the teacher here (eg. Ryk)");
            comments.setText("Place comments here");
            removeBoxValues();
            initialiseBoxes();
            setTeachers();
            
            /**if(tracing)
            {
                //checking to see if data is inside Node
                System.out.println("Node info: \nTeacherName: " + info.getTeacherName() + "\nSunlight: " + info.getSunlight() + "\nVents: " + info.getVents() + "\nRecycling: " + info.getRecycling() + "\nCurriculumn: " + info.getCurriculumn() + "\nPosters: " + info.getPosters() + "\nMonitors: " + info.getMonitors() + "\nComments: " + info.getComments());

                //checking to see if data is inside linked list
                //cast to Node and get whatever is at position 0 in the linked list. Then access the methods by using .get().
                System.out.println("\nTesting TeacherName\n" + "TeacherName: " + ((Node)teachers.getLast()).getTeacherName() + "\nSunlight: " + ((Node)teachers.getLast()).getSunlight() + "\nVents: " + ((Node)teachers.getLast()).getVents() + "\nRecycling: " + ((Node)teachers.getLast()).getRecycling() + "\nCurriculumn: " + ((Node)teachers.getLast()).getCurriculumn() + "\nPosters: " + ((Node)teachers.getLast()).getPosters() + "\nMonitors: " + ((Node)teachers.getLast()).getMonitors() + "\nComments: " + ((Node)teachers.getLast()).getComments());
            }
            */ 
        } //end of addEntryButton. 
        
        if (whatClicked.getSource() == deleteButton)
        {
            //String answer = "";
            String answer = JOptionPane.showInputDialog("Please enter the name of the teacher you would like to delete: ");
            
            boolean found = false; 
            //if (tracing) System.out.println("%% found value: " +found);
            //found = teachers.removeFirstOccurrence(""+answer);
            //if (tracing) System.out.println("%% found value after removing: " +found);            
            if (answer == null)
            {
                menu();
            } //end of if statement
            else
            {
                for (int i = 0; i<teachers.size(); i++)
                {
                    Node temp = (Node)(teachers.get(i)); 
                    if (answer.length() >0 && answer.equalsIgnoreCase(temp.getTeacherName()))
                    {
                        teachers.remove(i);
                        found = true; 
                    } //end of if statement

                } //end of for loop

                    if (found)
                    {
                        setTeachers();                         
                        JOptionPane.showMessageDialog(menuFrame, "We found the entry and deleted it", "Deleted: " +answer, JOptionPane.INFORMATION_MESSAGE);                    
                    }
                    else JOptionPane.showMessageDialog(menuFrame, "We weren't able to find that entry", "Error!", JOptionPane.INFORMATION_MESSAGE);
            } //end of answer.length()>0 method. 
        } //end of deleteButton method. 
        
        if(whatClicked.getSource()==editEntryButton)//if the button to chose to edit an entry has been pressed
        {
            editEntryFrame.setVisible(true);
            
        }
        
        if(whatClicked.getSource()==editButton)
        {
            boolean foundEntry = false;             
            String editTeacherName = (String)teacherNamesDrop.getSelectedItem();
                if (tracing) System.out.println("$$: " +editTeacherName);
            //getting the values selected from JComboBoxes and put them into byte variables
            byte editSun = (byte)(editSunBlindsDrop.getSelectedIndex()+1);
                if (tracing) System.out.println("$$ Sun: " +editSun);
            byte editVent = (byte)(editVentHeatDrop.getSelectedIndex()+1);
                if (tracing) System.out.println("$$ Vent: " +editVent);
            byte editRecycle = (byte)(editRecycleGarbageDrop.getSelectedIndex()+1);
                if (tracing) System.out.println("$$ recycle: " +editRecycle);
            byte editEcoriculumn = (byte)(editEcoriculumnDrop.getSelectedIndex()+1);
                if (tracing) System.out.println("$$ ecoriculumn: " +editEcoriculumn);
            byte editPoster = (byte)(editPosterDrop.getSelectedIndex()+1);
                if (tracing) System.out.println("$$ Poster: " +editPoster);  
            int editComp = (byte)(editComputerDrop.getSelectedIndex()+1);
                if (tracing) System.out.println("$$ Computer: " +editComp);
            
            String editComment = editComments.getText();
                if (tracing) System.out.println("$$ Comment: " +editComment);
            
            Node editInfo = new Node(editTeacherName, editSun, editVent, editRecycle, editEcoriculumn, editPoster, editComp, editComment);
                if (tracing) System.out.println(editInfo);
                
            //writeToFile(); 
            //readFromFile();
            
            //JOptionPane.showMessageDialog(editEntryFrame, "Your entry has been edited. \n The form will be reset for the next entry you wish to edit.\nOtherwise, close this window", "Entry Edited", JOptionPane.INFORMATION_MESSAGE);
            
            for (int i = 0; i<teachers.size() && (foundEntry == false) ; i++)
            {
                if (tracing) System.out.println("$$ Value of i: " +i);
                Node other = (Node)(teachers.get(i));
                
                if ((editInfo.getTeacherName()).equalsIgnoreCase(other.getTeacherName()))
                {
                    if (tracing) System.out.println("$$ the edit info: " +editInfo.getTeacherName()+ " equals the other: " +other.getTeacherName());
                    if (tracing) System.out.println("$$ value of teacher.size before setting: " +teachers.size());
                    teachers.set(i, new Node(editTeacherName, editSun, editVent, editRecycle, editEcoriculumn, editPoster, editComp, editComment));
                    //if (tracing) System.out.println("$$ - Thing on editInfo:  "+editInfo);
                    if (tracing) 
                    {
                        Node tempWorking = (Node)(teachers.get(i));
                        System.out.println("$$$ value of tempWorking in position"+i+" : " +tempWorking);
                    } //end of if tracing. 
                    if (tracing) System.out.println("$$ value of teacher.size after setting: " +teachers.size());
                    //writeToFile();  
                    //readFromFile();
                    foundEntry = true; 
                    if (tracing) System.out.println("$$ the foundEntry thing is now: " +foundEntry);
                } 
                else
                {
                    foundEntry = false;
                } //end of else statement
            } //end of for loop
            
            if (foundEntry == true) JOptionPane.showMessageDialog(editEntryFrame, "We have edited that entry", "Done!", JOptionPane.INFORMATION_MESSAGE);
            else JOptionPane.showMessageDialog(editEntryFrame, "We were not able to find the entry...", "Error", JOptionPane.ERROR_MESSAGE);
                        
            
            editComments.setText("Place comments here");
            removeEditingBoxValues();
            initialiseEditingBoxes();
            setTeachers();

        } //end of editButton. 
        
    } //end of mouseClicked method. 

    @Override
    public void mousePressed(MouseEvent e) 
    {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) 
    {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) 
    {
        
    }

    @Override
    public void mouseExited(MouseEvent e) 
    {
        
    }
    
} //end of public class. 
