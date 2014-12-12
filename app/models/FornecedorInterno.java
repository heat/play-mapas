package models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Created by heatd_000 on 12/12/2014.
 */
@Entity
@DiscriminatorValue("I")
public class FornecedorInterno extends  Fornecedor {

    @ManyToOne
    public Setor setor;
}
