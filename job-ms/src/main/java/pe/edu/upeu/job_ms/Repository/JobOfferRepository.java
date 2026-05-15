package pe.edu.upeu.job_ms.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upeu.job_ms.entity.JobOffer;

public interface JobOfferRepository extends JpaRepository<JobOffer, Long> {
}
