package pe.edu.upeu.job_ms.services;

import org.springframework.stereotype.Service;
import pe.edu.upeu.job_ms.Repository.JobOfferRepository;
import pe.edu.upeu.job_ms.clients.UniversityClient;
import pe.edu.upeu.job_ms.dto.UniversityDTO;
import pe.edu.upeu.job_ms.entity.JobOffer;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.*;

@Service
public class JobOfferServiceImpl implements JobOfferService{

    private final UniversityClient universityClient;
    private final JobOfferRepository jobOfferRepository;
    private static final Logger log = LoggerFactory.getLogger(JobOfferServiceImpl.class);

    public JobOfferServiceImpl(UniversityClient universityClient, JobOfferRepository jobOfferRepository) {
        this.universityClient = universityClient;
        this.jobOfferRepository = jobOfferRepository;
    }

    @Override
    public JobOffer save(JobOffer jobOffer) {
        return jobOfferRepository.save(jobOffer);
    }

    @Override
    public Map<String, Object> getOfferWithUniversity(Long id) {
      /*  log.info("Buscar oferta por id: {}",id);
        UniversityDTO university = universityClient.findById(id);

        if (university !=null){
            log.info("Datos recibidos ID : {},Nombre: {}",university.getId(),university.getName());
        }else{
            log.error("no llego el id de la universidad");
        }
        Map<String, Object> response = new HashMap<>();
        response.put("university_recived", university);
        return response;
       */
        JobOffer offer = jobOfferRepository.findById(id).orElseThrow();

        UniversityDTO university = universityClient.findById(offer.getIdUniversity());
        Map<String,Object> response = new HashMap<>();
        response.put("offer",offer);
        response.put("university",university);
        return response;


    }
}
