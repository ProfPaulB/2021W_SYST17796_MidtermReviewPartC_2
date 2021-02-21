package midtermreviewcodeforpartc;

import java.util.Scanner;

/**
 * The signIn page for BlackJack. Takes in a user name and password and then validates the password before creating a
 * new user in the list of possible users. To be used as the beginning code for MidtermReview C.
 *
 * @author dancye, 2019
 * @author Paul Bonenfant, February 2021
 */
public class BlackJack {

    private Player[] players = new Player[10];//room for 10 players!

    /**
     * Main method with call to private run method, to encapsulate our main functionality.
     *
     * @param args - not used
     */
    public static void main(String[] args) {
        BlackJack game = new BlackJack();
        game.run();
    }

    /**
     * method that takes in the User's name and chosen password and then continues prompting until the password is valid
     * based on the following two rules: 1. The password must be at least length 8 2. The password must contain at least
     * one uppercase character
     *
     */
    private void run() {
        
        int userCount = 0;//keep track of number of players for array
        Scanner sc = new Scanner(System.in);
        
        System.out.println("please enter your user name:");
        String userName = sc.nextLine();
        
        boolean validPassword = false;
        String password = "";
        
        while (!validPassword) {
            System.out.println("Passwords must have at least 8 characters");
            System.out.println("Passwords must have at least one Uppercase character");
            System.out.println("Please enter your desired password:");

            password = sc.nextLine();
            int upperCharCount = 0;
            //iterate over each character to see if it is a special character
            
            for (int i = 0; i < password.length(); i++) {
                if (!(Character.isUpperCase(password.charAt(i)))) {
                    //now we know there is at least one special character
                    upperCharCount++;
                }
            }
            if (upperCharCount > 0 && password.length() > 7) {
                validPassword = true;
            }
        }//loop only ends when password is valid so now we create the Player

        Player newUser = new Player(userName, password);
        players[userCount] = newUser;//add the new user to the user list

        userCount++;

        System.out.println("New User Added");
        System.out.println("UserName: " + userName);
        System.out.println("Password: just kidding can't show password");

    }//end run method

}//end class
