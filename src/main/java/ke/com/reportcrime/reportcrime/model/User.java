package ke.com.reportcrime.reportcrime.model;


import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

//enabling auditing @CreateDate, @CreatedBy, @
@EntityListeners(AuditingEntityListener.class)
@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "email", nullable = false)
    @Email(message = "*Please provide a valid Email")
    @NotEmpty(message = "*Please provide an email")
    private String email;

    @Column(name = "firstName", nullable = false)
    @NotEmpty(message = "*Please provide your firstname")
    private String firstname;

    @Column(name = "lastName",nullable = false)
    @NotEmpty(message = "*Please provide your lastname")
    private String lastname;

    @Column(name = "nationalId", nullable = false)
  @NotNull(message = "provide your national ID  number")
    private int nationalId;

    @Column(name = "address", nullable = false)
    @NotEmpty(message = "*Please provide your physical address e.g 40109 Sondu")
    private String address;

    @Column(name = "password", nullable = false)
    @Length(min = 5, message = "*Your password must have at least 5 characters")
    @NotEmpty(message = "*Please provide your password")
    private String password;

    @Column(name = "registrationDate", nullable = false)
    @CreatedDate
    private Date datecreated;

    @Column(name = "active")
    private int active;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public User() {
    }

    public User(@Email(message = "*Please provide a valid Email") @NotEmpty(message = "*Please provide an email") String email, @NotEmpty(message = "*Please provide your firstname") String firstname, @NotEmpty(message = "*Please provide your lastname") String lastname, @NotEmpty(message = "*Please provide your national Identification number") int nationalId, @NotEmpty(message = "*Please provide your physical address e.g 40109 Sondu") String address, @Length(min = 5, message = "*Your password must have at least 5 characters") @NotEmpty(message = "*Please provide your password") String password, Date datecreated, int active, Set<Role> roles) {
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.nationalId = nationalId;
        this.address = address;
        this.password = password;
        this.datecreated = datecreated;
        this.active = active;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }


    public Integer getNationalId() {
        return nationalId;
    }

    public void setNationalId(Integer nationalId) {
        this.nationalId = nationalId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDatecreated() {
        return datecreated;
    }

    public void setDatecreated(Date datecreated) {
        this.datecreated = datecreated;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }


}
