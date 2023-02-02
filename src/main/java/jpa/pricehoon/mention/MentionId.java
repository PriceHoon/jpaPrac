package jpa.pricehoon.mention;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MentionId implements Serializable {

    private Long user;
    private Long thread;


    @Override
    public int hashCode() {
        return Objects.hash(getUser(), getThread());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        MentionId mentionId = (MentionId) obj;
        return Objects.equals(getUser(), mentionId.getUser()) && Objects.equals(getThread(), mentionId.getThread());
    }
}
