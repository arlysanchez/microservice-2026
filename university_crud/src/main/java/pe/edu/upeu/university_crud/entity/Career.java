package pe.edu.upeu.university_crud.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "career", schema = "university_schema")
public class Career {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 64)
    private String name;
    @Column(nullable = false, length = 32)
    private String area;
    @Column(columnDefinition = "TEXT")
    private String description;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Career career = (Career) o;
        return Objects.equals(id, career.id) &&
                Objects.equals(name, career.name) &&
                Objects.equals(area, career.area) &&
                Objects.equals(description, career.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, area, description);
    }

    @Override
    public String toString() {
        return "Career{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", area='" + area + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
