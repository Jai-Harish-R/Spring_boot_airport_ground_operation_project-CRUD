package com.example.baggage_system_project.Controller;

import com.example.baggage_system_project.Service.BaggageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/baggage")
public class BaggageController {
    @Autowired
    private BaggageService bas;

    @PostMapping("/load/{flight}")
    public String load(@PathVariable Long flight, @RequestParam Integer quant){
        return bas.load(flight,quant);
    }

    @PutMapping("/complete/{id}")
    public String complete(@PathVariable Long id){
        return bas.complete(id);
    }
}
