package com.example.item.dto;
import lombok.Getter;

@Getter
public class itemRequestDto {
    private String username;
    private String content;
    private String title;
    private Integer price;

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getContent() {
        return content;
    }
    public void setcontent(String content) {
        this.content = content;
    }


    public String getTitle(){return title;}
    public void setTitle(String title){this.title=title;}

    public Integer getPrice(){return price;}


}