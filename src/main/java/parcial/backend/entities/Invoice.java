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
@Table(name = Invoice.TABLE_NAME)
public class Invoice {
    public static final String TABLE_NAME = "invoices";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long invoiceId;

    @ManyToOne
    Customer customer;

    @Column(nullable = false)
    LocalDateTime invoiceDate;

    @Column(length = 70)
    String billingAddress;

    @Column(length = 40)
    String billingCity;

    @Column(length = 40)
    String billingState;

    @Column(length = 40)
    String billingCountry;

    @Column(length = 10)
    String billingPostalCode;

    @Column(precision = 10, scale = 2, nullable = false)
    Long total;
}
