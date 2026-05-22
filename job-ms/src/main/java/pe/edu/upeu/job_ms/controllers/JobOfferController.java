package pe.edu.upeu.job_ms.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.job_ms.clients.UniversityClient;
import pe.edu.upeu.job_ms.dto.UniversityDTO;
import pe.edu.upeu.job_ms.entity.JobOffer;
import pe.edu.upeu.job_ms.services.JobOfferService;

import java.util.Map;

@RestController
@RequestMapping("job")
public class JobOfferController {
    //metodo de testeo de feign client
    /*
    private final UniversityClient universityClient;

    public JobOfferController(UniversityClient universityClient) {
        this.universityClient = universityClient;
    }

    @GetMapping("/test-feign/{id}")
    public ResponseEntity<UniversityDTO> testConnection(@PathVariable Long id) {
        UniversityDTO university = universityClient.findById(id);
        return ResponseEntity.ok(university);
    }
         */

    private final JobOfferService service;

    public JobOfferController(JobOfferService service) {
        this.service = service;
    }

    @PostMapping
    public JobOffer create(@RequestBody JobOffer jobOffer){
        return service.save(jobOffer);
    }
    @GetMapping("/{id}")
    public Map<String, Object> getById(@PathVariable Long id){
        return service.getOfferWithUniversity(id);
    }

}
