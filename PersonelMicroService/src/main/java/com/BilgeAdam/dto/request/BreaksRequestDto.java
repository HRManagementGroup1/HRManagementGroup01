package com.BilgeAdam.dto.request;

import com.BilgeAdam.utility.enums.EType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BreaksRequestDto {
    String personelId;
    EType type;
    LocalDate breakStartingDate;
    LocalDate breakEndingDate;
    double BSTotalTime;
}
