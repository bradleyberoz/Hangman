import java.io.*;
import java.util.*;

public class Hangman
{
    public static void main(String[] args) throws IOException
    {
        Scanner in = new Scanner(System.in);
        boolean runAgain = true;
       
        printGreeting();
     
        while(runAgain)
        {
            int lives = 6;
            String secretWord = "";
        char[] secretWordArray = new char[8];
            char[] ansArray = new char[8];
       int randNum = (int)(Math.random()*4)+1;
       if(randNum == 1)
       {
        secretWordArray[0] = 'd';
        secretWordArray[1] = 'i';
        secretWordArray[2] = 'n';
        secretWordArray[3] = 'o';
        secretWordArray[4] = 's';
        secretWordArray[5] = 'a';
        secretWordArray[6] = 'u';
        secretWordArray[7] = 'r';
        secretWord = "dinosaur";
       }
       if(randNum == 2)
       {
        secretWordArray[0] = 'c';
        secretWordArray[1] = 'o';
        secretWordArray[2] = 'm';
        secretWordArray[3] = 'p';
        secretWordArray[4] = 'u';
        secretWordArray[5] = 't';
        secretWordArray[6] = 'e';
        secretWordArray[7] = 'r';
        secretWord = "computer";
       }
       
       if(randNum == 3)
       {
        secretWordArray[0] = 's';
        secretWordArray[1] = 'o';
        secretWordArray[2] = 'f';
        secretWordArray[3] = 't';
        secretWordArray[4] = 'w';
        secretWordArray[5] = 'a';
        secretWordArray[6] = 'r';
        secretWordArray[7] = 'e';
        secretWord = "software";
       }
       
       if(randNum == 4)
       {
        secretWordArray[0] = 'f';
        secretWordArray[1] = 'o';
        secretWordArray[2] = 'o';
        secretWordArray[3] = 't';
        secretWordArray[4] = 'b';
        secretWordArray[5] = 'a';
        secretWordArray[6] = 'l';
        secretWordArray[7] = 'l';
        secretWord = "football";
       }
       
       System.out.println("\nYour secret word is: ");
       for(int i = 0; i<secretWordArray.length; i++)
       {
           ansArray[i] = '*'; //takes length of the secret word and prints it in '*'
       }
       
       System.out.print(Arrays.toString(ansArray).replace("[", "").replace("]", " ").replace(",", "").replace(" ", "")); //.replace to make the array one word
       
       
       while(lives>0) //ends when user dies (lives = 0)
       {
        lives = getGuess(secretWordArray, ansArray, secretWord, lives);
           
           if(ansArray[0]==secretWordArray[0] && ansArray[1]==secretWordArray[1] && ansArray[2]==secretWordArray[2] && ansArray[3]==secretWordArray[3] && ansArray[4]==secretWordArray[4] && ansArray[5]==secretWordArray[5] && ansArray[6]==secretWordArray[6] && ansArray[7]==secretWordArray[7])
           {
            System.out.println("\nYou won! Congratulations!\n\nWould you like to play again? Enter Yes or No:");
            String wannaPlayAgain2 = in.nextLine();
            if(wannaPlayAgain2.charAt(0)=='N' || wannaPlayAgain2.charAt(0)=='n')
            {
            System.out.println("\nThank you for playing.");
            runAgain = false;
            break;
            }
            else
            {
            break;
            }
           }
           
           //Death message & asks if you want to play again
           if(lives==0)
           {
            System.out.println("You ran out of lives!\n\nWould you like to play again? Enter Yes or No");
            String wannaPlayAgain = in.nextLine();
            if(wannaPlayAgain.charAt(0)=='N' || wannaPlayAgain.charAt(0)=='n')
            {
            System.out.println("\nThank you for playing!");
            runAgain = false;
            break;
            }
            else
            {
            break;
            }
           }
           
       } //end while (lives loop)
       
        } //end while (runAgain loop)
       
    } //end main
   
    public static void printGreeting()
    {
    System.out.println("Starting game...\n\n");
        System.out.println("Welcome to Simple Hangman! You have six lives, so be wise with your guesses.");
    }
 
    public static int getGuess(char[] secretWordArray, char[] ansArray, String secretWord, int lives) throws IOException
    {
    Scanner in = new Scanner(System.in);
    System.out.println("\n\nEnter your guess: ");
        String guessString = in.nextLine();
        char guess = guessString.charAt(0);
       
        if(secretWord.contains(guessString)) //correct guess
        {
            for(int j = 0; j<secretWordArray.length; j++)
            {
                if(secretWordArray[j] == guess)
                {
                    ansArray[j] = guess; //replaces the index in the filler array which has the users correct guess
                    System.out.println("The word contains the letter " + guess + "!");
                    System.out.println("Your word looks like this: " + Arrays.toString(ansArray).replace("[", "").replace("]", " ").replace(",", "").replace(" ", ""));
                }
            }
        }    
       
        else //incorrect guess
        {
            lives--;
            System.out.println("The word does not contain the letter  " + guess + ".\nYou have " + lives + " lives left.");
            System.out.println("\nYour word looks like this: " + Arrays.toString(ansArray).replace("[", "").replace("]", " ").replace(",", "").replace(" ", ""));
        }
        return lives;
    }
   
} //end class