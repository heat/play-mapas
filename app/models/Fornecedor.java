package models;

import models.objects.FornecedorComplemento;
import play.db.ebean.Model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by heatd_000 on 11/12/2014.
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("F")
public class Fornecedor extends Model {

    @Id
    FornecedorKey k;

    @Column
    public String nome;

    @OneToOne(mappedBy = "fornecedor")
    public FornecedorComplemento complemento;

    public static Finder<FornecedorKey, Fornecedor> find = new Finder<>(
            FornecedorKey.class, Fornecedor.class
    );
}
