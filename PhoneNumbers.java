/**
 * A personal phone directory contains room for first names and phone numbers for 6 people. 
 * Assign names and phone numbers for the first 4 people. Prompt the user for a name, and if the 
 * name is found in the list, display the corresponding phone number. If the name is not found 
 * in the list, prompt the user for a phone number, and add the new name and phone number to the list (use arrays). 
 * Continue to prompt the user for names until the user enters quit. After the arrays are full (containing 6 names), 
 * do not allow the user to add new entries. Save the file as PhoneNumbers.java
 * 
 * Author: Kenneth Jones
 * 
 * Date: 4/10/2022
 */

//Header file section
import java.io.*;
import java.util.Scanner;


public class PhoneNumbers {

    // Declare the variables
    private static String[] firstName = new String[6];
    private static String[] phNumber = new String[6];
    private static int count = 0;
    
    // Method definition of firstFourPeopleList
    // To add names and phone numbers of first 4 people
    private static void firstFourPeopleList(){
        
        // to add 4 contact for 1st run
        contactList("Kenneth", "256-453-2822");
        contactList("Rebecca", "256-201-0458");
        contactList("Jackie", "205-422-3818");
        contactList("Carla", "256-453-2050");
    }
    
    // Method definition of searchDir: It is used to search the name in the list
    // then return the phone number
    
    private static String searchDir(String name){
        for(int i=0; i<count; i++)
            if(name.equalsIgnoreCase(firstName[i]))
                return phNumber[i];
        return null;
    }
    
    // Method definition of contactList: It is used to add the new name and
    // phone number to the list until count of 6 reached
    
    private static boolean contactList(String name, String number){
        if(count == 6)
            return false;
        firstName[count] = name;
        phNumber[count] = number;
        return true;
    }
    
    // Main Method
    
    public static void main(String args[]){
        
        // Declare Variables
        String name, number;
        
        // Create Scanner classes object
        Scanner input = new Scanner(new InputStreamReader(System.in));
        
        // Call the method
        if(count == 0)
            firstFourPeopleList();
        
        // Prompt and read the input from the user
        System.out.println("Enter a name to search (or enter quit to exit): ");
        name = input.nextLine();
        
        // Use 'while' loop to run to prompt the user for names until the user enters 'quit'
        while(!name.equalsIgnoreCase("quit")){
            
            // If the name is found in the list, then display the corresponding phone number
            // by using searchDir method, otherwise add the new name and number to the list
            // by using contactList method
            number = searchDir(name);
            if(number == null){
                System.out.println("Name not fount in the phone directory list. \nPlease enter the number for " + name + ": ");
                number = input.nextLine();
                if(contactList(name, number))
                    System.out.println("Contact added successfully");
                else
                    System.out.println("Cannot add new contact. Phonebook is full");
            }
            else
                System.out.println("Contact found in the phone director list." + name + "'s phone number is: " + number);
                System.out.println("Enter a name to search (or enter quit to exit): ");
                name = input.nextLine();
        }
        
        // Display the complete data on the screen
        System.out.println("\nPhone Directory contains the following names and phone numbers: ");
        for(int i=0; i<count; i++){
            System.out.println(firstName[i] + "\t" + phNumber[i]);
        }
    }
}
