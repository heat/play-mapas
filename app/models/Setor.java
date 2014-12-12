package models;

import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Setor {

    @Id
    public SetorKey Id;

    @OneToMany(mappedBy = "setor")
    public List<Fornecedor> fornecedor;

    public static Model.Finder<SetorKey, Setor> find = new Model.Finder<>(
            SetorKey.class, Setor.class
    );
}
