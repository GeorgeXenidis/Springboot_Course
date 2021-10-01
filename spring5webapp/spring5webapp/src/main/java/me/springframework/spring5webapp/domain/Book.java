package me.springframework.spring5webapp.domain;

import javax.persistence.*;
import java.util.Set;

//Clarifies how this P.O.J.O. will be treaded by J.P.A.
@Entity
public class Book
{

    //The id for the entity's table
    @Id
    //Declares that the id will be auto generated
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String bookTitle;
    private String isbn;

    //Relation between this attribute and the annotated one
    @ManyToMany
    //Join Table procedure, creates a table with foreign key crafted by "Author" and "Book" tables.
    @JoinTable(name = "author_book", joinColumns = @JoinColumn(name = "book_id"),
    inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> itsAuthors;

    //J.P.A. architecture requires an empty constructor for the call of the entity.
    public Book() {}

    public Book(String bookTitle, String isbn, Set<Author> itsAuthors) {
        this.bookTitle = bookTitle;
        this.isbn = isbn;
        this.itsAuthors = itsAuthors;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Set<Author> getItsAuthors() {
        return itsAuthors;
    }

    public void setItsAuthors(Set<Author> itsAuthors) {
        this.itsAuthors = itsAuthors;
    }
}
