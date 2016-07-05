/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package culminating;

/**
 *
 * @author nataliechin
 */
public class Node 
{
    
        //Declaration of the variables (make sure they are all private!): 
            private String teacherName, comments; 
            private byte sunlight, vents, recycling, curriculumn, posters; 
            private int monitors; 
            //private Node link; 
            
/****************************************************************************************************************************************************************************
     * Description of Method - Constructor method for the node class. 
     * Author - Natalie. 
     * Precondition - Both the node class and the mainClass, culminating has to be in the same package. 
     * PostCondition - The node will be created. 
     ****************************************************************************************************************************************************************************/                    
            
            Node(String t, byte s, byte v, byte r, byte c, byte p, int m, String cs)
            {
                teacherName = t; 
                sunlight = s; 
                vents = v; 
                recycling = r; 
                curriculumn = c; 
                posters = p; 
                monitors = m; 
                comments = cs; 
            } //end of node constructor
            
/****************************************************************************************************************************************************************************
     * Description of Method - Returns the teacher's name. 
     * Author - Natalie. 
     * Precondition - Node has to exist. 
     * PostCondition - method will return node for use in program. 
     ****************************************************************************************************************************************************************************/                    
                        

            public String getTeacherName()
            {
                return teacherName; 
            } //end of getTeacherName method. 

/****************************************************************************************************************************************************************************
     * Description of Method - Sets the teacher's name.  
     * Author - Natalie. 
     * Precondition - Node has to exist and be declared properly. 
     * PostCondition - Node's teacherName has been changed. 
     ****************************************************************************************************************************************************************************/                    
                  
            public void setTeacherName(String other)
            {
                teacherName = other; 
            } //end of getTeacherName
            
/****************************************************************************************************************************************************************************
     * Description of Method - Get the teacher's sunlight value.
     * Author - Natalie. 
     * Precondition - Node has to exist and has to be declared using the node constructor. 
     * PostCondition - method will return the number for sunlight for use in the method. 
     ****************************************************************************************************************************************************************************/                    
      
            public byte getSunlight()
            {
                return sunlight;    
            } //end of getSunlight method. 
            
/****************************************************************************************************************************************************************************
     * Description of Method - Sets a new value to the teacher's sunlight value. 
     * Author - Natalie. 
     * Precondition - Node has to exist and has to be declared using the node constructor. 
     * PostCondition - method will set the number for sunlight, effectively updating the sunlight levels. 
     ****************************************************************************************************************************************************************************/                    
      
            public void setSunlight(byte other)
            {
                sunlight = other; 
            } //end of setSunlight method. 
            
/****************************************************************************************************************************************************************************
     * Description of Method - Get the teacher's vents value.
     * Author - Natalie. 
     * Precondition - Node has to exist and has to be declared using the node constructor. 
     * PostCondition - method will return the number for vents for use in the method. 
     ****************************************************************************************************************************************************************************/                    
      
            public byte getVents()
            {
                return vents; 
            } //end of getVents
            
/****************************************************************************************************************************************************************************
     * Description of Method - Sets the new value for vents into the corresponding node value. 
     * Author - Natalie. 
     * Precondition - Node has to exist and has to be declared using the node constructor. 
     * PostCondition - method will set the number for the vents, overriding the previous sunlight level. 
     ****************************************************************************************************************************************************************************/                    
      
            public void setVents(byte other)
            {
                vents = other; 
            } //end of setVents method. 
            
/****************************************************************************************************************************************************************************
     * Description of Method - Get the teacher's recycling value.
     * Author - Natalie. 
     * Precondition - Node has to exist and has to be declared using the node constructor. 
     * PostCondition - method will return the number for vents for use in the method. 
     ****************************************************************************************************************************************************************************/                    
      
            public byte getRecycling()
            {
                return recycling; 
            } //end of getRecycling method. 
            
/****************************************************************************************************************************************************************************
     * Description of Method - Set the teacher's recycling value.
     * Author - Natalie. 
     * Precondition - Node has to exist and has to be declared using the node constructor. 
     * PostCondition - method will set the number for vents for use in the method which overrides the previous recycling/garbage level. 
     ****************************************************************************************************************************************************************************/                    
      
            public void setRecycling(byte other)
            {
                 recycling = other; 
            } //end of setRecycling method. 
            
/****************************************************************************************************************************************************************************
     * Description of Method - Get the teacher's curriculum value.
     * Author - Natalie. 
     * Precondition - Node has to exist and has to be declared using the node constructor. 
     * PostCondition - method will return the number for the curriculum for use in other class. 
     ****************************************************************************************************************************************************************************/                    
      
            public byte getCurriculumn()
            {
                return curriculumn; 
            } //end of getCurriculumn method. 
            
/****************************************************************************************************************************************************************************
     * Description of Method - Assigning the sent value to the curriculumn level. 
     * Author - Natalie. 
     * Precondition - Node has to exist and has to be declared using the node constructor. 
     * PostCondition - method will set the new value of curriculumn, overriding the old one. 
     ****************************************************************************************************************************************************************************/                    
      
            public void setCurriculumn (byte other)
            {
                curriculumn = other; 
            } //end of setCurriculumn method. 
            
/****************************************************************************************************************************************************************************
     * Description of Method - Get the teacher's posters value.
     * Author - Natalie. 
     * Precondition - Node has to exist and has to be declared using the node constructor. 
     * PostCondition - Method will return the value that is assigned to the number of posters. 
     ****************************************************************************************************************************************************************************/                    
      
            public byte getPosters()
            {
                return posters; 
            } //end of getPosters method. 
            
/****************************************************************************************************************************************************************************
     * Description of Method - Setting the teacher's posters value. 
     * Author - Natalie. 
     * Precondition - Node has to exist and has to be declared using the node constructor. 
     * PostCondition - method will override the old value set for posters. 
     ****************************************************************************************************************************************************************************/                    
      
            public void setPosters(byte other)
            {
                posters = other; 
            } //end of setPosters
            
/****************************************************************************************************************************************************************************
     * Description of Method - Get the teacher's monitors value.
     * Author - Natalie. 
     * Precondition - Node has to exist and has to be declared using the node constructor. 
     * PostCondition - Method will return the number of monitors assigned to that teacher. 
     ****************************************************************************************************************************************************************************/                    
      
            public int getMonitors()
            {
                return monitors; 
            } //end of getMonitors method. 
            
/****************************************************************************************************************************************************************************
     * Description of Method - Setting the teacher's set monitors value. 
     * Author - Natalie. 
     * Precondition - Node has to exist and has to be declared using the node constructor. 
     * PostCondition - Method will override the old value that was assigned to monitors 
     ****************************************************************************************************************************************************************************/                    
      
            public void setMonitors (int other)
            {
                monitors = other; 
            } //end of setMonitors method. 
            
/****************************************************************************************************************************************************************************
     * Description of Method - Getting the teacher's comments. 
     * Author - Natalie. 
     * Precondition - Node has to exist and has to be declared using the node constructor. 
     * PostCondition - Method will return the value inside comments. 
     ****************************************************************************************************************************************************************************/                    
      
            public String getComments()
            {
                return comments; 
            } //end of getComments method. 
            
/****************************************************************************************************************************************************************************
     * Description of Method - Setting the teacher's comments. 
     * Author - Natalie. 
     * Precondition - Node has to exist and has to be declared using the node constructor. 
     * PostCondition - The method will override the old value inside comments :) 
     ****************************************************************************************************************************************************************************/                    
      
            public void setComments(String other)
            {
                comments = other; 
            } //end of setComments method.    
                        
/****************************************************************************************************************************************************************************
     * Description of Method - Clearing all the comments inside a teacher's node. 
     * Author - Natalie. 
     * Precondition - Node has to exist and has to be declared using the node constructor. 
     * PostCondition - method will clear the all the comments. 
     ****************************************************************************************************************************************************************************/                    
      
            public void clearComments()
            {
                comments = ""; 
            } //end of clearComments method.
            
/****************************************************************************************************************************************************************************
     * Description of Method - When a coder tries to print out the node, this is what it it prints out instead of the memory address 
     * Author - Natalie. 
     * Precondition - Node has to exist and has to be declared using the node constructor. 
     * PostCondition - Method will tell you whether the node exists. 
     ****************************************************************************************************************************************************************************/                    
                  
            public String toString()
            {
                return "" + teacherName + " "+ sunlight+ " " +vents+ " "+ recycling+ " "+ curriculumn+ " "+ posters+ " " + monitors + " "+ comments; 
            } //end of toString method. 
            
            
} //end of class. 
