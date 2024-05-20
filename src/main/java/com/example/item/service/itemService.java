package com.example.item.service;

import com.example.item.dto.itemRequestDto;
import com.example.item.dto.itemResponseDto;
import com.example.item.entity.item;
import com.example.item.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class itemService {

    private final ItemRepository itemRepository;

    public itemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public itemResponseDto createitem(itemRequestDto requestDto) {
        // RequestDto -> Entity
        item item = new item(requestDto);

        // DB 저장
        item saveitem = itemRepository.save(item);

        // Entity -> ResponseDto
        itemResponseDto itemResponseDto = new itemResponseDto(saveitem);

        return itemResponseDto;
    }

    public List<itemResponseDto> getitems() {
        // DB 조회
        return itemRepository.findAllByOrderByModifiedAtDesc().stream().map(itemResponseDto::new).toList();
    }

    //@Transactional
    public Long updateitem(Long id, itemRequestDto requestDto) {
        // 해당 메모가 DB에 존재하는지 확인
        item itemToUpdate = itemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 아이템이 존재하지 않습니다. id=" + id));

        // 아이템 정보를 업데이트합니다.
        itemToUpdate.update(requestDto);

        // 업데이트된 아이템을 저장하고, 아이템의 id를 반환합니다.
        return itemRepository.save(itemToUpdate).getId();
    }

    public Long deleteitem(Long id) {
        // 해당 메모가 DB에 존재하는지 확인
        item itemToDelete = itemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 아이템이 존재하지 않습니다. id=" + id));

        // 아이템을 삭제합니다.
        itemRepository.delete(itemToDelete);
        System.out.println("msg:삭제완료");

        // 삭제된 아이템의 id를 반환합니다.
        return id;
    }

    private item finditem(Long id) {
        return itemRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("선택한 아이템은 존재하지 않습니다.")
        );
    }
}