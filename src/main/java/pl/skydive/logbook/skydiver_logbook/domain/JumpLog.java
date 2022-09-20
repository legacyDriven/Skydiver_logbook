package pl.skydive.logbook.skydiver_logbook.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
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
    @Enumerated(EnumType.ORDINAL)
    private Aircraft aircraft;

    @Column(name="EQUIPMENT")
    private String equipment;

    @Column(name="FREEFALL_TIME_SECONDS")
    Long freefallTimeSeconds;

    @Column(name="DESCRIPTION")
    String description;
}
