package com.BilgeAdam.service;

import com.BilgeAdam.dto.request.ItemsRequestDto;
import com.BilgeAdam.dto.response.ItemsResponseDto;
import com.BilgeAdam.exception.ErrorType;
import com.BilgeAdam.exception.PersonelManagerException;
import com.BilgeAdam.mapper.ItemsMapper;
import com.BilgeAdam.repository.ItemsRepository;
import com.BilgeAdam.repository.entity.Items;
import com.BilgeAdam.repository.entity.Personel;
import com.BilgeAdam.utility.enums.ERole;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.BilgeAdam.service.PersonelService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemsService {

    private final ItemsRepository itemsRepository;
    private final PersonelService personelService;


    public ItemsResponseDto createItems(ItemsRequestDto dto) {
        Optional<Personel>personel=personelService.findPersonelByTCNO(dto.getPersonelTcno());
        if (personel.isEmpty()){
            throw new PersonelManagerException(ErrorType.PERSONEL_NOT_FOUND);
        }
        if(personelService.findByIdFromLoginUser().get().getRole()!= ERole.MANAGER){
            throw new PersonelManagerException((ErrorType.AUTHORITY_IS_NOT_ENOUGH));
        }
        Items items = Items.builder()
                .name(dto.getName())
                .personelId(personel.get().getId())
                .managerName(personelService.findByIdFromLoginUser().get().getName())
                .managerName(personelService.findByIdFromLoginUser().get().getSurname())
                .startingDate(dto.getStartingDate())
                .endingDate(dto.getEndingDate())
                .build();
        itemsRepository.save(items);
        return ItemsResponseDto.builder()
                .managerName(personelService.findByIdFromLoginUser().get().getName())
                .managerSurname(personelService.findByIdFromLoginUser().get().getSurname())
                .Personelname(personel.get().getName())
                .PersonelSurname(personel.get().getSurname())
                .startingDate(items.getStartingDate())
                .endingDate(items.getEndingDate())
                .name(items.getName())
                .build();
    }
}
