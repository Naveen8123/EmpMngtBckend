package com._TechSoft.EmployeeManagement.dto;

import jakarta.persistence.Column;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class EmpolyeeRequest {
    private String firstName;
    private String lastName;
    private String email;
}
