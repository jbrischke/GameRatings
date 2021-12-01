package JBrischke.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * The type Report.
 */
@Entity(name = "Report")
@Table(name = "report")
public class Report {
    @Id
    @Column(name = "category_id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int report_id;

    @Column(name = "description")
    private String description;

    @Column(name = "hoursPlayed")
    private int hoursPlayed;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getHoursPlayed() {
        return hoursPlayed;
    }

    public void setHoursPlayed(int hoursPlayed) {
        this.hoursPlayed = hoursPlayed;
    }


    @Override
    public String toString() {
        return "Report{" +
                "report_id=" + report_id +
                ", description='" + description + '\'' +
                ", hoursPlayed=" + hoursPlayed +
                '}';
    }
}
