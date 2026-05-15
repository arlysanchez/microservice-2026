package pe.edu.upeu.university_crud.controllers;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.university_crud.entity.University;
import pe.edu.upeu.university_crud.services.UniversityService;
import org.slf4j.*;

import java.net.URI;

@RestController
@RequestMapping(path = "university")
@Tag(name = "University resources")
public class UniversityController {

    private final UniversityService universityService;
    private final Logger log = LoggerFactory.getLogger(UniversityController.class);

    public UniversityController(UniversityService universityService) {
        this.universityService = universityService;
    }

    @Operation(summary = "get a university given a university name")
    @GetMapping(path = "{name}")
    public ResponseEntity<University> get(@PathVariable String name){
        log.info("GET: university {}",name);
        return ResponseEntity.ok(this.universityService.readByName(name));
    }

    @Operation(summary = "save in DB a university given a university from body")
    @PostMapping
    public ResponseEntity<University> post (@RequestBody University university){
        log.info("POST: university {}",university.getName());
        return ResponseEntity.created(
                URI.create(this.universityService.create(university).getName()))
                        .build();
    }
    @Operation(summary = "update in DB a university given a university from body")
    @PutMapping(path = "{name}")
    public ResponseEntity<University> put(@RequestBody University university,
                                          @PathVariable String name) {
        log.info("PUT: university {}", name);
        return ResponseEntity.ok(this.universityService.update(university, name));
    }
    @Operation(summary = "delete in DB a university given a university name")
    @DeleteMapping(path = "{name}")
    public ResponseEntity<?> delete(@PathVariable String name) {
        log.info("DELETE: university {}", name);
        this.universityService.delete(name);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Search by Id university")
    @GetMapping("/id/{id}")
    public ResponseEntity<University> findById(@PathVariable Long id){
        return universityService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }




}
