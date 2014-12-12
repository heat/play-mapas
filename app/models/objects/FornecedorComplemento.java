package models.objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import models.Fornecedor;
import play.db.ebean.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class FornecedorComplemento extends Model {

    @Id
    public Long id;

    @JsonIgnore
    @OneToOne
    public Fornecedor fornecedor;

    @Column
    public String inscricaoEstadual;

    @Column
    public String inscricaoMunicipal;
}
