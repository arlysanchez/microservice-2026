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
    private String company_name;

    @Column(name = "id_university")
    private Long idUniversity;

    public JobOffer() {
    }

    public JobOffer(Long id, String title, String description, Double salary, String company_name, Long idUniversity) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.salary = salary;
        this.company_name = company_name;
        this.idUniversity = idUniversity;
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

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }
}
