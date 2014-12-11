package models;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by heatd_000 on 11/12/2014.
 */
@Entity
@DiscriminatorValue("F")
public class Fornecedor extends Pessoa {

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    @Column(name = "FORNECEDOR_NASCIMENTO")
    @Temporal(TemporalType.DATE)
    Date nascimento;
}
