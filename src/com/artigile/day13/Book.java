package com.artigile.day13;

/**
 * Created by ibahdanau on 5/8/17.
 */
abstract class Book {
    String title;
    String author;

    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    abstract void display();
}

class MyBook extends Book {

    private final int price;

    /**
     * Class Constructor
     *
     * @param title The book's title.
     * @param author The book's author.
     * @param price The book's price.
     **/
    public MyBook(final String title, final String author, final int price) {
        super(title, author);
        this.price = price;
    }

    /**
     * Method Name: display
     * <p>
     * Print the title, author, and price in the specified format.
     **/

    @Override
    void display() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
    }
}
