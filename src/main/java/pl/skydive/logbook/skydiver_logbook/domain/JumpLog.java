package pl.skydive.logbook.skydiver_logbook.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "JUMPLOG")
public class JumpLog {

    @Id
    private Long jumpId;

    @Column(name="JUMP_NUMBER")
    private Long jumpNumber;

    @Column(name="JUMP_DATE")
    private LocalDate jumpDate;

    @Column(name="DROPZONE")
    private String dropZone;

    @Column(name="AIRCRAFT")
    @Enumerated(EnumType.STRING)
    private Aircraft aircraft;

    @Column(name="EQUIPMENT")
    private String equipment;

    @Column(name="FREEFALL_TIME_SECONDS")
    Long freefallTimeSeconds;

    @Column(name="DESCRIPTION")
    String description;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        JumpLog jumpLog = (JumpLog) o;
        return jumpId != null && Objects.equals(jumpId, jumpLog.jumpId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
