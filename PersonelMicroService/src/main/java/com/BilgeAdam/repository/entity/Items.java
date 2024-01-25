package com.BilgeAdam.repository.entity;

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
public class Items {
   @Id
   private String id;
   private String personelId;
   private String tcno;
   private LocalDate startingDate;
   private LocalDate endingDate;
   private String name;
   private String managerName;
   private String managerSurname;
}
