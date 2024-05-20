package com.example.item.dto;


import com.example.item.entity.item;
import lombok.Getter;

@Getter
public class itemResponseDto {
    private Long id;
    private String username;
    private String content;
    private String title;
    private Integer price;
    public itemResponseDto(Long id, String username, String content, String title, Integer price) {
        this.id = id;
        this.username = username;
        this.content = content;
        this.price = price;
        this.title = title;
    }

    public itemResponseDto(item item) {
        this.id = item.getId();
        this.username = item.getUsername();
        this.content = item.getContent();
        this.title = item.getTitle();
        this.price = item.getPrice();
    }


}
