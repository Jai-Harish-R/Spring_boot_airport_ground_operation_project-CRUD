package com.example.fuel.Controller;

import com.example.fuel.DTO.RequestDTO;
import com.example.fuel.DTO.ResponseDTO;
import com.example.fuel.Entity.FuelRequest;
import com.example.fuel.Service.FuelService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/fuel")
public class FuelController {
    @Autowired
    private FuelService fls;

    @PostMapping("/add")
    public ResponseDTO addFuel(@Valid @RequestBody RequestDTO req) {
        return fls.addFuel(req);
    }

    @PutMapping("/update/{id}")
    public ResponseDTO updateFuel(@PathVariable Long id, @Valid @RequestBody RequestDTO req) {
        return fls.updateFuel(id, req);
    }

    @GetMapping("/all")
    public List<FuelRequest> getAllFuel() {
        return fls.getAllFuel();
    }

    @GetMapping("/{id}")
    public ResponseDTO getFuel(@PathVariable Long id) {
        return fls.getFuel(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteFuel(@PathVariable Long id) {
        return fls.deleteFuel(id);
    }

    @PutMapping("/request/{id}")
    public String request(@PathVariable Long id,@RequestParam Long quant,@RequestParam String status){
        return fls.request(id,quant,status);
    }

    @PutMapping("/complete/{id}")
    public String completed(@PathVariable Long id){
        return fls.completed(id);
    }
}
