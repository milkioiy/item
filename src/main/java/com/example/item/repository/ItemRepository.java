package com.example.item.repository;

import com.example.item.entity.item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<item, Long> {
    List<item> findAllByOrderByModifiedAtDesc(); // Method이름으로 SQL을 생성할수있는 Method ,  수정시간 내림차순 정렬

    List<item> findAllByUsername(String username);
}