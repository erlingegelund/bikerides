package dk.eegelund.bikerides.data;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "rides")
public class Ride extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "model_id", nullable = false)
    private Model model;
    @Column(name = "started_at", nullable = false)
    private Instant startedAt;
    @Column(name = "ended_at")
    private Instant endedAt;
    private Integer distance;
    private boolean own;
    private String comment;
    private Integer rating;
}
