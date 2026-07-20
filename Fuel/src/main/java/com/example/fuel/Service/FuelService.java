package com.example.fuel.Service;

import com.example.fuel.DTO.RequestDTO;
import com.example.fuel.DTO.ResponseDTO;
import com.example.fuel.Entity.FuelRequest;
import com.example.fuel.Exception.FlightNotFoundException;
import com.example.fuel.Exception.FuelNotFoundException;
import com.example.fuel.Repository.FuelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuelService {
    @Autowired
    private FuelRepository repo;
    public ResponseDTO addFuel(RequestDTO req) {
        FuelRequest fuel = new FuelRequest();
        fuel.setFlightId(req.getFlightId());
        fuel.setQuantity(req.getQuantity());
        fuel.setStatus(req.getStatus());
        repo.save(fuel);
        ResponseDTO res = new ResponseDTO(fuel.getId(), fuel.getFlightId(), fuel.getQuantity(), fuel.getStatus());
        return res;
    }

    public ResponseDTO updateFuel(Long id, RequestDTO req) {
        FuelRequest fuel = repo.findById(id).orElseThrow(() -> new FuelNotFoundException("Fuel Request with the given ID is not found"));
        fuel.setFlightId(req.getFlightId());
        fuel.setQuantity(req.getQuantity());
        fuel.setStatus(req.getStatus());
        repo.save(fuel);
        ResponseDTO res = new ResponseDTO(fuel.getId(), fuel.getFlightId(), fuel.getQuantity(), fuel.getStatus());
        return res;
    }

    public List<FuelRequest> getAllFuel() {
        return repo.findAll();
    }

    public ResponseDTO getFuel(Long id) {
        FuelRequest fuel = repo.findById(id).orElseThrow(() -> new FuelNotFoundException("Fuel Request with the given ID is not found"));
        ResponseDTO res = new ResponseDTO(fuel.getId(), fuel.getFlightId(), fuel.getQuantity(), fuel.getStatus());
        return res;
    }

    public String deleteFuel(Long id) {
        FuelRequest fuel = repo.findById(id).orElseThrow(() -> new FuelNotFoundException("Fuel Request with the given ID is not found"));
        repo.deleteById(id);
        return "The Fuel Request has been removed successfully";
    }

    public String request(Long id, Long quant, String status) {
        FuelRequest fuel = repo.findFirstByStatus("FREE").orElseThrow(() -> new FuelNotFoundException("No fuel station is currently free"));
        fuel.setFlightId(id);
        fuel.setQuantity(quant);
        fuel.setStatus("FUELING");
        repo.save(fuel);
        return "The Flight with ID : " + id + " is Currently Fueling";
    }
    public String completed(Long id){
        FuelRequest fuel=repo.findByFlightId(id).orElseThrow(() ->new FlightNotFoundException("Fuel Request cannot be freformed due to no available fuel station"));
        fuel.setFlightId(null);
        fuel.setStatus("FREE");
        fuel.setQuantity((long)2000);
        return "The Flight with ID : "+id+" had been fueled and fuel station with ID : "+fuel.getId()+"is free now";
    }
}
