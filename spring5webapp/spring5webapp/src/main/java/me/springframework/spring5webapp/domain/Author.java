package me.springframework.spring5webapp.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

//Clarifies how this P.O.J.O. will be treaded by J.P.A.
@Entity
public class Author
{

    //The id for the J.P.A. entity's table
    @Id
    //Declares that the id will be auto-generated
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String fName;
    private String lName;

    //Relation between this attribute and the annotated one
    @ManyToMany(mappedBy = "itsAuthors")
    private Set<Book> booksWritten = new HashSet<>();

    //J.P.A. architecture requires an empty constructor for the call of the entity.
    public Author() {}

    public Author(String fName, String lName)
    {
        this.fName = fName;
        this.lName = lName;
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

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", booksWritten=" + booksWritten +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(id, author.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
