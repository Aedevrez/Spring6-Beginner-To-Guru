package aedev.guru.Spring6WebApp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import aedev.guru.Spring6WebApp.domain.Author;
import aedev.guru.Spring6WebApp.domain.Book;
import aedev.guru.Spring6WebApp.domain.Publisher;
import aedev.guru.Spring6WebApp.repositories.AuthorRepository;
import aedev.guru.Spring6WebApp.repositories.BookRepository;
import aedev.guru.Spring6WebApp.repositories.PublisherRepository;

@Component
public class BootstrapData implements CommandLineRunner{

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author brandoSando = new Author();
        brandoSando.setFirstName("Brandon");
        brandoSando.setLastName("Sanderson");

        Book islesOfEmberdark = new Book();
        islesOfEmberdark.setName("Isles Of the Emberdark");
        islesOfEmberdark.setIsbn("125041539X");

        Publisher tor = new Publisher();
        tor.setPublisherName("Tor");
        tor.setAddress("blablabla");
        tor.setCity("Ohio?");
        tor.setState("Ohio???");
        tor.setZip("12312312131");

        Author brandoSaved = authorRepository.save(brandoSando);
        Book islesSaved = bookRepository.save(islesOfEmberdark);
        Publisher torSaved = publisherRepository.save(tor);

        brandoSaved.getBooks().add(islesSaved);
        islesSaved.getAuthors().add(brandoSaved);
        islesSaved.setPublisher(torSaved);

        authorRepository.save(brandoSaved);
        bookRepository.save(islesSaved);

        System.out.println("In Bootstrap");
        System.out.println("Author count: " + authorRepository.count());
        System.out.println("Book count: " + bookRepository.count());
        System.out.println("Publisher count: " + publisherRepository.count());
    }
    
}
