package javathon16.Models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Client {

    @Id
    @GeneratedValue
    private int id;

    private int phoneNumber;

    private String name;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Bonus> bonuses;

    private Client(){}

    public Client(int phoneNumber, String name){
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.bonuses = new HashSet<>();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addBonus(Bonus bonus){
        this.bonuses.add(bonus);
    }

    public Set<Bonus> getBonuses() {
        return bonuses;
    }
}
