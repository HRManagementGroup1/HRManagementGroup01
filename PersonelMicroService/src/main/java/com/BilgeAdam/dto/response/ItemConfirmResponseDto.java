package com.BilgeAdam.dto.response;

import com.BilgeAdam.repository.entity.BaseEntity;
import com.BilgeAdam.utility.enums.EItemState;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemConfirmResponseDto {
    private String itemId;
    private String managerName;
    private String managerSurname;
    private EItemState itemState;
    private LocalDate updateAt;


}
