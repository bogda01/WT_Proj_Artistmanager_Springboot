package wt_proj.proj.artistmanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import wt_proj.proj.artistmanager.model.Artist;

import java.util.Optional;

public interface ArtistRepo extends JpaRepository<Artist, Long> {
    void deleteArtistById(Long id);

    Optional<Artist> findArtistById(Long id);
}
