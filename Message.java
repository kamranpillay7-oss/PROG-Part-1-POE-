/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poepart1;

import java.util.Random;

public class Message {

    private String messageID;
    private int messageNumber;
    private String recipient;
    private String message;
    private String messageHash;

    private static int totalMessages = 0;

    public Message(int messageNumber, String recipient, String message) {

        this.messageNumber = messageNumber;
        this.recipient = recipient;
        this.message = message;

        this.messageID = generateMessageID();
        this.messageHash = createMessageHash();
    }

    private String generateMessageID() {

        Random random = new Random();

        long number = 1000000000L +
                (long)(random.nextDouble() * 9000000000L);

        return String.valueOf(number);
    }

    public boolean checkMessageID() {

        return messageID.length() <= 10;
    }

    public String checkRecipientCell() {

        if (recipient.matches("^\\+27\\d{9}$")) {

            return "Cell phone number successfully captured.";

        } else {

            return "Cell phone number is incorrectly formatted or does not contain an international code.";
        }
    }

    public String checkMessageLength() {

        if (message.length() <= 250) {

            return "Message ready to send.";

        } else {

            int extraCharacters = message.length() - 250;

            return "Message exceeds 250 characters by "
                    + extraCharacters +
                    ", please reduce the size.";
        }
    }

    public String createMessageHash() {

        String[] words = message.split(" ");

        String firstWord = words[0].toUpperCase();

        String lastWord = words[words.length - 1].toUpperCase();

        return messageID.substring(0, 2)
                + ":" +
                messageNumber
                + ":" +
                firstWord
                + lastWord;
    }

    public String sentMessage(int option) {

        switch(option) {

            case 1:
                totalMessages++;
                return "Message successfully sent.";

            case 2:
                return "Press 0 to delete the message.";

            case 3:
                return "Message successfully stored.";

            default:
                return "Invalid option.";
        }
    }

    public String printMessages() {

        return "Message ID: " + messageID
                + "\nMessage Hash: " + messageHash
                + "\nRecipient: " + recipient
                + "\nMessage: " + message;
    }

    public static int returnTotalMessages() {

        return totalMessages;
    }
}  

