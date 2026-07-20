package com.example.crew.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ResponseDTO {
    private Long id;

    private String crewName;

    private String specialization;

    private String availability;

    private Long flightId;
}
