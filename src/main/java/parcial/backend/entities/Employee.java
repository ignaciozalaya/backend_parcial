package parcial.backend.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.AccessLevel;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long employeeId;

    @Column(length = 20, nullable = false)
    String lastName;

    @Column(length = 20, nullable = false)
    String firstName;

    @Column(length = 30)
    String title;

    @ManyToOne
    Employee reportsTo;

    @Column
    LocalDateTime birthDate;

    @Column
    LocalDateTime hireDate;

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

    @Column(length = 60)
    String email;



}
