package parcial.backend.entities;


import jakarta.persistence.*;
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
@Table(name = InvoiceItem.TABLE_NAME)
public class InvoiceItem {
    public static final String TABLE_NAME = "invoice_items";
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
