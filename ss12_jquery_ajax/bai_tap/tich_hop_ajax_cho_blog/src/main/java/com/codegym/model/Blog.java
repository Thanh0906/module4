package com.codegym.model;

import javax.persistence.*;

@Entity
@Table(name = "blog")
public class Blog {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private String createDate;
    @ManyToOne(targetEntity = Category.class)
    @JoinColumn(name = "catagory_id",referencedColumnName = "id")
    private Category category;

    public Blog() {
    }

    public Blog(Long id, String title, String content, String createDate, Category category) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createDate = createDate;
        this.category = category;
    }


    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}