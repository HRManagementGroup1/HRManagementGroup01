package com.BilgeAdam.dto.response;

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
    private String Personelname;
    private String PersonelSurname;
    private String managerName;
    private String managerSurname;
    private LocalDate startingDate;
    private LocalDate endingDate;
    private String name;
}
