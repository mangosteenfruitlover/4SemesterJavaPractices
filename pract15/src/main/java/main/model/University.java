package main.model;


import javax.persistence.*;

@Entity
@Table(name = "universities")
public class University {
    @Id
    @SequenceGenerator(name = "university_seq", sequenceName = "universities_sequence", allocationSize = 1)
    @GeneratedValue(generator = "university_seq", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "name1")
    private String name;
    @Column(name = "creation_date")
    private String creationDate;

    public University() {}

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

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "University{" +
                "name='" + name + '\'' +
                ", creationDate='" + creationDate + '\'' +
                '}';
    }
}
