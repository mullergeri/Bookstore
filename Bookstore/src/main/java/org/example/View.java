package org.example;

import org.example.model.Author;

import java.util.Scanner;

public class View {

    Controller controller;

    public void mainMenu(Scanner sc) {

        String input = "xyxy";

        do {
            switch (input) {
                case "iba" -> controller.InitBooksAndAuthors();
                case "is" -> controller.InitStores();
                case "si" -> {
                    System.out.println("Add meg az isbn-t: ");
                    String isbn = sc.nextLine();
                    System.out.println(
                            controller.getBookByIsbn(isbn) == null ?
                                    "nem létezik ilyen könyv az adatbázisban!" :
                                    controller.getBookByIsbn(isbn)
                    );
                    if (controller.getBookByIsbn(isbn) != null) {
                        do {
                            switch (input) {
                                case "ut" -> {
                                    System.out.println("Add meg az új címet: ");
                                    String newTitle = sc.nextLine();
                                    controller.UpdateBookTitle(controller.getBookByIsbn(isbn), newTitle);
                                }
                                case "ui" -> {
                                    System.out.println("Add meg az új ISBN-t: ");
                                    String newIsbn = sc.nextLine();
                                    controller.UpdateBookIsbn(controller.getBookByIsbn(isbn), newIsbn);
                                }
                                case "ab" -> {
                                    System.out.println("Aktiválni(x) vagy Deaktiválni(y) szeretnéd a könyvet?");
                                    String xy = sc.nextLine();
                                    if (xy.equalsIgnoreCase("x")) {
                                        controller.UpdateBookActivity(controller.getBookByIsbn(isbn), true);
                                    } else if (xy.equalsIgnoreCase("y")) {
                                        controller.UpdateBookActivity(controller.getBookByIsbn(isbn), false);
                                    }

                                }

                            }
                            printBookMenu();
                            System.out.println("Te jössz!");
                        } while (!"b".equalsIgnoreCase(input = sc.nextLine()));
                    }
                }

                case "st" -> {
                    System.out.println("Add meg a könyv címét: ");
                    String title = sc.nextLine();
                    System.out.println(
                            controller.getBookByTitle(title) == null ?
                                    "nem létezik ilyen könyv az adatbázisban!" :
                                    controller.getBookByTitle(title)
                    );
                    if (controller.getBookByTitle(title) != null) {
                        do {
                            switch (input) {
                                case "ut" -> {
                                    System.out.println("Add meg az új címet: ");
                                    String newTitle = sc.nextLine();
                                    controller.UpdateBookTitle(controller.getBookByTitle(title), newTitle);
                                }
                                case "ui" -> {
                                    System.out.println("Add meg az új ISBN-t: ");
                                    String newIsbn = sc.nextLine();
                                    controller.UpdateBookIsbn(controller.getBookByTitle(title), newIsbn);
                                }
                                case "ab" -> {
                                    System.out.println("Aktiválni(x) vagy Deaktiválni(y) szeretnéd a könyvet?");
                                    String xy = sc.nextLine();
                                    if (xy.equalsIgnoreCase("x")) {
                                        controller.UpdateBookActivity(controller.getBookByTitle(title), true);
                                    } else if (xy.equalsIgnoreCase("y")) {
                                        controller.UpdateBookActivity(controller.getBookByTitle(title), false);
                                    }

                                }

                            }
                            printBookMenu();
                            System.out.println("Te jössz!");
                        } while (!"b".equalsIgnoreCase(input = sc.nextLine()));
                    }
                }
                case "sa" -> {
                    System.out.println("Add meg az író nevét: ");
                    String name = sc.nextLine();
                    Author author = controller.getAuthorByName(name);
                    System.out.println(controller.getBookByAuthor(author));
                    if (controller.getBookByAuthor(author) != null)
                        do {
                            switch (input) {
                                case "ut" -> {
                                    System.out.println("Add meg az új címet: ");
                                    String newTitle = sc.nextLine();
                                    controller.UpdateBookTitle(controller.getBookByAuthor(controller.getAuthorByName(name)), newTitle);
                                }
                                case "ui" -> {
                                    System.out.println("Add meg az új ISBN-t: ");
                                    String newIsbn = sc.nextLine();
                                    controller.UpdateBookIsbn(controller.getBookByAuthor(controller.getAuthorByName(name)), newIsbn);
                                }
                                case "ab" -> {
                                    System.out.println("Aktiválni(x) vagy Deaktiválni(y) szeretnéd a könyvet?");
                                    String xy = sc.nextLine();
                                    if (xy.equalsIgnoreCase("x")) {
                                        controller.UpdateBookActivity(controller.getBookByAuthor(controller.getAuthorByName(name)), true);
                                    } else if (xy.equalsIgnoreCase("y")) {
                                        controller.UpdateBookActivity(controller.getBookByAuthor(controller.getAuthorByName(name)), false);
                                    }

                                }

                            }
                            printBookMenu();
                            System.out.println("Te jössz!");
                        } while (!"b".equalsIgnoreCase(input = sc.nextLine()));

                }
                case "san" -> {
                    System.out.println("Add meg a nevét: ");
                    String name = sc.nextLine();
                    System.out.println(controller.getAuthorByName(name));
                    if (controller.getAuthorByName(name) != null) {
                        do{
                            switch(input) {
                                case "uan" -> {
                                    System.out.println("Add meg az új nevet: ");
                                    String newName = sc.nextLine();
                                    controller.UpdateAuthorName(controller.getAuthorByName(name), newName);
                                }
                                case "da" -> controller.DeleteAuthor(controller.getAuthorByName(name));

                            }
                            printAuthorMenu();
                            System.out.println("Te jössz!");

                        } while(!"b".equalsIgnoreCase(input = sc.nextLine()));
                    }

                }
                case "ab" -> {
                    System.out.println("Add meg a könyv címét:");
                    String title = sc.nextLine();
                    System.out.println("Add meg az ISBN-t:");
                    String isbn = sc.nextLine();
                    System.out.println("Add meg a szerző nevét:");
                    String name = sc.nextLine();
                    controller.AddBook(title, isbn, name);
                }
                case "aa" -> {
                    System.out.println("Add meg a szerző nevét:");
                    String name = sc.nextLine();
                    controller.addAuthor(name);
                }
                case "ast" -> {
                    System.out.println("Add meg a bolt nevét:");
                    String storeName = sc.nextLine();
                    System.out.println("Add meg a Könyv címét:");
                    String bookTitle = sc.nextLine();
                    System.out.println("Add meg a mennyiséget:");
                    int quantity = Integer.parseInt(sc.nextLine());
                    controller.AddStock(
                            controller.getBookByTitle(bookTitle),
                            controller.getStoreByName(storeName),
                            quantity
                    );
                }
                case "as" -> {
                    System.out.println("Add meg a bolt nevét: ");
                    String name = sc.nextLine();
                    controller.addStore(name);
                }
                case "x" -> controller.getBookandStoreWithLeastBooks();

                default -> {
                    if (!input.equalsIgnoreCase("xyxy")) {
                        System.out.println("Nem tudom mit akarsz, szedd össze magad!");
                    }
                }
            }

            printMenu();
            System.out.println();
            System.out.println("Te jössz!");

        } while (!"q".equalsIgnoreCase(input = sc.nextLine()));

    }

    public void printStoresLackingBooks() {
        controller.getStoresWithLackingBooks();
    }

    public void printBookMenu() {
        System.out.println("=".repeat(30));
        System.out.println("\t\tBook menu");
        System.out.println("=".repeat(30));
        System.out.println("Update book title - ut");
        System.out.println("Update book ISBN - ui");
        System.out.println("Activate/Deactivate book - ab");
        System.out.println("Back - b");
        System.out.println("=".repeat(30));
    }

    public void printAuthorMenu() {
        System.out.println("=".repeat(30));
        System.out.println("\t\tAuthor Menu");
        System.out.println("=".repeat(30));
        System.out.println("Update Author name - uan");
        System.out.println("Delete Author - da");
        System.out.println("Back - b");
        System.out.println("=".repeat(30));
    }


    public void printMenu() {
        System.out.println("=".repeat(30));
        System.out.println("\t\tBookstore");
        System.out.println("=".repeat(30));
        //System.out.println("Initialize Books and Authors - iba");
        //System.out.println("Initialize Stores - is");
        System.out.println("Add Store - as");
        System.out.println("Add new Author - aa");
        System.out.println("Add new book - ab");
        System.out.println("Add Stock - ast");
        System.out.println("Search book(by isbn) si");
        System.out.println("Search book(by title) - st");
        System.out.println("Search book(by Author) - sa");
        System.out.println("Search Author(by name) - san");
        System.out.println("Print Book-Store pairs with less than 5 books - x");
        //printStoresLackingBooks();
        System.out.println("\tQuit - q");
        System.out.println("=".repeat(30));
    }

}
