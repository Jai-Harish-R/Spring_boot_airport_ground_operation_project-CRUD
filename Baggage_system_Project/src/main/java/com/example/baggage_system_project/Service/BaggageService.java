package com.example.baggage_system_project.Service;

import com.example.baggage_system_project.DTO.RequestDTO;
import com.example.baggage_system_project.Entity.Baggage;
import com.example.baggage_system_project.Exception.BaggageException;
import com.example.baggage_system_project.Repository.BaggageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BaggageService {
    @Autowired
    private BaggageRepository repo;

    public String load(Long id, Integer quantity){
        RequestDTO res=new RequestDTO();
        res.setFlightId(id);
        res.setTotalBags(quantity);
        res.setLoadedBags(0);
        res.setStatus("LOADING");
        Baggage bg=new Baggage();
        bg.setFlightId(res.getFlightId());
        bg.setLoadedBags(res.getLoadedBags());
        bg.setTotalBags(res.getTotalBags());
        bg.setStatus(res.getStatus());
        repo.save(bg);
        return "The baggage for the flight with ID : "+bg.getFlightId()+" is Loading";
    }

    public String complete(Long id){
        Baggage bg=repo.findById(id).orElseThrow(()->new BaggageException("Baggage id not Found"));
        bg.setStatus("COMPLETE");
        return "The baggage for the flight with ID : "+bg.getFlightId()+" is Loading";
    }

}
