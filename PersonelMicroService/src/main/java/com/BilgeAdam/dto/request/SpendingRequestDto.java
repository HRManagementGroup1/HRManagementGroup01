package com.BilgeAdam.dto.request;

import com.BilgeAdam.utility.enums.ECurrency;
import com.BilgeAdam.utility.enums.EState;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SpendingRequestDto {
    String type;
    String personelId;
    double amount;
    LocalDate spendingDate;
    LocalDate responseDate;
    LocalDate requestDate;
    EState state;
    ECurrency currency;
    String file;
    String description;

}
