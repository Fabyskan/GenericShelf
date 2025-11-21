package org.example;

public class Tool extends Shelfitem{

    private final String name;

    public Tool(String name)
    {
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("Name cannot be null or empty.");
        }
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    @Override
    public String toString(){
        return "Tool{name='"+getName()+"'}";
    }
}
