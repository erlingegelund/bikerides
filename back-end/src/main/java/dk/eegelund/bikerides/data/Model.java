package dk.eegelund.bikerides.data;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "makes")
public class Model extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "make_id", nullable = false)
    private Make make;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @Column(nullable = false)
    private String name;
    private String shortName;
    @Column(name = "year_from")
    private Integer yearFrom;
    @Column(name = "year_to")
    private Integer yearTo;
    @Column(name = "dry_weight")
    private Integer dryWeight;
    @Column(name = "wet_weight")
    private Integer wetWeight;
    @Column(name = "seat_height")
    private Integer seatHeight;
    @Column(name = "engine_capacity")
    private Integer engineCapacity;
    @Column(name = "engine_power")
    private Integer enginePower;
    @Column(name = "engine_torque")
    private Integer engineTorque;
    @Column(name = "top_speed")
    private Integer topSpeed;
    @Column(name = "fuel_capacity")
    private Integer fuelCapacity;
    @Column(name = "fuel_consumption")
    private Integer fuelConsumption;
    @Column(name = "wheelbase")
    private Integer wheelbase;
    @Column(name = "overall_length")
    private Integer overallLength;
    @Column(name = "homologated_for_road_use")
    private boolean homologatedForRoadUse;
}
