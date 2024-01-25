package com.BilgeAdam.controller;

import com.BilgeAdam.dto.request.ItemsRequestDto;
import com.BilgeAdam.dto.response.ItemsResponseDto;
import com.BilgeAdam.service.ItemsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
