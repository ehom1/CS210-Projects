// Eric Hom
// Project #4
// Due: December 4, 2024

import java.util.List;
import java.util.ArrayList;

public class Member 
{
	private String memberId;
	private String name;
	private List<Book> borrowedBooks;
	
	public Member(String memberId, String name)
	{
		this.memberId = memberId;
		this.name = name;
		this.borrowedBooks = new ArrayList<>();
	}
	
	public void setMemberId(String memberId) // setter method for member id
	{
		this.memberId = memberId;
	}
	
	public String getMemberId() // getter method for member id
	{
		return memberId;
	}
	
	public void setName(String name) // setter method for member name 
	{
		this.name = name;
	}
	
	public String getName() // getter method for member name 
	{
		return name;
	}
	
	public void setBorrowedBooks(List<Book> borrowedBooks) // setter method for borrowedBooks
	{
		this.borrowedBooks = borrowedBooks;
	}
	
	public List<Book> getBorrowedBooks() // getter method for borrowedBooks
	{
		return borrowedBooks;
	}
	
	public boolean borrowBook(Book book) // method for member borrowing book
	{
        // checks if the member has already borrowed the book
        if (borrowedBooks.contains(book)) 
        {
            System.out.println("You have already borrowed this book: " + book.getTitle());
            return false;
        }

        // checks if the book is available for borrowing
        if (book.borrowBook()) 
        {
            borrowedBooks.add(book);
            return true;
        } 
        else 
        {
            System.out.println("No copies available for the book: " + book.getTitle());
            return false;
        }
	}
	
    public boolean returnBook(Book book)  // method for member returning book 
    {
        // checks if the member has borrowed the book
        if (!borrowedBooks.contains(book)) 
        {
            System.out.println("You cannot return a book you haven't borrowed: " + book.getTitle());
            return false;
        }

        // removes the book from the member's borrowed list
        book.returnBook();
        borrowedBooks.remove(book);
        return true;
    }

    public void listBorrowedBooks() // method for listing the books that the member borrowed
    {
        if (borrowedBooks.isEmpty()) 
        {
            System.out.println("No books currently borrowed.");
        } 
        else {
        	
            System.out.println(name + "'s borrowed books: ");
            for (Book book : borrowedBooks) 
            {
                System.out.println(" - " + book.getTitle() + " by " + book.getAuthor());
            }
        }
    }
}