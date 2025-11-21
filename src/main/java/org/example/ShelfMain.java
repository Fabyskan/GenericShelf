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

        // Act
        printShelf(bookShelf);
        printShelf(toolShelf);
    }

    public static void printShelf(Shelf<?> shelf) {
        for (Shelfitem item : shelf) {
            System.out.println(item);
        }
    }
}