package org.example;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;


public class TestBook {

    // CONSTRUCTOR TESTS

    @Test
    public void constructor_setsAllFields(){
        //arrange
        Book book = new Book("Krabat","Ottfried Preußler", 284);
        //act
        //assert
        assertAll(
                () -> assertEquals("Krabat", book.getTitle()),
                () ->  assertEquals("Ottfried Preußler", book.getAuthor()),
                () ->  assertEquals(284, book.getPages())
        );
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {""," "})
    public void constructor_throwsException_whenAuthorIsNullOrBlank(String input){
        //arrange
        //act
        //assert
        assertThrows(IllegalArgumentException.class, () -> new Book("A",input, 5));
    }


    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {""," "})
    public void constructor_throwsException_whenTitleIsNullOrBlank(String input){
        //arrange
        //act
        //assert
        assertThrows(IllegalArgumentException.class, () -> new Book(input,"A", 5));
    }


    @ParameterizedTest
    @ValueSource(ints = {0, -10, 6000})
    public void constructor_throwsException_whenPagesAreOutOfBounds(int pages){
        //arrange
        //act
        //assert
        assertThrows(IllegalArgumentException.class, () -> new Book("Hans im Glück","leer",pages));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 5000})
    public void constructor_passes_whenPagesAreBoundaries(int pages){
        //arrange
        Book book = new Book("A","B",pages);
        //act
        //assert
        assertEquals(pages, book.getPages());
    }

    // TO STRING TEST

    @Test
    public void ToString_testFormat(){
        //arrange
        Book book = new Book("Krabat","Ottfried Preußler", 284);
        //act
        //assert
        assertEquals("Book{title='Krabat', author='Ottfried Preußler', pages=284}", book.toString());
    }
}
