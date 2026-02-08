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

// Main method
public class LibraryManagementSystem {
    public static void main(String[] args) {

        // The scanner is to allow the user to input data, and the Map is to store data within the program.
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
            System.out.println("Enter your choice: ");

            // Takes users option and initializes the corresponding actions
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    // This makes sure the user can only enter a 7-digit number, any other number will be invalid.
                    int patronId = 0;
                    boolean validPatronid = false;

                    while (!validPatronid) {
                        System.out.println("Enter Patrons 7-Digit ID:  ");
                        String input = scanner.nextLine();

                        if (input.length() == 7) {
                            patronId = Integer.parseInt(input);
                            validPatronid = true;
                        }
                        else {
                            System.out.println("Invalid ID. Please enter a 7-Digit ID.");
                        }
                    }
                    System.out.print("Enter Patrons firstName:  ");
                    String firstName = scanner.nextLine();
                    System.out.print("Enter Patrons lastName:  ");
                    String lastName = scanner.nextLine();
                    System.out.println("Enter Patrons Street Address:  ");
                    String street = scanner.nextLine();
                    System.out.println("Enter Patrons City:  ");
                    String city = scanner.nextLine();
                    System.out.println("Enter Patrons State:  ");
                    String state = scanner.nextLine();
                    System.out.println("Enter Patrons Zip Code:  ");
                    String zip = scanner.nextLine();

                    // The user can only enter a fine amount between $0 and $250 with decimals.
                    float overdueFine = -1;

                    while (overdueFine < 0 || overdueFine > 250) {
                        System.out.println("Enter Patron's Overdue Fine between 0 and 250 dollars:  ");
                        overdueFine = Float.parseFloat(scanner.nextLine());

                        if (overdueFine < 0 || overdueFine > 250) {
                            System.out.println("Invalid Overdue Fine Amount");
                        }
                    }
                    // Confirms the new created patron along with its new information was added into the LMS.
                    Patron patron = new Patron(patronId, firstName, lastName, street, city, state, zip, overdueFine);
                    patrons.put(patronId, patron);

                    System.out.println("Patron added:  " + patron);
                    break;
                case 2:

                    // Removes patron if ID exist, if it doesn't exist the system will notify the user.
                    System.out.println("To Remove Patron, Enter Their 7 Digit ID Number:  ");
                    int removePatronId = Integer.parseInt(scanner.nextLine());

                    if (patrons.containsKey(removePatronId)) {
                        Patron removed = patrons.remove(removePatronId);
                        System.out.println("Patron removed:  " + removed);
                    }
                else{
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
                }
            }
        }
    }


