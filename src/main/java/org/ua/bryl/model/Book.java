package org.ua.bryl.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.List;

/**
  Created by olegbryl 01/08/2018.
 */

@Entity
public class Book implements Serializable {

    private static final long serialVersionUID = -5275312162791227880L;

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue
    private int book_id;

    @NotEmpty(message = "The name of the book is required")
    @GeneratedValue
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private String firstName;

    private String description;
    private String category;
    private String author;





    @Transient
    private MultipartFile image;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }



    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }






}
