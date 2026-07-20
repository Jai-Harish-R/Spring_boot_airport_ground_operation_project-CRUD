package com.example.crew.Controller;

import com.example.crew.DTO.RequestDTO;
import com.example.crew.DTO.ResponseDTO;
import com.example.crew.Entity.Crew;
import com.example.crew.Service.CrewService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/crew")
public class CrewController {
    @Autowired
    private CrewService crs;

    @PostMapping
    public ResponseDTO addCrew(@Valid @RequestBody RequestDTO req){
        return crs.addCrew(req);
    }

    @PutMapping("/{id}")
    public ResponseDTO updateCrew(@PathVariable Long id, @Valid @RequestBody RequestDTO req){
        return crs.updateCrew(id,req);
    }

    @GetMapping("/{id}")
    public ResponseDTO getCrew(@PathVariable Long id){
        return crs.getCrew(id);
    }

    @GetMapping
    public List<Crew> getAllCrew(){
        return crs.getAllCrew();
    }

    @DeleteMapping("/{id}")
    public String deleteCrew(@PathVariable Long id){
        return crs.deleteCrew(id);
    }

    @PutMapping("/assign/{id}")
    public String assignCrew(@PathVariable Long id, @RequestParam String specialization){
        return crs.assignCrew(id, specialization);
    }
    @PutMapping("/deassign/{id}")
    public String deassign(@PathVariable Long id,@RequestParam Long FlightId){
        return crs.deassign(id,FlightId);
    }
}
