package models;

import play.db.ebean.Model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by heatd_000 on 10/12/2014.
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn()
public class Pessoa  extends Model {

    @Id
    public Long id;

    @Column
    public String nome;

    @OneToOne(mappedBy = "pessoa")
    @JoinColumn(name = "id")
    public Perfil perfil;


    @OneToMany(mappedBy = "pessoa")
    public List<Contato> contatos;

    public static Finder<Long, Pessoa> find = new Finder<>(
            Long.class, Pessoa.class
    );
}
