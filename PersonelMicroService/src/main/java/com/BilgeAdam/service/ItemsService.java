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

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemsService {

    private final ItemsRepository itemsRepository;
    private final PersonelService personelService;

    public ItemsResponseDto createItems(ItemsRequestDto dto) {
        Optional<Personel>personel=personelService.findPersonelByTCNO(dto.getTCNO());
        if (personel.isEmpty()){
            throw new PersonelManagerException(ErrorType.PERSONEL_NOT_FOUND);
        }
        Optional<Personel>manager=personelService.findPersonelByTCNO(dto.getApprovedPersonTCNO());
        if(manager.isEmpty()){
            throw new PersonelManagerException(ErrorType.PERSONEL_NOT_FOUND);
        }if(manager.get().getRole()!= ERole.MANAGER){
            throw new PersonelManagerException((ErrorType.AUTHORITY_IS_NOT_ENOUGH));
        }
        Items items = Items.builder()
                .name(dto.getName())
                .personelId(personel.get().getId())
                .ApprovedPersonTCNO(manager.get().getTCNO())
                .startingDate(dto.getStartingDate())
                .endingDate(dto.getEndingDate())
                .build();
        itemsRepository.save(items);

        return ItemsResponseDto.builder()
                .managerName(manager.get().getName())
                .managerSurname(manager.get().getSurname())
                .Personelname(personel.get().getName())
                .PersonelSurname(personel.get().getSurname())
                .startingDate(items.getStartingDate())
                .endingDate(items.getEndingDate())
                .name(items.getName())
                .build();
    }
}
