package com.BilgeAdam.dto.request;

import com.BilgeAdam.utility.enums.ECurrency;
import com.BilgeAdam.utility.enums.EState;
<<<<<<<<< Temporary merge branch 1

=========
>>>>>>>>> Temporary merge branch 2
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AdvanceRequestDto {
    String personelId;
    double amount;
    LocalDate date;
    EState state;
    LocalDate responseDate;
    ECurrency currency;

}