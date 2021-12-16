package JBrischke.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.HashSet;
import java.util.Set;

/**
 * The type Game.
 */
@Entity(name = "Game")
@Table(name = "game")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @NotNull
    @Column(name = "gameURL")
    private String gameURL;

    @NotNull
    @Column(name = "name")
    private String name;

    @Column(name = "apiName")
    private String apiName;

    @NotNull
    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Report> reports = new HashSet<>();

    /**
     * Instantiates a new Game.
     */
    public Game() {
    }

    /**
     * Instantiates a new Game.
     *
     * @param gameURL     the game url
     * @param name        the name
     * @param apiName     the api name
     * @param description the description
     */
    public Game(String gameURL, String name, String apiName, String description) {
        this.gameURL = gameURL;
        this.name = name;
        this.apiName = apiName;
        this.description = description;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets game url.
     *
     * @return the game url
     */
    public String getGameURL() {
        return gameURL;
    }

    /**
     * Sets game url.
     *
     * @param gameURL the game url
     */
    public void setGameURL(String gameURL) {
        this.gameURL = gameURL;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets api name.
     *
     * @return the api name
     */
    public String getApiName() {
        return apiName;
    }

    /**
     * Sets api name.
     *
     * @param apiName the api name
     */
    public void setApiName(String apiName) {
        this.apiName = apiName;
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
     * Gets reports.
     *
     * @return the reports
     */
    public Set<Report> getReports() {
        return reports;
    }

    /**
     * Sets reports.
     *
     * @param reports the reports
     */
    public void setReports(Set<Report> reports) {
        this.reports = reports;
    }

    /**
     * Add report.
     *
     * @param report the report
     */
    public void addReport(Report report) {
        reports.add(report);
        report.setGame(this);
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", gameURL='" + gameURL + '\'' +
                ", name='" + name + '\'' +
                ", apiName='" + apiName + '\'' +
                ", description='" + description + '\'' +
                ", reports=" + reports +
                '}';
    }
}
