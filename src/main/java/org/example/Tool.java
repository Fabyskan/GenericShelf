package org.example;

public class Tool extends Shelfitem{

    private final String name;

    public Tool(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString(){}
}
