package wt_proj.proj.artistmanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import wt_proj.proj.artistmanager.model.Song;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface SongRepo extends JpaRepository<Song,Long> {
    Optional<Song> findSongById(Long id);

     void deleteSongById(Long id);


}
