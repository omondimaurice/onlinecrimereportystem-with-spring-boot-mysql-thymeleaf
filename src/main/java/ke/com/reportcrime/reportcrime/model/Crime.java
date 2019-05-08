package ke.com.reportcrime.reportcrime.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "crime")
public class Crime {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long crime_id;


    @Column(name = "crime_type", nullable = false)
    @Size(max = 25)
    private String crime_type;

    @Column(name = "description", nullable = false)
    @NotEmpty(message = "please give your story, should not be blank")
    private String story;

    @Column(name = "location", nullable = false)
    @NotEmpty(message = "* provide location")
    private String location;

    @Column(name = "reporter", nullable = false)
    @NotEmpty(message = "* provide your name")
    private  String reporter;

    @CreatedDate
    @Column(name = "date_reported", nullable = false)
    private Date datecreated;


    public Crime() {
    }

    public Crime(@Size(max = 25) String crime_type, @NotEmpty(message = "please give your story, should not be blank") String story, @NotEmpty(message = "* provide location") String location, @NotEmpty(message = "* provide your name") String reporter, Date datecreated) {
        this.crime_type = crime_type;
        this.story = story;
        this.location = location;
        this.reporter = reporter;
        this.datecreated = datecreated;
    }

    public Long getCrime_id() {
        return crime_id;
    }

    public void setCrime_id(Long crime_id) {
        this.crime_id = crime_id;
    }

    public String getCrime_type() {
        return crime_type;
    }

    public void setCrime_type(String crime_type) {
        this.crime_type = crime_type;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
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
        return "Crime{" +
                "crime_id=" + crime_id +
                ", crime_type='" + crime_type + '\'' +
                ", story='" + story + '\'' +
                ", location='" + location + '\'' +
                ", reporter='" + reporter + '\'' +
                ", datecreated=" + datecreated +
                '}';
    }
}
