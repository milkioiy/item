package com.example.item.controller;

import com.example.item.dto.itemRequestDto;
import com.example.item.dto.itemResponseDto;
import com.example.item.repository.ItemRepository;
import com.example.item.service.itemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
public class itemController {

    private final JdbcTemplate jdbcTemplate;
    private final ItemRepository itemRepository; // ItemRepository 필드 추가

    @Autowired
    public itemController(JdbcTemplate jdbcTemplate, ItemRepository itemRepository) {
        this.jdbcTemplate = jdbcTemplate;
        this.itemRepository = itemRepository; // ItemRepository 빈 주입
    }

    @PostMapping("/post")
    public itemResponseDto createitem(@RequestBody itemRequestDto requestDto) {
        itemService itemService = new itemService(itemRepository);
        return itemService.createitem(requestDto);
    }

    @GetMapping("/post")
    public List<itemResponseDto> getitems() {
        itemService itemService = new itemService(itemRepository);
        return itemService.getitems();
    }

    @PutMapping("/post/{id}")
    public Long updateitem(@PathVariable Long id, @RequestBody itemRequestDto requestDto) {
        itemService itemService = new itemService(itemRepository);
        return itemService.updateitem(id, requestDto);
    }

    @DeleteMapping("/post/{id}")
    public Long deleteitem(@PathVariable Long id) {
        itemService itemService = new itemService(itemRepository);
        return itemService.deleteitem(id);
    }
}