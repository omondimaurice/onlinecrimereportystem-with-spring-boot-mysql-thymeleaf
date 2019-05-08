package ke.com.reportcrime.reportcrime.model;


import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "incidence")
public class Incidence {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long incidence_id;



    @Column(name = "incidence_type", nullable = false)
    @NotEmpty(message = "* incident type should not be blank such as fire,accidents, floods etc")
    @Size(max = 25)
    private String incident_type;

    @Column(name = "description", nullable = false)
    @NotEmpty(message = "please give your story, should not be blank")
    private String description;

    @Column(name = "location", nullable = false)
    @NotEmpty(message = "* provide location")
    private String location;

    @Column(name = "reporter", nullable = false)
    @NotEmpty(message = "* provide your name")
    private  String reporter;

    @CreatedDate
    @Column(name = "date_reported", nullable = false)
    private Date datecreated;

    public Incidence() {
    }


    public Incidence(@NotEmpty(message = "* incident type should not be blank such as fire,accidents, floods etc") @Size(max = 25) String incident_type, @NotEmpty(message = "please give your story, should not be blank") String description, @NotEmpty(message = "* provide location") String location, @NotEmpty(message = "* provide your name") String reporter, Date datecreated) {
        this.incident_type = incident_type;
        this.description=description;
        this.location = location;
        this.reporter = reporter;
        this.datecreated = datecreated;
    }

    public Long getIncidence_id() {
        return incidence_id;
    }

    public void setIncidence_id(Long incidence_id) {
        this.incidence_id = incidence_id;
    }

    public String getIncident_type() {
        return incident_type;
    }

    public void setIncident_type(String incident_type) {
        this.incident_type = incident_type;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getReporter() {
        return reporter;
    }

    public void setReporter(String reporter) {
        this.reporter = reporter;
    }

    public Date getDatecreated() {
        return datecreated;
    }

    public void setDatecreated(Date datecreated) {
        this.datecreated = datecreated;
    }

    @Override
    public String toString() {
        return "Incidence{" +
                "incidence_id=" + incidence_id +
                ", incident_type='" + incident_type + '\'' +
                ", description='" + description + '\'' +
                ", location='" + location + '\'' +
                ", reporter='" + reporter + '\'' +
                ", datecreated=" + datecreated +
                '}';
    }
}

