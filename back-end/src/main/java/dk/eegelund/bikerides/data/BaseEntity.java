package dk.eegelund.bikerides.data;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.Instant;

@Getter
@MappedSuperclass
class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @CreatedDate
    @Column(name = "created_date", updatable = false)
    private Instant createdDate;
    @LastModifiedDate
    @Column(name = "last_modified_date")
    private Instant lastModifiedDate;
}
