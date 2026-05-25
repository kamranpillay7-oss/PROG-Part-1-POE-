/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.poepart1;

import java.util.Scanner;

public class PoePart1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Login login = new Login();

        System.out.println("===== REGISTRATION =====");

        System.out.print("Enter first name: ");
        String firstName = sc.nextLine();

        System.out.print("Enter last name: ");
        String lastName = sc.nextLine();

        login.setUserNames(firstName, lastName);

        String username;

        do {

            System.out.print("Enter username: ");
            username = sc.nextLine();

            if(login.checkUserName(username)) {

                System.out.println("Username successfully captured");
                break;

            } else {

                System.out.println("Username incorrectly formatted.");
            }

        } while(true);

        String password;

        do {

            System.out.print("Enter password: ");
            password = sc.nextLine();

            if(login.checkPasswordComplexity(password)) {

                System.out.println("Password successfully captured");
                break;

            } else {

                System.out.println("Password incorrectly formatted.");
            }

        } while(true);

        String phone;

        do {

            System.out.print("Enter cellphone number: ");
            phone = sc.nextLine();

            if(login.checkCellPhoneNumber(phone)) {

                System.out.println("Cell phone number successfully added.");
                break;

            } else {

                System.out.println("Cell phone number incorrectly formatted.");
            }

        } while(true);

        System.out.println("\nRegistration complete!");

        System.out.println("\n===== LOGIN =====");

        System.out.print("Enter username: ");
        String loginUsername = sc.nextLine();

        System.out.print("Enter password: ");
        String loginPassword = sc.nextLine();

        boolean loginStatus =
                login.loginUser(loginUsername, loginPassword);

        System.out.println(login.returnLoginStatus(loginStatus));

        if(loginStatus) {

            System.out.println("\nWelcome to QuickChat");

            System.out.print("How many messages would you like to send? ");

            int numberOfMessages = sc.nextInt();
            sc.nextLine();

            int sentMessages = 0;

            while(true) {

                System.out.println("\n===== MENU =====");
                System.out.println("1. Send Messages");
                System.out.println("2. Show recently sent messages");
                System.out.println("3. Quit");

                System.out.print("Select option: ");

                int choice = sc.nextInt();
                sc.nextLine();

                switch(choice) {

                    case 1:

                        if(sentMessages >= numberOfMessages) {

                            System.out.println("Message limit reached.");
                            break;
                        }

                        System.out.print("Enter recipient number: ");
                        String recipient = sc.nextLine();

                        System.out.print("Enter your message: ");
                        String text = sc.nextLine();

                        Message message =
                                new Message(sentMessages,
                                        recipient,
                                        text);

                        System.out.println(
                                message.checkRecipientCell());

                        System.out.println(
                                message.checkMessageLength());

                        if(text.length() <= 250 &&
                                recipient.matches("^\\+27\\d{9}$")) {

                            System.out.println("\n1. Send Message");
                            System.out.println("2. Disregard Message");
                            System.out.println("3. Store Message");

                            System.out.print("Choose option: ");

                            int option = sc.nextInt();
                            sc.nextLine();

                            System.out.println(
                                    message.sentMessage(option));

                            if(option == 1) {

                                sentMessages++;

                                System.out.println(
                                        "\n===== MESSAGE DETAILS =====");

                                System.out.println(
                                        message.printMessages());
                            }
                        }

                        break;

                    case 2:

                        System.out.println("Coming Soon.");
                        break;

                    case 3:

                        System.out.println("Goodbye!");

                        System.out.println(
                                "Total messages sent: "
                                + Message.returnTotalMessages());

                        System.exit(0);

                    default:

                        System.out.println("Invalid option.");
                }
            }
        }
    }
}        
        
        
        
        
    

