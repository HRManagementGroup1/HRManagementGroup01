package com.BilgeAdam.dto.request;

<<<<<<< HEAD
=======

>>>>>>> f66a1401428ac3a2a4f368e1d31dfa36406ef3cd
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
public class AdvanceRequestDto {
    String personelId;
    double amount;
    LocalDate date;
    EState state;
    LocalDate responseDate;
    ECurrency currency;

}