package org.example;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

public class TestShelf {

    // CONSTRUCTOR TESTS

    @Test
    public void constructor_withoutParamters_setsAllFieldsToNull() {
        //arrange
        Shelf<ShelfItem> shelf = new Shelf<>();
        //act
        //assert
        assertAll(
                () -> assertNull(shelf.getUpperLeft()),
                () -> assertNull(shelf.getUpperRight()),
                () -> assertNull(shelf.getLowerLeft()),
                () -> assertNull(shelf.getLowerRight())
        );
    }

    @Test
    public void constructor_setsAllFields() {
        //arrange
        Book ur = new Book("Book1", "Author1", 100);
        Tool ul = new Tool("Hammer");
        Book lr = new Book("Book2", "Author2", 200);
        Tool ll = new Tool("Screwdriver");
        Shelf<ShelfItem> shelf = new Shelf<>(ul, ur, ll, lr);
        //act
        //assert
        assertAll(
                () -> assertEquals(ul, shelf.getUpperLeft()),
                () -> assertEquals(ur, shelf.getUpperRight()),
                () -> assertEquals(ll, shelf.getLowerLeft()),
                () -> assertEquals(lr, shelf.getLowerRight())
        );
    }

    // SETTER AND GETTER TESTS

    @Test
    public void setters_andGetters_workAsExpected() {
        //arrange
        Shelf<ShelfItem> shelf = new Shelf<>();
        Book ur = new Book("Book1", "Author1", 100);
        Tool ul = new Tool("Hammer");
        Book lr = new Book("Book2", "Author2", 200);
        Tool ll = new Tool("Screwdriver");
        //act
        shelf.setUpperLeft(ul);
        shelf.setUpperRight(ur);
        shelf.setLowerLeft(ll);
        shelf.setLowerRight(lr);
        //assert
        assertAll(
                () -> assertEquals(ul, shelf.getUpperLeft()),
                () -> assertEquals(ur, shelf.getUpperRight()),
                () -> assertEquals(ll, shelf.getLowerLeft()),
                () -> assertEquals(lr, shelf.getLowerRight())
        );
    }

    // SET INDEX TESTS

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    public void set_setsCorrectField(int index) {
        //arrange
        Shelf<ShelfItem> shelf = new Shelf<>();
        ShelfItem item = switch (index) {
            case 0 -> new Tool("Hammer");
            case 1 -> new Book("Book1", "Author1", 100);
            case 2 -> new Tool("Screwdriver");
            case 3 -> new Book("Book2", "Author2", 200);
            default -> null;
        };
        //act
        shelf.set(index, item);
        //assert
        assertEquals(item, shelf.get(index));
    }

    // GET INDEX TESTS

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    public void get_returnsCorrectField(int index) {
        //arrange
        Shelf<ShelfItem> shelf = new Shelf<>();
        ShelfItem item = switch (index) {
            case 0 -> new Tool("Hammer");
            case 1 -> new Book("Book1", "Author1", 100);
            case 2 -> new Tool("Screwdriver");
            case 3 -> new Book("Book2", "Author2", 200);
            default -> null;
        };
        shelf.set(index, item);
        //act
        //assert
        assertEquals(item, shelf.get(index));
    }

    // ITERATOR TESTS

    @Test
    public void iterator_returnsItemsInCorrectOrder() {
        //arrange
        Shelf<ShelfItem> shelf = new Shelf<>();
        Tool ul = new Tool("Hammer");
        Book ur = new Book("Book1", "Author1", 100);
        Tool ll = new Tool("Screwdriver");
        Book lr = new Book("Book2", "Author2", 200);
        shelf.setUpperLeft(ul);
        shelf.setUpperRight(ur);
        shelf.setLowerLeft(ll);
        shelf.setLowerRight(lr);
        //act
        var iterator = shelf.iterator();
        //assert
        assertAll(
                () -> assertTrue(iterator.hasNext()),
                () -> assertEquals(ul, iterator.next()),
                () -> assertTrue(iterator.hasNext()),
                () -> assertEquals(ur, iterator.next()),
                () -> assertTrue(iterator.hasNext()),
                () -> assertEquals(ll, iterator.next()),
                () -> assertTrue(iterator.hasNext()),
                () -> assertEquals(lr, iterator.next()),
                () -> assertFalse(iterator.hasNext()),
                () -> assertThrows(java.util.NoSuchElementException.class, () -> iterator.next())
        );
    }

    // TEST TAKEFROM
    @Test
    public void takeFrom_placesCorrectItem() {
        //arrange
        Shelf<ShelfItem> shelf1 = new Shelf<>();
        Tool ul = new Tool("Hammer");
        Book ur = new Book("Book1", "Author1", 100);
        Tool ll = new Tool("Screwdriver");
        Book lr = new Book("Book2", "Author2", 200);
        shelf1.setUpperLeft(ul);
        shelf1.setUpperRight(ur);
        shelf1.setLowerLeft(ll);
        shelf1.setLowerRight(lr);
        Shelf<ShelfItem> shelf2 = new Shelf<>();
        Tool ul2 = null;
        Book ur2 = null;
        Book ll2 = new Book("Book3", "Author3", 300);
        Tool lr2 = new Tool("Säge");
        shelf2.setUpperLeft(ul);
        shelf2.setUpperRight(ur);
        shelf2.setLowerLeft(ll);
        shelf2.setLowerRight(lr);
        //act
        shelf2.takeFrom(shelf1);
        //assert
        assertAll(
                () -> assertEquals(ul, shelf2.getUpperLeft()),
                () -> assertEquals(ur, shelf2.getUpperRight()),
                () -> assertEquals(ll, shelf2.getLowerLeft()),
                () -> assertEquals(lr, shelf2.getLowerRight()),
                () -> assertNull(shelf1.getUpperLeft()),
                () -> assertNull(shelf1.getUpperRight()),
                () -> assertNull(shelf1.getLowerLeft()),
                () -> assertNull(shelf1.getLowerRight())
        );
    }

    // TEST MAX
    @Test
    public void max_returnsCorrectItem() {
        //arrange
        Shelf<ShelfItem> shelf = new Shelf<>();
        Tool ul = new Tool("Hammer");
        Book ur = new Book("Book1", "Author1", 100);
        Tool ll = new Tool("Screwdriver");
        Book lr = new Book("Book2", "Author2", 200);
        shelf.setUpperLeft(ul);
        shelf.setUpperRight(ur);
        shelf.setLowerLeft(ll);
        shelf.setLowerRight(lr);
        //act
        ShelfItem maxItem = shelf.max();
        //assert
        assertEquals(lr, maxItem);
    }
}