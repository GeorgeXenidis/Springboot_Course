package me.springframework.spring5webapp.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

//Clarifies how this P.O.J.O. will be treaded by J.P.A.
@Entity
public class Book
{

    //The id for the J.P.A. entity's table
    @Id
    //Declares that the id will be auto-generated
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String bookTitle;
    private String isbn;

    //Relation between this attribute and the annotated one
    @ManyToMany
    //Join Table procedure, creates a table with foreign key crafted by "Author" and "Book" tables.
    @JoinTable(name = "book_author", joinColumns = @JoinColumn(name = "book_id"),
    inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> itsAuthors = new HashSet<>();

    //Relation between Publisher and Book
    @ManyToOne
    private Publisher itsPublisher;

    //J.P.A. architecture requires an empty constructor for the call of the entity.
    public Book() {}

    public Book(String bookTitle, String isbn) {
        this.bookTitle = bookTitle;
        this.isbn = isbn;
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

    public Publisher getItsPublisher() {
        return itsPublisher;
    }

    public void setItsPublisher(Publisher itsPublisher) {
        this.itsPublisher = itsPublisher;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookTitle='" + bookTitle + '\'' +
                ", isbn='" + isbn + '\'' +
                ", itsAuthors=" + itsAuthors +
                ", itsPublisher=" + itsPublisher +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
