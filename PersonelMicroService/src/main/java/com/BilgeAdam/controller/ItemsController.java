package com.BilgeAdam.controller;

import com.BilgeAdam.dto.request.ItemConfirmRequestDto;
import com.BilgeAdam.dto.request.ItemsRequestDto;
import com.BilgeAdam.dto.response.FindAllItemResponseDto;
import com.BilgeAdam.dto.response.ItemConfirmResponseDto;
import com.BilgeAdam.dto.response.ItemsResponseDto;
import com.BilgeAdam.repository.entity.Items;
import com.BilgeAdam.service.ItemsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.BilgeAdam.constants.RestApiUrls.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(ITEMS)
public class ItemsController {
    private final ItemsService itemsService;
    @PostMapping(CREATE)
    public ResponseEntity<ItemsResponseDto>createItems(@RequestBody @Valid ItemsRequestDto dto){
        return ResponseEntity.ok(itemsService.createItems(dto));
    }

    @GetMapping(FINDALL)
    public ResponseEntity<List<Items>>findAllItems(){
        return ResponseEntity.ok(itemsService.findAllItems());
    }

    @GetMapping(CONFIRM)
    public ResponseEntity<ItemConfirmResponseDto>itemConfirm(ItemConfirmRequestDto dto){
        return ResponseEntity.ok(itemsService.confirmItems(dto));
    }


}
