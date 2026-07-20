package com.example.operations.Controller;

import com.example.operations.Service.OperationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/operations")
public class OperationsController {
    @Autowired
    private OperationsService os;


    @PostMapping("/{flightId}/status")
    public Map<String, String> startOperations(@PathVariable Long flightId) {
        return os.processArrival(flightId);
    }

}