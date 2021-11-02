package com.codegym.model;

import javax.persistence.*;

@Entity
//@Table("blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tittle;
    private String content;
    @ManyToOne
        @JoinColumn(name = "category_id")
        private Category category;
        private String createDay;

    public Blog() {
    }

    public Blog(Long id, String tittle, String content) {
        this.id = id;
        this.tittle = tittle;
        this.content = content;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Blog(Long id, String tittle, String content, Category category, String createDay) {
        this.id = id;
        this.tittle = tittle;
        this.content = content;
        this.category = category;
        this.createDay = createDay;
    }

    public String getCreateDay() {
        return createDay;
    }

    public void setCreateDay(String createDay) {
        this.createDay = createDay;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
