package wt_proj.proj.artistmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wt_proj.proj.artistmanager.exception.UserNotFoundException;
import wt_proj.proj.artistmanager.model.Artist;
import wt_proj.proj.artistmanager.repo.ArtistRepo;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class ArtistService {
    private final ArtistRepo artistRepo;

    @Autowired
    public ArtistService(ArtistRepo artistRepo) {
        this.artistRepo = artistRepo;
    }

    public Artist addArtist(Artist artist) {
        return artistRepo.save(artist);
    }

    public List<Artist> findAllArtists() {
        return artistRepo.findAll();
    }

    public Artist updateArtist(Artist artist) {
        return artistRepo.save(artist);
    }

    public Artist findArtistById(Long id) {
        return artistRepo.findArtistById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }

    public void deleteArtist(Long id){
        artistRepo.deleteArtistById(id);
    }
}
