package model.planner.user;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Model class which represents a company.
 *
 * @author Stefan Pamparau
 */
@Entity
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String registrationNumber;
    private String name;
    private Timestamp creationDate;

    @OneToMany(mappedBy = "company", fetch = FetchType.EAGER)
    private Set<Employee> employees;
}
