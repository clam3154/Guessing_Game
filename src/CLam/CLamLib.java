package CLam;

import java.util.Scanner;

public class CLamLib {
    private static Scanner input;
    private static int num;
    private static String name;
    private static int guesses;

    public static void main(String[] augs)
    {
        guesses = 0;
        System.out.println("Enter your name.");
        input = new Scanner(System.in);
        name = input.nextLine();
        System.out.println("Select your gamemode.");
        System.out.println("1: You guess the AI's number.");
        System.out.println("2: The AI guess your number");
        gameSelect();
    }

    public static void gameSelect()
    {
        input = new Scanner(System.in);
        int game = input.nextInt();
        if(game == 1)
        {
            game1();
        }
        if(game == 2)
        {
            game2();
        }
        if(game > 2)
        {
            System.out.println("Re-input the number.");
            gameSelect();
        }
    }

    public static void game1()
    {
        System.out.println("Choose your difficulty. 1, 2, 3, or 4.");
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
        }
        if(level == 2)
        {
            num = (int) (Math.random() * (100) + 1);
        }
        if(level == 3)
        {
            num = (int) (Math.random() * (1000) + 1);
        }
        if(level == 4)
        {
            num = (int) (Math.random() * (10000) + 1);
        }
        if(level > 4)
        {
            System.out.println("Re-input the number.");
            theLevel();
        }

    }

    public static void aiGuess()
    {
        
    }
}