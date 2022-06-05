package br.com.technews.entity;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class News {
    
    @GeneratedValue
    @Id
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "image")
    private String image;

    @Column(name = "content")
    private String content;

    @Column(name = "created_at")
    private Date createdAt;

    public News() {
    }

    public News(String title, String image, String content, Date createdAt) {
        this.title = title;
        this.image = image;
        this.content = content;
        this.createdAt = createdAt;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object o) {
  
      if (this == o)
        return true;
      if (!(o instanceof News))
        return false;
        News news = (News) o;
      return Objects.equals(this.id, news.id) 
        && Objects.equals(this.title, news.title)
        && Objects.equals(this.content, news.content) 
        && Objects.equals(this.createdAt, news.createdAt)
        && Objects.equals(this.image, news.image);
    }
  
    @Override
    public int hashCode() {
      return Objects.hash(this.id, this.title, this.content, this.createdAt, this.image);
    }
  
    @Override
    public String toString() {
      return "Employee{" + "id=" + this.id + ", title='" + this.title + '\'' + ", content='" + this.content + '\'' + ", createdAt=" + this.createdAt + ", image='" + this.image + '\'' + '}';
    }
}
