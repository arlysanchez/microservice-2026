package pe.edu.upeu.job_ms.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pe.edu.upeu.job_ms.dto.UniversityDTO;

//@FeignClient(name ="university_crud", path = "university_crud/university")
@FeignClient(
        name = "ms-university",
        url = "http://ms-university:8081",
        path = "/university_crud/university"
)
public interface UniversityClient {

    @GetMapping("/id/{id}")
    UniversityDTO findById(@PathVariable("id") Long id);

}
