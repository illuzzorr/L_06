package models;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "games")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;
    private int price;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "developer_id")
    private Developer developer;

    public Game() {
    }

    public Game(String name, int price) {
        this.name = name;
        this.price = price;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Developer getDeveloper() {
        return developer;
    }

    public void setDeveloper(Developer developer) {
        this.developer = developer;
    }

    public int getDevId(){ return developer.getId(); }
    @Override
    public String toString() {
        return "models.Game{" +
                "id=" + id +
                ", name='" + name +
                ", price=" + price +
                ", developer=" + developer +
                "}\n";
    }
}