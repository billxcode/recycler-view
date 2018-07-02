package id.technologue.jauharibill.technologue;

/**
 * Created by jauharibill on 7/2/2018.
 */

public class News {
    private String title, author, date, photo;

    public String getTitle(){
        return title;
    }

    public String getAuthor(){
        return author;
    }

    public String getDate(){
        return date;
    }

    public String getPhoto(){
        return photo;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    public void setDate(String date){
        this.date = date;
    }

    public void setPhoto(String photo){
        this.photo = photo;
    }

}
