package com.example.regera.Model;

import java.sql.Date;

public class ReviewDTO {
    private Integer id;
    private Date creatAt;
    private int rating;
    private String comment;
    private String author;
    private String img;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Date getCreatAt() {
        return creatAt;
    }

    public void setCreatAt(Date creat_at) {
        this.creatAt = creat_at;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
