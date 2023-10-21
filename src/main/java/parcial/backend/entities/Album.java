package parcial.backend.entities;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "albums")
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AlbumId")
    Long albumId;

    @Column(name="Title", length = 160, nullable = false)
    String title;

    @ManyToOne
    @JoinColumn(name = "ArtistId")
    Artist artist;
}
