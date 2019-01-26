package javathon16.Models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Bonus {

    @Id
    @GeneratedValue
    private Long id;

    private int value;

    private int companyId;

    private int clientId;

    private Bonus(){}

    public Bonus(int companyId, int clientId){

        this.clientId = clientId;
        this.companyId = companyId;
        this.value = 1;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }
}
