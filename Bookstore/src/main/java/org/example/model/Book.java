package org.example.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String isbn;

    private String title;

    @ManyToOne
    private Author author;

   @OneToMany(cascade = CascadeType.ALL)
   @JoinTable(
            name = "Stock",
            joinColumns = @JoinColumn(name = "BookId"),
            inverseJoinColumns = @JoinColumn(name = "StoreId")
   )
    private List<Store> inStockAt;

   private Boolean online;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<Store> getInStockAt() {
        return inStockAt;
    }

    public void setInStockAt(Store store) {
       this.inStockAt.add(store);
    }

    public Boolean isOnline() {
        return online;
    }

    public void setOnline(Boolean online) {
        this.online = online;
    }

    @Override
    public String toString() {
        String sb = "Book{" + "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", author=" + author.getName() +
                ", online=" + online +
                '}';
        return sb;
    }
}
