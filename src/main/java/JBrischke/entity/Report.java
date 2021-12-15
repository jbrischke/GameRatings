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
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int report_id;

    @Column(name = "description")
    private String description;

    @Column(name = "hoursPlayed")
    private int hoursPlayed;

    @ManyToOne
    @JoinColumn(name = "game_id",
            foreignKey = @ForeignKey(name = "report_game_game_id_fk")
    )
    private Game game;

    public Report() {
    }

    public Report(String description, int hoursPlayed) {
        this.description = description;
        this.hoursPlayed = hoursPlayed;
    }

    public int getReport_id() {
        return report_id;
    }

    public void setReport_id(int report_id) {
        this.report_id = report_id;
    }

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

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    @Override
    public String toString() {
        return "Report{" +
                "report_id=" + report_id +
                ", description='" + description + '\'' +
                ", hoursPlayed=" + hoursPlayed +
                ", game=" + game +
                '}';
    }
}
