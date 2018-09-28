package CLam;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CLamLib {
    private static Scanner input;
    private static int num;
    private static int guesses;
    private static int guess;

    public static void main(String[] augs)
    {
        guesses = 0;
        int game = 0;
        while(game !=1 || game !=2)
        {
            System.out.println("Select your gamemode.");
            System.out.println("1: You guess the AI's number.");
            System.out.println("2: The AI guess your number.");
            try
            {
                input = new Scanner(System.in);
                game = input.nextInt();
            }
            catch (InputMismatchException e)
            {
                System.out.println("That was not a number.");
                input.next();
            }
            if (game == 1)
            {
                game1();
            }
            if (game == 2)
            {
                game2();
            }
        }
    }

    public static void game1()
    {
        System.out.println("Choose your difficulty.");
        System.out.println("1: 1-10");
        System.out.println("2: 1-100");
        System.out.println("3: 1-1000");
        System.out.println("4: 1-10000");
        theLevel();
    }

    public static void game2()
    {
        System.out.println("Enter a number from 1-100.");
        input = new Scanner(System.in);
        num = input.nextInt();
        if(num < 1 || num > 100)
        {
            game2();
        }
        aiGuess();
    }

    public static void theLevel()
    {
        input = new Scanner(System.in);
        int level = input.nextInt();
        if(level == 1)
        {
            num = (int) (Math.random() * (10) + 1);
            System.out.println("1-10");
        }
        if(level == 2)
        {
            num = (int) (Math.random() * (100) + 1);
            System.out.println("1-100");
        }
        if(level == 3)
        {
            num = (int) (Math.random() * (1000) + 1);
            System.out.println("1-1000");
        }
        if(level == 4)
        {
            num = (int) (Math.random() * (10000) + 1);
            System.out.println("1-10000");
        }
        if(level > 4)
        {
            System.out.println("Re-input the number.");
            theLevel();
        }
        startGame1();
    }

    public static void startGame1()
    {
        while(guess != num)
        {
        input = new Scanner(System.in);
        guess = input.nextInt();
        guesses++;
            if (guess < num)
            {
                System.out.println("Too Low.");
                System.out.println("Try again.");
            }
            if (guess > num)
            {
                System.out.println("Too High.");
                System.out.println("Try again.");
            }
        }
        System.out.println("You guessed it right.");
        System.out.println("You took " + (guesses-1) + " guesses.");
    }

    public static void aiGuess()
    {
        int max = 100;
        int min = 0;
        int range = max - min;
        guess = range/2;
        while(guess != num)
        {
            guesses++;
            if (guess < num)
            {
                min = guess;
                range = max - min;
                System.out.println("The AI guessed " + guess + ".");
                System.out.println("Too Low.");
                guess = guess + (range/2);
            }
            if (guess > num)
            {
                max = guess;
                range = max - min;
                System.out.println("The AI guessed " + guess + ".");
                System.out.println("Too High.");
                guess = guess - (range/2);
            }
        }
        System.out.println("The AI guessed " + guess + ".");
        System.out.println("The AI took " + guesses + " guesses.");
    }
}