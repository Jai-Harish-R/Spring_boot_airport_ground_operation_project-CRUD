package com.example.fuel.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDTO {
    private Long id;

    private Long flightId;

    private Long quantity;

    private String status;
}
