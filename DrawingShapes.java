import java.util.*;

public class DrawingShapes 
{
	public static void main (String[] args)
	{
		// initializing variables 
		String letter;
		int length = 0;
		int height = 0;
		
		Scanner user = new Scanner (System.in);
		
		System.out.println("Enter a shape: r t h o p");
		letter = user.next(); 
		
		// switch statements that executes code for the following shapes that correspond with the letter 
		switch (letter)
		{
			case "r": // case for rectangle
				System.out.println("Enter a length");
				length = user.nextInt();
				if (length <= 1) // error case for length
				{
					System.out.println("Length must be greater than 1\nGoodbye!");
					System.exit(0);
				}
				System.out.println("Enter a height");
				height = user.nextInt();
				Rectangle(length, height);
				break;
				
			case "t": // case for triangle
				System.out.println("Enter a length");
				length = user.nextInt();
				Triangle(length);
				break;
				
			case "h": // case for hexagon
				System.out.println("Enter a length");
				length = user.nextInt();
				Hexagon(length);
				break;
				
			case "o": // case for octagon
				System.out.println("Enter a length");
				length = user.nextInt();
				Octagon(length);
				break;
				
			case "p": // case for pentagon
				System.out.println("Enter a length");
				length = user.nextInt();
				Pentagon(length);
				break;
				
			// error case for an invalid shape 
			default:
				System.out.println("Invalid Shape\nGoodbye!");
		}
		user.close();
	}
	
	// method for rectangle that take in parameters of length and height 
	public static void Rectangle(int length, int height) 
	{	
		if (height <= 1) // error case for height 
		{
			System.out.println("Height must be greater than 1\nGoodbye!");
			System.exit(0);
		}
		
		System.out.println("Below is a " + length + " by " + height + " rectangle of *");
		for (int i = 0; i < height; i++)
		{
			for (int j = 0; j < length; j++)
			{
				System.out.print("*");
			}
		System.out.println();
		}
	}
	
	// method for triangle that takes in a parameter of length 
	public static void Triangle(int length) 
	{
		if (length <= 1) // error case for length 
		{
			System.out.println("Length must be greater than 1\nGoodbye!");
			System.exit(0);
		}
		
		System.out.println("Below is a triangle with two side lengths of " + length + " *");
        for (int i = 1; i <= length; i++) 
        {
            for (int j = length; j > i; j--) // Printing the leading spaces
            {
                System.out.print(" ");
            }
            for (int k = 1; k <= (2 * i - 1); k++) // Printing the asterisks
            {
                System.out.print("*");
            }
            System.out.println();
        }
	}
	
	// method for hexagon that takes in a parameter of length 
	public static void Hexagon(int length) 
	{
		if (length <= 1) // error case for length 
		{
			System.out.println("Length must be greater than 1\nGoodbye!");
			System.exit(0);
		}
		
		System.out.println("Below is hexagon with sides of length " + length + " *");
        for (int i = 1; i <= length; i++) // printing the top portion of the hexagon
        {
            for (int j = length; j > i; j--) // Printing the leading spaces
            {
                System.out.print(" ");
            }
            for (int k = 1; k <= length + (2 * (i - 1)); k++) // Printing the asterisks
            {
                System.out.print("*");
            }
            System.out.println();
        }
    	
        for (int a = length - 1; a >= 1; a--) // printing the bottom portion of the hexagon
        {
            for (int b = length; b > a; b--) // Printing the leading spaces
            {
                System.out.print(" ");
            }
            for (int c = 1; c <= length + (2 * (a - 1)); c++) // Printing the asterisks
            {
                System.out.print("*");
            }
        System.out.println();
        }
	}
	
	// method for octagon that takes in a parameter of length 
	public static void Octagon(int length) 
	{
		if (length <= 1) // error case for length 
		{
			System.out.println("Length must be greater than 1\nGoodbye!");
			System.exit(0);
		}
		
		System.out.println("Below is octagon with sides of length " + length + " *");
        for (int i = 1; i <= length - 1; i++) // printing the top portion of the hexagon
        {
            for (int j = length; j > i; j--) // Printing the leading spaces
            {
                System.out.print(" ");
            }
            for (int k = 1; k <= length + (2 * (i - 1)); k++) // Printing the asterisks
            {
                System.out.print("*");
            }
            System.out.println();
        }
        
    	for (int x = 0; x < length; x++) // printing the middle portion of the hexagon
    	{
    		for (int y = 0; y <= (2 * length) + length - 3; y++) 
    		{
    			System.out.print("*");
    		}
    	System.out.println();
    	}
    	
        for (int a = length - 1; a >= 1; a--) // printing the bottom portion of the hexagon
        {
            for (int b = length; b > a; b--) // Printing the leading spaces
            {
                System.out.print(" ");
            }
            for (int c = 1; c <= length + (2 * (a - 1)); c++) // Printing the asterisks
            {
                System.out.print("*");
            }
        System.out.println();
        }
	}
	
	// method for pentagon that takes in a parameter of length 
	public static void Pentagon(int length) 
	{
		if (length <= 1) // error case for length 
		{
			System.out.println("Length must be greater than 1\nGoodbye!");
			System.exit(0);
		}
		
		System.out.println("Below is a pentagon with 4 side lengths of " + length + " *");
        for (int i = 1; i <= length; i++) // printing the top half of the pentagon, a triangle shape
        {
            for (int j = length; j > i; j--) // Printing the leading spaces
            {
                System.out.print(" ");
            }
            for (int k = 1; k <= (2 * i - 1); k++) // Printing the asterisks
            {
                System.out.print("*");
            }
            System.out.println();
        }
            
    	for (int x = 0; x < length - 1; x++) // printing the bottom half of the pentagon, a rectangle shape
    	{
    		for (int y = 0; y <= (2 * length) - 2; y++)
    		{
    			System.out.print("*");
    		}
    	System.out.println();
    	} 
	} 
}