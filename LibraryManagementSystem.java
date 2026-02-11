/**
* Celine Wedderburn
* CEN-3024C - Software Development 1
* Jan 5, 2026
* LibraryManagementSystem.java

* The objective of this application is to allow the user to add patrons by inputting information from a text file,
*removing patrons by ID, or displaying a list of all patrons currently in the system. The output should be a menu where the
*user can choose their desired option depending on what they need to do with a patron.
*/

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class LibraryManagementSystem {

    public static void loadPatrons(String patronFile, Map<Integer, Patron> patrons) {
        try {
            Scanner fileScanner = new Scanner(new File(patronFile));

            // The patron class has a lot of data, so this allows the program to read the data in the text file separated by commas
            // The toString will still print the data into the correct format
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] data = line.split(",");

            // This loads the data from the text file based on the order in the Patron class
                int patronId = Integer.parseInt(data[0]);
                String firstName = data[1];
                String lastName = data[2];
                String street = data[3];
                String city = data[4];
                String state = data[5];
                String zip = data[6];

            // Makes sure the user can only enter a fine amount between $0 and $250 with decimals
                float overdueFine = Float.parseFloat(data[7]);
                if (overdueFine < 0 || overdueFine > 250) {
                    System.out.println("Invalid overdue fine amount: " + patronId);
                    continue;
                }

            //  Confirms the new created patron along with its new information added into the LMS
                Patron patron = new Patron(patronId, firstName, lastName, street, city, state, zip, overdueFine);
                patrons.put(patronId, patron);
            }
            fileScanner.close();
            System.out.println("Patrons successfully added from text file.");

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + patronFile);
        }
    }
    // Main Method
    public static void main(String[] args) {

        // The scanner is to allow the user to input an option, and the Map is to store data within the program.
        // Using map because it's a great way to store data internally instead of using a separate database.
        Scanner scanner = new Scanner(System.in);
        Map<Integer, Patron> patrons = new HashMap<>();
        boolean running = true;

        // Allows the menu to loop until the patron is done using it.
        // Also displays numbered options the users can choose from and allows the user to enter a choice.
        while (running) {
            System.out.println("\n    Library Management System    ");
            System.out.println("---------------------------------");
            System.out.println("1. Add Patron");
            System.out.println("2. Remove Patron");
            System.out.println("3. List All Patrons");
            System.out.println("4. Exit");
            System.out.println("Enter Your Choice: ");

            // Takes users option and initializes the corresponding actions
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Enter Patron Text File Path: ");
                    String patronFile = scanner.nextLine();
                    loadPatrons(patronFile, patrons);
                    break;
                case 2:

                    // Removes patron if ID exist, if it doesn't exist the system will notify the user.
                    System.out.println("To Remove Patron, Enter Their 7 Digit ID Number:  ");
                    int removePatronId = Integer.parseInt(scanner.nextLine());

                    if (patrons.containsKey(removePatronId)) {
                        Patron removed = patrons.remove(removePatronId);
                        System.out.println("Patron removed:  " + removed);
                    } else {
                        System.out.println("There is no Patron with that ID");
                    }
                    break;
                // List all current patrons that are currently in the system
                case 3:
                    System.out.println("All Patrons");
                    for (Patron currentPatrons : patrons.values()) {
                        System.out.println(currentPatrons);
                    }
                    break;
                // When the User is done using the program, this option allows them to exit
                case 4:
                    running = false;
                    System.out.println("You Have Successfully Exited The Program.");
                    break;
            }
        }
        scanner.close();
    }
}

