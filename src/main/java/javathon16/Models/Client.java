package javathon16.Models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Client {

    @Id
    @GeneratedValue
    private Long id;

    public int phoneNumber;

    public String name;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    Set<Bonus> bonuses = new HashSet<>();

    private Client(){}

    public Client(int phoneNumber, String name){
        this.phoneNumber = phoneNumber;
        this.name = name;
    }

}
