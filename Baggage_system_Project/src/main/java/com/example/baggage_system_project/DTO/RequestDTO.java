package com.example.baggage_system_project.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestDTO {

    @NotNull(message = "FlightID cannot be blank")
    private Long flightId;

    @NotNull(message = "TotalBags cannot be blank")
    private Integer totalBags;

    private Integer loadedBags;
    @NotBlank(message = "Status cannot be blank")
    @Pattern(regexp = "(i?)LOADING|COMPLETE",message = "Invalid status")
    private String status;
}
