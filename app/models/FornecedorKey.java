package models;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class FornecedorKey {

    @Column
    public Long id;

    @Column
    public final Long tipo = 1L;

    public FornecedorKey(Long id) {
        this.id = id;
    }
}
