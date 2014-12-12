package models;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class SetorKey {

    @Column
    public Long id;

    @Column
    public Long empresa;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SetorKey setorKey = (SetorKey) o;

        if (!empresa.equals(setorKey.empresa)) return false;
        if (!id.equals(setorKey.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + empresa.hashCode();
        return result;
    }
}
