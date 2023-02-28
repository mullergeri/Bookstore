package org.example;



import org.example.model.*;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


import java.util.List;

public class Controller implements AutoCloseable {

    private HibernateContext model = new HibernateContext();


    @Override
    public void close() throws Exception {
        model.close();
    }

    public void InitBooksAndAuthors() {

        Session session = model.getSession();
        Transaction tx = session.beginTransaction();

        try {


            Book b1 = new Book();
            b1.setIsbn("123475BN");
            b1.setTitle("Tudja hol szeret a cápa");
            b1.setOnline(true);
            session.persist(b1);

            Book b2 = new Book();
            b2.setIsbn("124615ZK");
            b2.setTitle("Haránt fekvésbe volt bennem a Csenge");
            b2.setOnline(true);
            session.persist(b2);

            Book b3 = new Book();
            b3.setIsbn("823615LP");
            b3.setTitle("Pancser kis köcsögök");
            b3.setOnline(true);
            session.persist(b3);

            Book b4 = new Book();
            b4.setIsbn("729852XY");
            b4.setTitle("Három liter sör (tüskével)");
            b4.setOnline(true);
            session.persist(b4);

            Book b5 = new Book();
            b5.setIsbn("339138ZT");
            b5.setTitle("Ózdi vagy, Sinter vagy");
            b5.setOnline(true);
            session.persist(b5);

            Book b6 = new Book();
            b6.setIsbn("285578SS");
            b6.setTitle("Megöletel, pitbull kutyákkal megetetel");
            b6.setOnline(true);
            session.persist(b6);


            Author a1 = new Author();
            a1.setName("Kalányos Szupermen");
            a1.setBook(b1);
            session.persist(a1);

            Author a2 = new Author();
            a2.setName("Szintiboy(alias Zagyva Tíbor)");
            a2.setBook(b2);
            session.persist(a2);

            Author a3 = new Author();
            a3.setName("Harántfekvő Csenge");
            a3.setBook(b3);
            session.persist(a3);

            Author a4 = new Author();
            a4.setName("Füty Imre");
            a4.setBook(b4);
            session.persist(a4);

            Author a5 = new Author();
            a5.setName("Sinter Zoli");
            a5.setBook(b5);
            session.persist(a5);

            Author a6 = new Author();
            a6.setName("Anonymus");
            a6.setBook(b6);
            session.persist(a6);

            b1.setAuthor(a1);
            b2.setAuthor(a2);
            b3.setAuthor(a3);
            b4.setAuthor(a4);
            b5.setAuthor(a5);
            b6.setAuthor(a6);


            tx.commit();

        } catch (Exception e) {
            System.out.println(e);
            tx.rollback();

        }
    }

    public void AddBook(String title, String isbn, String name) {

        Author a;
        if (getAuthorByName(name) == null) {
            addAuthor(name);
        }
        a = getAuthorByName(name);


        Book book = new Book();

        book.setTitle(title);
        book.setIsbn(isbn);
        book.setAuthor(a);
        book.setOnline(true);


        Session s = model.getSession();
        Transaction tx = s.beginTransaction();


        s.persist(book);


        s.flush();

        tx.commit();

        System.out.println("Book added, Id: " + book.getId());


    }

    public void addAuthor(String name) {

        Author a = new Author();

        a.setName(name);


        Session session = model.getSession();
        Transaction tx = session.beginTransaction();

        session.persist(a);

        tx.commit();


    }

    Author getAuthorByName(String name) {

        Session session = model.getSession();
        Transaction tx = session.beginTransaction();

        String hql = "FROM Author where name = :name";
        Query q = session.createQuery(hql).setParameter("name", name);

        Author a = null;
        try {
            a = (Author) q.getSingleResult();
        } catch (Exception ignored) {

        }
        session.clear();

        tx.commit();

        return a;
    }


    public void InitStores() {

        Session session = model.getSession();
        Transaction tr = session.beginTransaction();

        try {

            Store s1 = new Store();
            s1.setName("Konyvesbolt");
            session.persist(s1);

            Store s2 = new Store();
            s2.setName("Konyvarulas");
            session.persist(s2);

            Store s3 = new Store();
            s3.setName("Konyvvasar");
            session.persist(s3);

            Store s4 = new Store();
            s4.setName("Konyvaruhaz");
            session.persist(s4);

            Store s5 = new Store();
            s5.setName("Konyvpiac");
            session.persist(s5);

            tr.commit();

        } catch (Exception e) {
            System.out.println(e);
            tr.rollback();
        }
    }

    public Book getBookByIsbn(String isbn) {


        Session session = model.getSession();
        Transaction tx = session.beginTransaction();

        String hql = "From Book where isbn = :isbn";
        Query q = session.createQuery(hql).setParameter("isbn", isbn);

        Book result = null;
        try {
            result = (Book) q.getSingleResult();
        } catch (Exception ignored) {
        }
        tx.commit();
        return result;

    }

    public Book getBookByTitle(String title) {

        Session session = model.getSession();
        Transaction tx = session.beginTransaction();
        String hql = "FROM Book where title = :title";
        Query q = session.createQuery(hql).setParameter("title", title);

        Book result = null;
        try {
            result = (Book) q.getSingleResult();
        } catch (Exception ignored) {
        }
        tx.commit();

        return result;
    }

    public Book getBookByAuthor(Author author) {


        Session session = model.getSession();
        Transaction tx = session.beginTransaction();

        String hql = "FROM Book WHERE author = :author";
        Query q = session.createQuery(hql).setParameter("author", author);

        Book result = null;
        try {
            result = (Book) q.getSingleResult();
        } catch (Exception ignored) {
        }

        session.clear();

        tx.commit();

        return result;
    }

    public void getStoresWithLackingBooks() {


    }

    public void UpdateBookTitle(Book b, String newTitle) {

        Session session = model.getSession();
        Transaction tx = session.beginTransaction();

        b.setTitle(newTitle);
        session.update(b);

        tx.commit();

    }

    public void UpdateBookIsbn(Book b, String newIsbn) {

        Session session = model.getSession();
        Transaction tx = session.beginTransaction();

        b.setIsbn(newIsbn);
        session.update(b);

        tx.commit();

    }

    public void UpdateBookActivity(Book b, Boolean Online) {

        Session session = model.getSession();
        Transaction tx = session.beginTransaction();

        b.setOnline(Online);
        session.update(b);

        tx.commit();

    }

    public void UpdateAuthorName(Author a, String newName) {

        Session session = model.getSession();
        Transaction tx = session.beginTransaction();

        a.setName(newName);
        session.update(a);

        tx.commit();


    }

    public void DeleteAuthor(Author author) {

        Session session = model.getSession();
        Transaction tx = session.beginTransaction();

        session.remove(author);

        tx.commit();

    }

    public void AddStock(Book book, Store store, Integer quantity) {


        Stock stock = new Stock();
        stock.getStockid().setBookId(book.getId());
        stock.getStockid().setStoreId(store.getId());
        stock.setQuantity(quantity);


        Session session = model.getSession();
        Transaction tx = session.beginTransaction();

        session.persist(stock);

        tx.commit();

    }

    public Store getStoreByName(String storeName) {


        Session session = model.getSession();
        Transaction tx = session.beginTransaction();

        String hql = "From Store where name = :name";
        Query q = session.createQuery(hql).setParameter("name", storeName);

        Store result = null;
        try {
            result = (Store) q.getSingleResult();
        } catch (Exception ignored) {
        }
        session.clear();

        tx.commit();

        return result;
    }

    public void addStore(String name) {

        Store store = new Store();
        store.setName(name);

        Session session = model.getSession();
        Transaction tx = session.beginTransaction();

        session.persist(store);

        tx.commit();


    }

    public void getBookandStoreWithLeastBooks() {

    }
}
