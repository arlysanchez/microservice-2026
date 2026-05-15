package pe.edu.upeu.job_ms.services;

import pe.edu.upeu.job_ms.entity.JobOffer;

import java.util.Map;

public interface JobOfferService {
    JobOffer save(JobOffer jobOffer);
    Map<String, Object> getOfferWithUniversity(Long id);


}
