package org.example;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class TestBook {

    @Test
    public void testBook(){
    }

    @Test
    public void getAuthorHappy(){
        Book book = new Book("Krabat","Ottfried Preußler", 284);
        assertEquals("Ottfried Preußler", book.getAuthor());
    }

    @Test
    public void getAuthorBad(){
        Book book1 = new Book("Krabat","Ottfried Preußler", 284);
        assertNotEquals("Hans im Glück", book1.getAuthor());
        assertThrows(IllegalArgumentException.class, () -> new Book("Hans im Glück",null, 56));
        assertThrows(IllegalArgumentException.class, () -> new Book("Hans im Glück","", 56));
    }

    @Test
    public void getTitleHappy(){
        Book book = new Book("Krabat","Ottfried Preußler", 284);
        assertEquals("Krabat", book.getTitle());
    }

    @Test
    public void getTitleBad(){
        Book book1 = new Book("Krabat","Ottfried Preußler", 284);
        assertNotEquals("Hans im Glück", book1.getTitle());
        assertThrows(IllegalArgumentException.class, () -> new Book(null,"null", 56));
        assertThrows(IllegalArgumentException.class, () -> new Book("","null", 56));
    }

    @Test
    public void getPagesHappy(){
        Book book = new Book("Krabat","Ottfried Preußler", 284);
        assertEquals(284, book.getPages());
    }

    @Test
    public void getPagesBad(){
        Book book1 = new Book("Krabat","Ottfried Preußler", 284);
        assertNotEquals("1", book1.getPages());
        assertThrows(IllegalArgumentException.class, () -> new Book("Hans im Glück","leer",0));
        assertThrows(IllegalArgumentException.class, () -> new Book("Hans im Glück","leer",-6000));
        assertThrows(IllegalArgumentException.class, () -> new Book("Hans im Glück","leer",5001));
    }

    @Test
    public void testToStringHappy(){
        Book book = new Book("Krabat","Ottfried Preußler", 284);
        assertEquals("Book{title='Krabat', author='Ottfried Preußler', pages=284}", book.toString());
    }


    @Test // AI generated additional tests
    public void testToStringFormat() {
        Book book = new Book("Test", "Author", 100);
        String result = book.toString();
        assertTrue(result.contains("title='Test'"));
        assertTrue(result.contains("author='Author'"));
        assertTrue(result.contains("pages=100"));
    }

    @Test // AI generated additional tests
    public void testToStringSpecialCharacters() {
        Book book = new Book("Test's \"Book\"", "O'Brien", 42);
        String result = book.toString();
        assertTrue(result.contains("Test's \"Book\""));
        assertTrue(result.contains("O'Brien"));
    }

    @Test // AI generated additional tests
    public void testToStringBoundaryValues() {
        Book minBook = new Book("A", "B", 1);
        assertEquals("Book{title='A', author='B', pages=1}", minBook.toString());

        Book maxBook = new Book("Z", "Y", 5000);
        assertEquals("Book{title='Z', author='Y', pages=5000}", maxBook.toString());
    }
}
