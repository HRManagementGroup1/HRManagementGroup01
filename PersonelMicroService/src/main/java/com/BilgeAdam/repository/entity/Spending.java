package com.BilgeAdam.repository.entity;


import com.BilgeAdam.utility.enums.ECurrency;
import com.BilgeAdam.utility.enums.EState;
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
public class Spending {
    @Id
    private String id;
    private String type;
    private String personelId;
    private double amount;
    private LocalDate spendingDate;
    private LocalDate responseDate;
    private LocalDate requestDate;
    private EState state;
    private ECurrency currency;
    private String file;
    private String description;
}
