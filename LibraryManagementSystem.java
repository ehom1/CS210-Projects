// Eric Hom
// Project #4
// Due: December 4, 2024

import java.util.*;

public class LibraryManagementSystem 
{
    private static Map<String, Book> books = new HashMap<>(); // Key: ISBN
    private static Map<String, Member> members = new HashMap<>(); // Key: Member ID
    private static Map<String, Book> booksByTitle = new HashMap<>(); // Key: Title
    private static int memberIdCounter = 1;
    
	public static void main(String[] args)
	{
		int choice;
		Scanner user = new Scanner(System.in);
		
		do
		{
			System.out.print("\nLibrary Management System\n1. Add Book\n2. Add Member\n3. Search Book\n4. Issue Book\n5. Return Book\n6. List Borrowed Books\n7. Exit\nChoose an option: ");
			choice = user.nextInt();
			
			switch (choice)
			{
				case 1: // adding a book to the library
					user.nextLine();
					System.out.print("Enter book title: ");
					String title = user.nextLine();
					System.out.print("Enter book author: ");
					String author = user.nextLine();
					System.out.print("Enter book ISBN: ");
					String isbn = user.nextLine();					
					System.out.print("Enter number of copies: ");
					int copies = user.nextInt();
					addBook(title, author, isbn, copies);
					break;
					
				case 2: // adding a member to the library
					System.out.print("Enter member name: ");
					String memberName = user.next();
					addMember(memberName);
					break;
				
				case 3: // searching for a book in the library 
					int searchOption;
					System.out.print("Search book by: \n1. Title\n2. ISBN\n3. Author\nChoose an option: ");
					searchOption = user.nextInt();
					searchBook(searchOption, user);
					break;
					
				case 4: // issuing a book to a member 
					user.nextLine();
					System.out.print("Enter member ID: ");
					String issueMemberID = user.nextLine();
					System.out.print("Enter book title to borrow: ");
					String issueBookTitle = user.nextLine();
					issueBook(issueMemberID, issueBookTitle);
					break;
				
				case 5: // returning a book 
					user.nextLine();
					System.out.print("Enter member ID: ");
					String returnMemberID = user.nextLine();
					System.out.print("Enter book title to return: ");
					String returnBookTitle = user.nextLine();
					returnBook(returnMemberID, returnBookTitle);
					break;
					
				case 6: // listing the borrowed books from a member
					user.nextLine();
					System.out.print("Enter member ID to list borrowed books: ");
					String listMemberID = user.nextLine();
					listBorrowedBooks(listMemberID);
					break;
				
				case 7: // exiting the loop
					System.out.print("Exiting...");
					System.exit(0);
				
				default: // error case if one of the choices aren't picked 
					System.out.println("Invalid choice, please try again.");
			}
		}
		while (choice != 7);
		
		user.close();
	}
	
	public static void addBook(String title, String author, String isbn, int copies) // method to add a book to the library 
	{
	    // Check if the book already exists by ISBN
	    Book book = books.get(isbn);
	    if (book != null) // if book already exists in the library 
	    {
	        // update existing book's total and available copies
	        book.setTotalCopies(book.getTotalCopies() + copies);
	        book.setAvailableCopies(book.getAvailableCopies() + copies);
	        System.out.println("Book already exists. Updated the number of copies in the library.");
	    } 
	    else // if the book is not already in the library 
	    {
	        book = new Book(title, author, isbn, copies, copies);
	        books.put(isbn, book);
	        booksByTitle.put(title.toLowerCase(), book);  // store in booksByTitle with lowercase title
	        System.out.println("Added new book: " + title + " by " + author + " (ISBN: " + isbn + ")");
	    }
	}
	
	public static void addMember(String memberName) // method to add member into library, saving their name and member ID
	{
        String memberId = "M" + memberIdCounter++;
        Member member = new Member(memberId, memberName);
        members.put(memberId, member);
        System.out.println("Member added: " + memberName + " (Member ID: " + memberId + ")");
	}
	
	public static void searchBook(int searchOption, Scanner user) // method to search for book in different ways 
	{
	    switch (searchOption) 
	    {
	        case 1: // searching for a book by title 
	            user.nextLine(); 
	            System.out.print("Enter the book title: ");
	            String title = user.nextLine();
	            Book bookByTitle = booksByTitle.get(title.toLowerCase());
	            if (bookByTitle != null) // if book is found 
	            {
	                System.out.println("Book found: " + bookByTitle.getTitle() + " by " + bookByTitle.getAuthor() + " (ISBN: " + bookByTitle.getISBN() + ")");
	            } 
	            else // error case if book is not found 
	            {
	                System.out.println("No book found with the title \"" + title + "\".");
	            }
	            break;

	        case 2: // searching for book by ISBN
	            user.nextLine();
	            System.out.print("Enter the book ISBN: ");
	            String isbn = user.nextLine();
	            Book bookByIsbn = books.get(isbn);
	            if (bookByIsbn != null) // if book is found 
	            {
	                System.out.println("Book found: " + bookByIsbn.getTitle() + " by " + bookByIsbn.getAuthor() + " (ISBN: " + bookByIsbn.getISBN() + ")");
	            } 
	            else // if book is not found 
	            {
	                System.out.println("No book found with the ISBN \"" + isbn + "\".");
	            }
	            break;

	        case 3: // searching for book by author 
	            user.nextLine();
	            System.out.print("Enter the author name: ");
	            String author = user.nextLine();
	            List<Book> booksByAuthor = new ArrayList<>();
	            for (Book book : books.values()) 
	            {
	                if (book.getAuthor().equalsIgnoreCase(author)) 
	                {
	                    booksByAuthor.add(book);
	                }
	            }

	            if (!booksByAuthor.isEmpty()) // lists the books from the author 
	            {
	                System.out.println("Books by " + author + ":");
	                for (Book b : booksByAuthor) 
	                {
	                    System.out.println("- " + b.getTitle() + " by " + b.getAuthor() + " (ISBN: " + b.getISBN() + ")");
	                }
	            } 
	            else // error case if the author is not found 
	            {
	                System.out.println("No books found by \"" + author + "\".");
	            }
	            break;

	        default: // error case if one of the options is not picked 
	            System.out.println("Invalid option. Please choose 1, 2, or 3.");
	    }
	}

	
    public static void issueBook(String memberId, String title) // method for letting a member borrow a book
    {
        Member member = members.get(memberId);

        if (member == null) // error case if the member is not found 
        {
            System.out.println("Member not found!");
            return;
        }

        Book book = booksByTitle.get(title.toLowerCase());

        if (book == null) // error case if the book is not found 
        {
            System.out.println("Book not found!");
            return;
        }

        if (member.borrowBook(book)) 
        {
            System.out.println("Book issued: " + title + " to " + member.getName() + " (Member ID: " + memberId + ")");
        } 
        else // error case if no copies available or member already borrowed the book 
        {
            System.out.println("Failed to issue book. Member may have already borrowed it or no copies are available.");
        }
    }
	
    public static void returnBook(String memberId, String title) // method for letting a memebr return a book
    {
        Member member = members.get(memberId);

        if (member == null) // error case if member is not found 
        {
            System.out.println("Member not found!");
            return;
        }

        // Search for the book by title in the secondary map
        Book book = booksByTitle.get(title.toLowerCase());

        if (book == null) // error case if book is not found 
        {
            System.out.println("Book not found!");
            return;
        }

        if (member.returnBook(book)) 
        {
            System.out.println("Book returned: " + title);
        } 
        else // error case if book was never borrowed by the member 
        {
            System.out.println("Failed to return book. The member may not have borrowed this book.");
        }
    }

    public static void listBorrowedBooks(String memberId) // method that lists the books borrowed by a member
    {
        Member member = members.get(memberId);
        if (member == null) 
        {
            System.out.println("Member not found!");
            return;
        }
        member.listBorrowedBooks();
    }
}
