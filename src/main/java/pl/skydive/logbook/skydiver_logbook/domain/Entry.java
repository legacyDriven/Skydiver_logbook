package pl.skydive.logbook.skydiver_logbook.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Entry {
    String name;
    String surname;
}
