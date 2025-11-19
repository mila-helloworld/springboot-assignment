package com.example.library;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    @Override
    public void run(String... args) throws Exception {
        if (authorRepository.count() > 0 || bookRepository.count() > 0) {
            return; // already loaded
        }

        Author a1 = new Author("Charles Dickens", "charles.dickens@example.com", "UK");
        Author a2 = new Author("Jane Austen", "jane.austen@example.com", "UK");
        Author a3 = new Author("Mark Twain", "mark.twain@example.com", "USA");
        Author a4 = new Author("George Orwell", "george.orwell@example.com", "UK");
        Author a5 = new Author("J.K. Rowling", "jk.rowling@example.com", "UK");
        Author a6 = new Author("Agatha Christie", "agatha.christie@example.com", "UK");
        Author a7 = new Author("Leo Tolstoy", "leo.tolstoy@example.com", "Russia");
        Author a8 = new Author("Ernest Hemingway", "ernest.hemingway@example.com", "USA");
        Author a9 = new Author("F. Scott Fitzgerald", "f.scott@example.com", "USA");
        Author a10 = new Author("Haruki Murakami", "haruki.murakami@example.com", "Japan");

        a1 = authorRepository.save(a1);
        a2 = authorRepository.save(a2);
        a3 = authorRepository.save(a3);
        a4 = authorRepository.save(a4);
        a5 = authorRepository.save(a5);
        a6 = authorRepository.save(a6);
        a7 = authorRepository.save(a7);
        a8 = authorRepository.save(a8);
        a9 = authorRepository.save(a9);
        a10 = authorRepository.save(a10);

        bookRepository.save(new Book("Great Expectations", "ISBN-1001", 10.99, 1861, a1));
        bookRepository.save(new Book("Pride and Prejudice", "ISBN-1002", 12.50, 1813, a2));
        bookRepository.save(new Book("Adventures of Huckleberry Finn", "ISBN-1003", 9.99, 1884, a3));
        bookRepository.save(new Book("1984", "ISBN-1004", 11.25, 1949, a4));
        bookRepository.save(new Book("Animal Farm", "ISBN-1005", 8.99, 1945, a4));
        bookRepository.save(new Book("Harry Potter and the Philosopher's Stone", "ISBN-1006", 14.99, 1997, a5));
        bookRepository.save(new Book("Murder on the Orient Express", "ISBN-1007", 9.50, 1934, a6));
        bookRepository.save(new Book("War and Peace", "ISBN-1008", 15.99, 1869, a7));
        bookRepository.save(new Book("The Old Man and the Sea", "ISBN-1009", 7.99, 1952, a8));
        bookRepository.save(new Book("Norwegian Wood", "ISBN-1010", 13.99, 1987, a10));

        System.out.println("Sample data inserted: 10 authors, 10 books.");
    }
}

