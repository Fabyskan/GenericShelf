package org.example;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

public class TestTool {

    // CONSTRUCTOR TESTS

    @Test
    public void constructor_setsAllFields(){
        //arrange
        Tool tool = new Tool("Hammer");
        //act
        //assert
        assertEquals("Hammer", tool.getName());
    }

    @ParameterizedTest
    @NullAndEmptySource
    public void constructor_throwsException_whenNameIsNullOrBlank(String input){
        //arrange
        //act
        //assert
        assertThrows(IllegalArgumentException.class, () -> new Tool(input));
    }

    // TO STRING TEST

    @Test
    public void ToString_testFormat(){
        //arrange
        Tool tool = new Tool("Hammer");
        //act
        //assert
        assertEquals("Tool{name='Hammer'}", tool.toString());
    }
}
