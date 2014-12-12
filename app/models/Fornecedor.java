package models;

import models.objects.FornecedorComplemento;

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

    @OneToOne(mappedBy = "fornecedor")
    @JoinColumn(name = "id", referencedColumnName = "fornecedor_id")
    private FornecedorComplemento complemento;

    public FornecedorComplemento getComplemento() {
        return complemento;
    }

    public void setComplemento(FornecedorComplemento complemento) {
        this.complemento = complemento;
    }
}
