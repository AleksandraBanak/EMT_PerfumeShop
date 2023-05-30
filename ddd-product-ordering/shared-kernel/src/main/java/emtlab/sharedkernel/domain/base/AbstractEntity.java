package emtlab.sharedkernel.domain.base;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NonNull;

import java.util.Objects;

@MappedSuperclass
@Getter
public class AbstractEntity<ID extends DomainObjectId> {

    @EmbeddedId
    private ID id;


    protected AbstractEntity() {
    }

    protected AbstractEntity(@NonNull AbstractEntity<ID> source) {
        Objects.requireNonNull(source, "source must not be null");
        this.id = source.id;
    }

    protected AbstractEntity(@NonNull ID id) {
        this.id = Objects.requireNonNull(id, "id must not be null");
    }

    @Override
    public int hashCode() {
        return id == null ? super.hashCode() : id.hashCode();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractEntity<?> that = (AbstractEntity<?>) o;
        return Objects.equals(id, that.id);
    }


}
