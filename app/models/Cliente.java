package models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
 * Created by heatd_000 on 11/12/2014.
 */
@Entity
@DiscriminatorValue("C")
public class Cliente extends Pessoa
{
    @Temporal(TemporalType.DATE)
    Date nascimento;

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }
}
