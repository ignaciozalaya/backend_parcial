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
@Table(name = Album.TABLE_NAME)
public class Album {
    public static final String TABLE_NAME = "albums";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AlbumId")
    Integer albumId;

    @Column(name="Title", length = 160, nullable = false)
    String title;

    @ManyToOne
    @JoinColumn(name = "ArtistId")
    Artist artist;
}
