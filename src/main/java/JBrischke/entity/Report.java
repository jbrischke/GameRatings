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

    /**
     * Instantiates a new Report.
     */
    public Report() {
    }

    /**
     * Instantiates a new Report.
     *
     * @param description the description
     * @param hoursPlayed the hours played
     */
    public Report(String description, int hoursPlayed) {
        this.description = description;
        this.hoursPlayed = hoursPlayed;
    }

    /**
     * Gets report id.
     *
     * @return the report id
     */
    public int getReport_id() {
        return report_id;
    }

    /**
     * Sets report id.
     *
     * @param report_id the report id
     */
    public void setReport_id(int report_id) {
        this.report_id = report_id;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets hours played.
     *
     * @return the hours played
     */
    public int getHoursPlayed() {
        return hoursPlayed;
    }

    /**
     * Sets hours played.
     *
     * @param hoursPlayed the hours played
     */
    public void setHoursPlayed(int hoursPlayed) {
        this.hoursPlayed = hoursPlayed;
    }

    /**
     * Gets game.
     *
     * @return the game
     */
    public Game getGame() {
        return game;
    }

    /**
     * Sets game.
     *
     * @param game the game
     */
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
