package models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Created by heatd_000 on 11/12/2014.
 */
@Entity
public class Contato extends Model {

    @Id
    public Long id;

    public String nome;

    public String telefone;

    @JsonIgnore
    @ManyToOne
    public Pessoa pessoa;
}
