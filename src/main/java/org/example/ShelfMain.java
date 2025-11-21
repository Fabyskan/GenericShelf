package org.example;


public class ShelfMain {
    public static void main(String[] args) {
        // Arrange
        Shelf<Book> bookShelf = new Shelf<>(
                new Book("Java ist auch eine Insel", "Ullenboom", 1246),
                new Book("Schuld", "Schirach", 208),
                null,
                new Book("Bibi und Tina", "Börnstadt", 34)
        );

        Shelf<Tool> toolShelf = new Shelf<>(
                new Tool("Schraubenzieher"),
                null,
                null,
                new Tool("Säge")
        );

        Shelf<Book> newBookShelf = new Shelf<>();
        Shelf<ShelfItem> generalShelf = new Shelf<>();
        // Act
        printShelf(bookShelf);
        printShelf(toolShelf);
        newBookShelf.takeFrom(bookShelf);
        printShelf(bookShelf);
        printShelf(newBookShelf);
        generalShelf.takeFrom(newBookShelf);
        printShelf(newBookShelf);
        printShelf(generalShelf);
    }

    public static void printShelf(Shelf<?> shelf) {
        for (ShelfItem item : shelf) {
            System.out.println(item);
        }
    }
}