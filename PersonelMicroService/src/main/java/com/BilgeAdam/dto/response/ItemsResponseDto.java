package com.BilgeAdam.dto.response;

import com.BilgeAdam.utility.enums.EItemState;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemsResponseDto {
    private String ownerName;
    private String ownerSurname;
    private LocalDate startingDate;
    private LocalDate endingDate;
    private String name;
    private EItemState itemState;
    private LocalDate createAt;
}
