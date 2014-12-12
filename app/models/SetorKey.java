package models;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class SetorKey {

    @Column
    public Long id;

    @Column
    public Long empresa;
}
