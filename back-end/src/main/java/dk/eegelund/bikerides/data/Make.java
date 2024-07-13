package dk.eegelund.bikerides.data;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "makes")
public class Make extends BaseEntity {
    @Column(nullable = false)
    private String name;
    private String origin;
    private String website;
    private LocalDate established;
    private String historicalIntroduction;
    @OneToMany(mappedBy = "make", fetch = FetchType.LAZY)
    private Collection<Model> models;
}
