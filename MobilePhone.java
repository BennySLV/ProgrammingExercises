package Section6;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Java Programming Masterclass for Software Developers
 *
 * Section 6: Arrays, Java in-built Lists, Autoboxing
 * and Unboxing
 *
 * This class will represent a mobile phone
 * object, which will contain all stored contacts.
 *
 * @author Ben Silveston
 */
public class MobilePhone {
    private Contact contact;
    private ArrayList<Contact> contactsList = new ArrayList<>();

    private static final Scanner SCANNER = new Scanner(System.in);

    /**
     * Constructor
     */
    public MobilePhone() {

    }

    /**
     * Add and store a new contact
     */
    private void addContact() {
        System.out.println("Please add a new contact with the following details: ");
        System.out.print("Contact name: ");
        String name = SCANNER.next();
        System.out.print("Contact phone number: ");
        String phoneNumber = SCANNER.next();

        boolean contactDetailsNotEntered = true;
        while(contactDetailsNotEntered) {
            if(name != null && phoneNumber != null) {
                this.contactsList.add(new Contact(name, phoneNumber));
                System.out.println("Contact added successfully");
                contactDetailsNotEntered = false;
            }
            else {
                System.out.println("Error - contact details have not been entered.");
                contactDetailsNotEntered = true;
            }
        }
    }

    /**
     * Modify the contact's name
     */
    private void modifyContactName() {
        System.out.print("Please enter the current name of the contact: ");
        String contactName = SCANNER.next();

        System.out.print("Please enter a new name for the contact: ");
        String newName = SCANNER.next();

        System.out.print("Confirm selection? (Y / N): ");
        String confirmAnswer = SCANNER.next();

        if(confirmAnswer.equalsIgnoreCase("Y") ||
                confirmAnswer.equalsIgnoreCase("Yes")) {
            for(int i = 0; i < this.contactsList.size(); i++) {
                if(contactName.equalsIgnoreCase(this.contactsList.get(i).getName())) {
                    if(!contactName.equalsIgnoreCase(newName)) {
                        this.contactsList.get(i).setName(newName);
                        System.out.println("Name has been updated successfully.");
                    }
                    else {
                        System.out.println("Error - name already exists and therefore cannot be updated.");
                    }
                }
            }
        }
    }

    /**
     * Modify the contact's phone number
     */
    private void modifyPhoneNumber() {
        System.out.print("Please enter the current name of the contact: ");
        String contactName = SCANNER.next();

        System.out.print("Please enter a new phone number for the contact: ");
        String newPhoneNumber = SCANNER.next();

        System.out.print("Confirm selection? (Y / N): ");
        String confirmAnswer = SCANNER.next();

        if(confirmAnswer.equalsIgnoreCase("Y") ||
                confirmAnswer.equalsIgnoreCase("Yes")) {
            for(int i = 0; i < this.contactsList.size(); i++) {
                if(contactName.equalsIgnoreCase(this.contactsList.get(i).getName())) {
                    if(!this.contactsList.get(i).getPhoneNumber().equalsIgnoreCase(newPhoneNumber)) {
                        this.contactsList.get(i).setPhoneNumber(newPhoneNumber);
                        System.out.println("Phone number has been updated successfully.");
                    }
                    else {
                        System.out.println("Error - phone number already exists and therefore cannot be updated.");
                    }
                }
            }
        }
    }

    /**
     * Modify the contact and its details
     */
    private void modifyContact() {
        System.out.print("Are you sure that you want to modify this contact and their details (Y / N)? : ");
        String answer = SCANNER.next();

        boolean hasNotSelected = true;
        while(hasNotSelected) {
            if(answer.equalsIgnoreCase("Y") || answer.equalsIgnoreCase("Yes")) {
                System.out.println("Please select from the following options: " +
                        "\n 1 - Modify the contact's name only " +
                        "\n 2 - Modify the contact's phone number only " +
                        "\n 3 - Modify both the contact's name and phone number");

                int selection = SCANNER.nextInt();
                switch(selection) {
                    case 1:
                        modifyContactName();
                        break;
                    case 2:
                        modifyPhoneNumber();
                        break;
                    case 3:
                        modifyContactName();
                        modifyPhoneNumber();
                        break;

                        default:
                            System.out.println("Please select a number from 1-3.");
                }
            }
            hasNotSelected = false;
        }
    }

    /**
     * Remove the contact and their details
     */
    private void removeContact() {
        System.out.print("Please enter the name of the contact: ");
        String contactName = SCANNER.next();

        System.out.print("Are you sure that you want to remove this contact and their details (Y / N)? : ");
        String answer = SCANNER.next();

        if(answer.equalsIgnoreCase("Y") || answer.equalsIgnoreCase("Yes")) {
            for(int i = 0; i < this.contactsList.size(); i++) {
                if(this.contactsList.get(i).getName().equalsIgnoreCase(contactName)) {
                    this.contactsList.remove(i);
                    System.out.println("Contact: '" + contactName + "' has been removed successfully.");
                    break;
                }
                else {
                    System.out.println("Error - name not found!");
                }
            }
        }
        else if(answer.equalsIgnoreCase("N") || answer.equalsIgnoreCase("No")) {
            printInstructions();
        }
        else {
            System.out.println("Please enter an appropriate answer (i.e. Yes/Y or No/N)");
        }
    }

    /**
     * Search for a specific contact in the contacts list
     */
    private void searchContact() {
        System.out.print("Please enter the name of the contact: ");
        String contactName = SCANNER.next();

        for(int i = 0; i < this.contactsList.size(); i++) {
            if(this.contactsList.get(i).getName().equalsIgnoreCase(contactName)) {
                System.out.println("Contact name: " + this.contactsList.get(i).getName() +
                        "\n Contact number: " + this.contactsList.get(i).getPhoneNumber());
            }
        }
    }

    /**
     * Print contact details
     * based on a given contact name
     */
    private void printListOfContacts() {
        for(Contact contact : this.contactsList) {
            System.out.println("Contact name: " + contact.getName() +
                    "\n Contact number: " + contact.getPhoneNumber());
        }
    }

    /**
     * Print instructions for application usage
     */
    private void printInstructions() {
        System.out.println("Please select from the following options: \n" +
                "\t 1 - Create new contact\n" +
                "\t 2 - Modify existing contact\n" +
                "\t 3 - Remove existing contact\n" +
                "\t 4 - Search for existing contact\n" +
                "\t 5 - Display list of existing contacts");
    }

    /**
     * Run the main part of the application
     */
    public void runApplication() {
        boolean applicationRunning = true;

        this.printInstructions();
        while(applicationRunning) {
            int selection = SCANNER.nextInt();
            boolean notSelected = true;

            while(notSelected) {
                switch(selection) {
                    case 1:
                        this.addContact();
                        break;
                    case 2:
                        this.modifyContact();
                        break;
                    case 3:
                        this.removeContact();
                        break;
                    case 4:
                        this.searchContact();
                        break;
                    case 5:
                        this.printListOfContacts();
                        break;
                    default:
                        System.out.println("Please select an option from 1-4, as described above.");
                }
                notSelected = false;
            }
            System.out.print("Do you wish to continue? : (Y / N) ");
            String answer = SCANNER.next();

            if(answer.equalsIgnoreCase("N") || answer.equalsIgnoreCase("No")) {
                closeApplication();
                applicationRunning = false;
            }
            else if(answer.equalsIgnoreCase("Y") || answer.equalsIgnoreCase("Yes")) {
                this.printInstructions();
                applicationRunning = true;
            }
            else {
                System.out.println("Please select an appropriate answer (i.e. 'Y / Yes' or ' N / No')");
            }
        }
    }

    /**
     * Close the application
     */
    private void closeApplication() {
        System.out.println("Application has closed.");
        System.exit(0);
    }
}