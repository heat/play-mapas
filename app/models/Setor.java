package models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import play.db.ebean.Model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Setor extends Model {

    @EmbeddedId
    public SetorKey id;

    @JsonBackReference
    @OneToMany(mappedBy = "setor")
    public List<FornecedorInterno> fornecedores;

    public static Model.Finder<SetorKey, Setor> find = new Model.Finder<>(
            SetorKey.class, Setor.class
    );
}
