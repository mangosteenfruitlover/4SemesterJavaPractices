package main;

import com.fasterxml.jackson.annotation.JsonProperty;

public class University {
    @JsonProperty("name")
    public String name;

    @JsonProperty("creationDate")
    public String creationDate;

    public University() {}

    public void setName(String name) {
        this.name = name;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public University(String name, String creationDate) {
        this.name = name;
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
