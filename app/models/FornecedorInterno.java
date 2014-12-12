package models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Created by heatd_000 on 12/12/2014.
 */
@Entity
@DiscriminatorValue("I")
public class FornecedorInterno extends  Fornecedor {

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name="setor_id", referencedColumnName = "id"),
            @JoinColumn(name="setor_empresa", referencedColumnName = "empresa")
    })
    public Setor setor;
}
