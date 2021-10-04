package me.springframework.spring5webapp.bootstrap;

import me.springframework.spring5webapp.domain.Author;
import me.springframework.spring5webapp.domain.Book;
import me.springframework.spring5webapp.domain.Publisher;
import me.springframework.spring5webapp.repositories.AuthorRepo;
import me.springframework.spring5webapp.repositories.BookRepo;
import me.springframework.spring5webapp.repositories.PublisherRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//When code starts, the below Class which is referred as @Component will be the first to be executed (after main).
@Component
public class BootstrapData implements CommandLineRunner
{

    private final AuthorRepo authorRepoObj;
    private final BookRepo bookRepoObj;
    private final PublisherRepo publisherRepoObj;

    public BootstrapData(AuthorRepo authorRepoObj, BookRepo bookRepoObj, PublisherRepo publisherRepoObj) {
        this.authorRepoObj = authorRepoObj;
        this.bookRepoObj = bookRepoObj;
        this.publisherRepoObj = publisherRepoObj;
    }

    @Override
    public void run(String... args) throws Exception
    {
        //Create a few basic elements to test the code.
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123");
        Publisher goodReads = new Publisher("Good Reads", "Address Line 1", "Chicago mayby", "America", "85400");

        //Update the lists/fields of each entity and the CRUD repositories.
        eric.getBooksWritten().add(ddd);
        authorRepoObj.save(eric);
        ddd.getItsAuthors().add(eric);
        bookRepoObj.save(ddd);
        ddd.setItsPublisher(goodReads);
        publisherRepoObj.save(goodReads);

        //Same as above.
        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "1234534567");
        //We assume here that the publisher is the same as before...

        //Update the lists/fields of each entity and the CRUD repositories.
        rod.getBooksWritten().add(noEJB);
        authorRepoObj.save(rod);
        noEJB.getItsAuthors().add(rod);
        bookRepoObj.save(noEJB);
        noEJB.setItsPublisher(goodReads);
        bookRepoObj.save(noEJB);
        publisherRepoObj.save(goodReads);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of stored books: " + bookRepoObj.count());
        System.out.println("Number of stored authors: " + authorRepoObj.count());
        System.out.println("Number of publishers in the area: " + publisherRepoObj.count());

        System.out.println("Paused for a while...");
    }
}
