package kurt.project.standardise.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity(name = "standardise_audit")
public class Entry implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long record_id;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, name = "date_time")
    private Date date_time;

    private String term;
    private String standardisation_method;
    private String output_term;

    public long getRecord_id() {
        return record_id;
    }

    public void setRecord_id(long record_id) {
        this.record_id = record_id;
    }

    public Date getDate_time() {
        return date_time;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getStandardisation_method() {
        return standardisation_method;
    }

    public void setStandardisation_method(String standardisation_method) {
        this.standardisation_method = standardisation_method;
    }

    public String getOutput_term() {
        return output_term;
    }

    public void setOutput_term(String output_term) {
        this.output_term = output_term;
    }

    @Override
    public String toString(){

        StringBuilder sb = new StringBuilder();

        return sb.append(record_id)
                .append(" | ")
                .append(date_time)
                .append(" | ")
                .append(term)
                .append(" | ")
                .append(standardisation_method)
                .append(" | ")
                .append(output_term)
                .toString();
    }

}
