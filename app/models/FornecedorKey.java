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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FornecedorKey that = (FornecedorKey) o;

        if (!id.equals(that.id)) return false;
        if (!tipo.equals(that.tipo)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + tipo.hashCode();
        return result;
    }
}
