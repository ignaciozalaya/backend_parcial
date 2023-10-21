package parcial.backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.AccessLevel;

import java.time.LocalDateTime;

@Entity
@Table(name = Customer.TABLE_NAME)
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Customer {

    public static final String TABLE_NAME = "customers";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(length = 40, nullable = false)
    String firstName;

    @Column(length = 20, nullable = false)
    String lastName;

    @Column(length = 80)
    String company;

    @Column(length = 70)
    String address;

    @Column(length = 40)
    String city;

    @Column(length = 40)
    String state;

    @Column(length = 40)
    String country;

    @Column(length = 10)
    String postalCode;

    @Column(length = 24)
    String phone;

    @Column(length = 24)
    String fax;

    @Column(length = 60, nullable = false)
    String email;

    @ManyToOne
    @JoinColumn(name = "SupportRepId")
    Employee supportRep;

}
