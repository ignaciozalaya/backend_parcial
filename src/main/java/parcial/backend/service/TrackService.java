package parcial.backend.service;

import parcial.backend.entities.*;

public interface TrackService extends Service<Track, Integer> {
    Track create(String name,
                 String albumName,
                 String mediaTypeName,
                 String genreName,
                 String composer,
                 Integer milliseconds,
                 Integer bytes,
                 Long unitPrice);

    public void update(Integer id,
                       String name,
                       String albumName,
                       String mediaTypeName,
                       String genreName,
                       String composer,
                       Integer milliseconds,
                       Integer bytes,
                       Long unitPrice);
}