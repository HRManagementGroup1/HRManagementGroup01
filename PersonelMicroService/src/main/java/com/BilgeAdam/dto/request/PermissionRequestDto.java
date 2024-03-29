package com.BilgeAdam.dto.request;

import com.BilgeAdam.utility.enums.EState;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PermissionRequestDto {
    String personelId;
    LocalDate startingDate;
    LocalDate endingDate;
    int usedPermissionDays;
    String type;
    LocalDate requestDate;
    EState state;
}
