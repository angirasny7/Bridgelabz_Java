
package Inheritance;

// Superclass
class Book {
    String title;
    int publicationYear;

    Book(String title, int publicationYear) {
        this.title = title;
        this.publicationYear = publicationYear;
    }

    void displayInfo() {
        System.out.println("Book Title: " + title);
        System.out.println("Publication Year: " + publicationYear);
    }
}

// Subclass
class Author extends Book {
    String name;
    String bio;

    Author(String title, int publicationYear, String name, String bio) {
        super(title, publicationYear);
        this.name = name;
        this.bio = bio;
    }

    @Override
    void displayInfo() {
        System.out.println("--- Book and Author Details ---");
        super.displayInfo();
        System.out.println("Author Name: " + name);
        System.out.println("Author Bio: " + bio);
    }
}

// Main class
public class LibraryManagement {
    public static void main(String[] args) {
        Author author = new Author(
                "Wings of Fire",
                1999,
                "A. P. J. Abdul Kalam",
                "Scientist and former President of India."
        );

        author.displayInfo();
    }
}
