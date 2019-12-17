package vn.elite.haru.employee;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;

@Data
@Entity
@NoArgsConstructor
public class Employee {

    private @Id @GeneratedValue Long id;

    private String firstName;
    private String lastName;
    private String description;

    private @Version @JsonIgnore Long version;

    public Employee(String firstName, String lastName, String description) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.description = description;
    }
}