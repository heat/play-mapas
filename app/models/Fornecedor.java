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

    @Column(name = "FORNECEDOR_NASCIMENTO")
    @Temporal(TemporalType.DATE)
    public Date nascimento;

    @OneToOne(mappedBy = "fornecedor")
    public FornecedorComplemento complemento;
}
