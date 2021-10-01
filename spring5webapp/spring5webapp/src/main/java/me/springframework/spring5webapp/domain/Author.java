package me.springframework.spring5webapp.domain;

import javax.persistence.*;
import java.util.Set;

//Clarifies how this P.O.J.O. will be treaded by J.P.A.
@Entity
public class Author
{

    //The id for the entity's table
    @Id
    //Declares that the id will be auto generated
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String fName;
    private String lName;

    //Relation between this attribute and the annotated one
    @ManyToMany(mappedBy = "authors")
    private Set<Book> booksWritten;

    //J.P.A. architecture requires an empty constructor for the call of the entity.
    public Author() {}

    public Author(String fName, String lName, Set<Book> booksWritten)
    {
        this.fName = fName;
        this.lName = lName;
        this.booksWritten = booksWritten;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public Set<Book> getBooksWritten() {
        return booksWritten;
    }

    public void setBooksWritten(Set<Book> booksWritten) {
        this.booksWritten = booksWritten;
    }
}
