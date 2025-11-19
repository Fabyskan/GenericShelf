package org.example;

public class Book extends Shelfitem{

    private final String title;
    private final String author;
    private final int pages;

    public Book(String title, String author, int pages){
        if(pages < 1){
            throw new IllegalArgumentException("A book must have at least one page.");
        }
        if(pages > 5000){
            throw new IllegalArgumentException("A book cannot have more than 5000 pages.");
        }
        if(title == null || title.isBlank()){
            throw new IllegalArgumentException("Title cannot be null or empty.");
        }
        if(author == null || author.isBlank()){
            throw new IllegalArgumentException("Author cannot be null or empty.");
        }
        this.title = title;
        this.author = author;
        this.pages = pages;
    }

    public String getTitle(){
        return title;
    }

    public String getAuthor(){
        return author;
    }

    public int getPages(){
        return pages;
    }

    @Override
    public String toString(){return "A";}
}
