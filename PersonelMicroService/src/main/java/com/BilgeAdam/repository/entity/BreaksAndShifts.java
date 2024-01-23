package com.BilgeAdam.repository.entity;

import com.BilgeAdam.utility.enums.EType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Document
public class BreaksAndShifts {
    @Id
    private String id;
    private String personelId;
    private EType type;
    private LocalDate BSStartingDate;
    private LocalDate BSEndingDate;
    private double BSTotalTime;
}
