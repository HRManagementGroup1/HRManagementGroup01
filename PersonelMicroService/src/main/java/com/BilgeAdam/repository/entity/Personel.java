package com.BilgeAdam.repository.entity;


import com.BilgeAdam.utility.enums.ERole;
import com.BilgeAdam.utility.enums.EState;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Document

public class Personel implements Serializable {
   @Id
   private String id;
   private String name;
   private String surname;
   private String TCNO;
   private String email;
   private String password;
   private String phone;
   private String photo;
   private String company;
   private LocalDate dateOfBirth;
   private LocalDate hiringDate;
   private String department;
   private String address;
   private String title;
   private double salary;
   private ERole role;
   private EState state;
   private int remainingDaysOff;

}
