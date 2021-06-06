package main.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "university")
    private List<Student> students = new ArrayList<>();

    public University() { }

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

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "University{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", creationDate='" + creationDate + '\'' +
                ", students=" + students +
                '}';
    }
}
