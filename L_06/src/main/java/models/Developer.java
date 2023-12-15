package models;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "developers")
public class Developer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    private int employeesNumber;

    @OneToMany(mappedBy = "developer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Game> games;

    public Developer() {
    }

    public Developer(String name, int employeesNumber) {
        this.name = name;
        this.employeesNumber = employeesNumber;
        games = new ArrayList<>();
    }

    public void addGame(Game game) {
        game.setDeveloper(this);
        games.add(game);
    }

    public void removeDeveloper(Developer developer) {
        games.remove(developer);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEmployeesNumber() {
        return employeesNumber;
    }

    public void setEmployeesNumber(int employeesNumber) {
        this.employeesNumber = employeesNumber;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

    @Override
    public String toString() {
        return "models.Developer{" +
                "id=" + id +
                ", name='" + name +
                ", employeesNumber=" + employeesNumber +
                "}\n";
    }
}