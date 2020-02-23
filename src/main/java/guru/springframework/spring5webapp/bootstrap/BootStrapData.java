package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author FedorD
 * @date 2020-02-23
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,
                         PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Started in Bootstrap");

        Publisher wrox = new Publisher();
        wrox.setName("Wrox");
        wrox.setCity("Hoboken");
        wrox.setAddressLine1("111 River Street");
        wrox.setState("NJ");
        wrox.setZip("07030-5774");

        publisherRepository.save(wrox);

        System.out.println("Publisher Count: " + publisherRepository.count());

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123-123-123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        ddd.setPublisher(wrox);
        wrox.getBooks().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(wrox);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "234-234-234");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        noEJB.setPublisher(wrox);
        wrox.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(wrox);

        System.out.println("Number of books: " + bookRepository.count());
        System.out.println("Publisher Number of Books: " + wrox.getBooks().size());
    }
}
