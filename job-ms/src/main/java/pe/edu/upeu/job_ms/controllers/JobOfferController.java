package pe.edu.upeu.job_ms.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upeu.job_ms.clients.UniversityClient;
import pe.edu.upeu.job_ms.dto.UniversityDTO;

@RestController
@RequestMapping("job")
public class JobOfferController {
    private final UniversityClient universityClient;

    public JobOfferController(UniversityClient universityClient) {
        this.universityClient = universityClient;
    }

    @GetMapping("/test-feign/{id}")
    public ResponseEntity<UniversityDTO> testConnection(@PathVariable Long id) {
        UniversityDTO university = universityClient.findById(id);
        return ResponseEntity.ok(university);
    }
}
