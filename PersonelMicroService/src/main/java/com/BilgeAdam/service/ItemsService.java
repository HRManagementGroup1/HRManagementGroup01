package com.BilgeAdam.service;

import com.BilgeAdam.dto.request.ItemConfirmRequestDto;
import com.BilgeAdam.dto.request.ItemsRequestDto;
import com.BilgeAdam.dto.response.ItemConfirmResponseDto;
import com.BilgeAdam.dto.response.ItemsResponseDto;
import com.BilgeAdam.exception.ErrorType;
import com.BilgeAdam.exception.PersonelManagerException;
import com.BilgeAdam.repository.ItemsRepository;
import com.BilgeAdam.repository.entity.Items;
import com.BilgeAdam.repository.entity.Personel;
import com.BilgeAdam.utility.enums.EItemState;
import com.BilgeAdam.utility.enums.ERole;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
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
        Items items = Items.builder()
                .name(dto.getName())
                .personelId(personel.get().getId())
                .personelName(personel.get().getName())
                .personelSurname(personel.get().getSurname())
                .tcno(personel.get().getTcno())
                .startingDate(dto.getStartingDate())
                .endingDate(dto.getEndingDate())
                .createAt(LocalDate.now())
                .itemState(EItemState.PENDING)
                .build();
        if(personelService.findByIdFromLoginUser().get().getRole()== ERole.MANAGER){
            items.setApprovedName(personelService.findByIdFromLoginUser().get().getName());
            items.setApprovedSurname(personelService.findByIdFromLoginUser().get().getSurname());
            items.setItemState(EItemState.APPROVED);
        }
        itemsRepository.save(items);
        return ItemsResponseDto.builder()
                .ownerName(personelService.findByIdFromLoginUser().get().getName())
                .ownerSurname(personelService.findByIdFromLoginUser().get().getSurname())
                .startingDate(items.getStartingDate())
                .endingDate(items.getEndingDate())
                .name(items.getName())
                .itemState(items.getItemState())
                .createAt(LocalDate.now())
                .build();
    }


    public List<Items> findAllItems() {
        if(personelService.findByIdFromLoginUser().get().getRole()!= ERole.MANAGER){
            throw new PersonelManagerException(ErrorType.AUTHORITY_IS_NOT_ENOUGH);
        }
        return itemsRepository.findAll();
    }

    public ItemConfirmResponseDto confirmItems(ItemConfirmRequestDto dto) {
        Optional<Items>item=itemsRepository.findItemsById(dto.getItemId());
        if(item.isEmpty()){
            throw new PersonelManagerException(ErrorType.Item_Not_Found);
        }
        if(personelService.findByIdFromLoginUser().get().getRole()!= ERole.MANAGER){
            throw new PersonelManagerException(ErrorType.AUTHORITY_IS_NOT_ENOUGH);
        }else {
            item.get().setItemState(EItemState.APPROVED);
            item.get().setApprovedName(personelService.findByIdFromLoginUser().get().getName());
            item.get().setApprovedSurname(personelService.findByIdFromLoginUser().get().getSurname());
            item.get().setUpdateAt(LocalDate.now());
            itemsRepository.save(item.get());
        }
        return ItemConfirmResponseDto.builder()
                .managerName(item.get().getApprovedName())
                .managerSurname(item.get().getApprovedSurname())
                .itemId(item.get().getId())
                .itemState(item.get().getItemState())
                .updateAt(LocalDate.now())
                .build();
    }
}
