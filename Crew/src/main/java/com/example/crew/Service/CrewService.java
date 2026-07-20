package com.example.crew.Service;

import com.example.crew.DTO.RequestDTO;
import com.example.crew.DTO.ResponseDTO;
import com.example.crew.Entity.Crew;
import com.example.crew.Exception.CrewNotFoundException;
import com.example.crew.Exception.CrewUnavailableException;
import com.example.crew.Repository.CrewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class CrewService {
    @Autowired
    private CrewRepository repo;

    public ResponseDTO addCrew(RequestDTO req){
        Crew crew = new Crew();
        crew.setCrewName(req.getCrewName());
        crew.setSpecialization(req.getSpecialization());
        crew.setAvailability(req.getAvailability());
        crew.setFlightId(req.getFlightId());
        repo.save(crew);
        ResponseDTO res =new ResponseDTO(crew.getId(),crew.getCrewName(),crew.getSpecialization(),crew.getAvailability(),crew.getFlightId());
        return res;
    }
     public ResponseDTO updateCrew(@PathVariable Long id, @RequestBody RequestDTO req){
         Crew crew = repo.findById(id).orElseThrow(() -> new CrewNotFoundException("The Crew with the given ID is not Found"));
         ResponseDTO res =new ResponseDTO(crew.getId(),crew.getCrewName(),crew.getSpecialization(),crew.getAvailability(),crew.getFlightId());
         return res;
     }

     public List<Crew> getAllCrew(){
        return repo.findAll();
     }

     public ResponseDTO getCrew(@PathVariable Long id){
        Crew crew=repo.findById(id).orElseThrow(()->new CrewNotFoundException("Crew with the given Id is not found"));
         ResponseDTO res =new ResponseDTO(crew.getId(),crew.getCrewName(),crew.getSpecialization(),crew.getAvailability(),crew.getFlightId());
         return res;
     }
      public String deleteCrew(@PathVariable Long id){
         Crew crew=repo.findById(id).orElseThrow(()->new CrewNotFoundException("Crew with the given Id is not found"));
          repo.deleteById(id);
          return "The Crew had been removed due to some Reason";
      }

      public String assignCrew(Long id,String  specialization){
          Crew crew = repo.findFirstByAvailabilityAndSpecializationIgnoreCase("AVAILABLE", specialization).orElseThrow(() -> new CrewUnavailableException("No crew member is currently AVAILABLE with that specialization"));
          crew.setAvailability("BUSY");
          crew.setFlightId(id);
          repo.save(crew);
          return "The Crew : " + crew.getCrewName() + " with Specialization : " + crew.getSpecialization() + " has been assigned for flight with ID : " + id;
      }
    public String deassign(Long crewId, Long flightId) {
        Crew crew = repo.findByIdAndFlightId(crewId, flightId) .orElseThrow(() -> new CrewNotFoundException("Crew not found assigned to this flight"));
        crew.setAvailability("AVAILABLE");
        crew.setFlightId(null);
        repo.save(crew);
        return "The Crew : "+crew.getCrewName() +" has been deassigned";
    }
}