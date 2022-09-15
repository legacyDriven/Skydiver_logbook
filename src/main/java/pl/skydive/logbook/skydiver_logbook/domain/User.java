package pl.skydive.logbook.skydiver_logbook.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
class User {

    private long id;

    private String firstName;

    private String lastName;

}
