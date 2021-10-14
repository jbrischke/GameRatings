package entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * The type Report.
 */
@Entity(name = "Report")
@Table(name = "reports")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    private String description;

    @ManyToOne
    private Game game;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
                "id=" + id +
                ", description='" + description + '\'' +
                ", game=" + game +
                '}';
    }
}
