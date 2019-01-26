package javathon16.Models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Bonus {

    @Id
    @GeneratedValue
    private Long id;

    public int value;

    private Bonus(){}

    public Bonus(int value){
        this.value = value;
    }

}
