package javathon16.Models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Company {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private int maxBonus;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    Set<Bonus> bonuses = new HashSet<>();

    private Company(){}

    public Company(Long id, String name, int maxBonus){
        this.id = id;
        this.name = name;
        this.maxBonus = maxBonus;
    }

}
