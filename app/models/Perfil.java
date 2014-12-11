package models;

import play.db.ebean.Model;

import javax.persistence.*;

@Entity
public class Perfil extends Model {

    @Id
    Long id;

    @OneToOne
    Pessoa pessoa;

    @Column
    String endereco;

    public static Model.Finder<Long, Perfil> find = new Model.Finder<Long,Perfil>(
            Long.class, Perfil.class );

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
