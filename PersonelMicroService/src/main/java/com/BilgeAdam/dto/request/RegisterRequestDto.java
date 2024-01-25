package com.BilgeAdam.dto.request;

import com.BilgeAdam.utility.enums.ERole;
import com.BilgeAdam.utility.enums.EState;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequestDto {
    @NotBlank
    private String name;
    @NotBlank
    private String surname;
    @NotBlank
    private String TCNO;
    @NotBlank
    @Size(min =8, max=32, message = "Sifre minimum 8 maksimum 32 karakterden olusmalidir...")
    private String password;
    @Email
    private String email;
    @NotBlank
    private String phone;
    @NotBlank
    private String photo;
    private String company;
    private LocalDate dateOfBirth;
    private LocalDate hiringDate;
    private String department;
    private String address;
    @NotBlank
    private String title;
    private double salary;
    private ERole role;
    @NotBlank
    private EState state;
    private int remainingDaysOff;

}
