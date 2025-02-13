// Eric Hom
// Project #4
// Due: December 4, 2024

public class Book 
{
	private String title;
	private String author;
	private String isbn;
	private int totalCopies;
	private int availableCopies;
	
	public Book(String title, String author, String isbn, int totalCopies, int availableCopies)
	{
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.totalCopies = totalCopies;
		this.availableCopies = availableCopies;
	}
	
	public void setTitle(String title) // set method for the book title 
	{
		this.title = title;
	}
	
	public String getTitle() // get method for the book title 
	{
		return title;
	}
	
	public void setAuthor(String author) // set method for the author of book
	{
		this.author = author;
	}
	
	public String getAuthor() // get method for author of book 
	{
		return author;
	}
	
	public void setISBN(String isbn) // set method for book isbn
	{
		this.isbn = isbn;
	}
	
	public String getISBN() // get method for book isbn 
	{
		return isbn;
	}
	
	public void setTotalCopies(int totalCopies) // set method for total copies of the book 
	{
		this.totalCopies = totalCopies;
	}
	
	public int getTotalCopies() // get method for total copies of the book 
	{
		return totalCopies;
	}
	
	public void setAvailableCopies(int availableCopies) // set method for available copies of the book 
	{
		this.availableCopies = availableCopies;
	}
	
	public int getAvailableCopies() // get method for available copies of the book 
	{
		return availableCopies;
	}
	
	public boolean borrowBook() // method for borrowing a book
	{
		if (availableCopies > 0)
		{
			availableCopies--;
			return true;
		}
		return false;
	}
	
	public void returnBook() // method for returning a book
	{
		if (availableCopies < totalCopies)
		{
			availableCopies++;
		}
	}
}
