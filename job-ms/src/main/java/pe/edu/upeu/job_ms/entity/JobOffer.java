package pe.edu.upeu.job_ms.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "job_offer", schema = "jobs_schema")
public class JobOffer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private Double salary;

    @Column(name = "id_university")
    private Long idUniversity;

    public JobOffer() {
    }

    public JobOffer(Long id, Long idUniversity, Double salary, String description, String title) {
        this.id = id;
        this.idUniversity = idUniversity;
        this.salary = salary;
        this.description = description;
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Long getIdUniversity() {
        return idUniversity;
    }

    public void setIdUniversity(Long idUniversity) {
        this.idUniversity = idUniversity;
    }
}
