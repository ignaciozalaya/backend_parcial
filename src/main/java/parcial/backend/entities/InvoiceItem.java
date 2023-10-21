package parcial.backend.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
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
public class InvoiceItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long invoiceLineId;

    @ManyToOne
    Invoice invoice;

    @ManyToOne
    Track track;

    @Column(nullable = false)
    Long unitPrice;

    @Column(nullable = false)
    Integer quantity;
}
