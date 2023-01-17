package wt_proj.proj.artistmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wt_proj.proj.artistmanager.exception.UserNotFoundException;
import wt_proj.proj.artistmanager.model.Song;
import wt_proj.proj.artistmanager.repo.SongRepo;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class SongService {

    private final SongRepo songRepo;

    @Autowired
    public SongService(SongRepo songRepo) {
        this.songRepo = songRepo;
    }

    public Song addSong(Song song) {
        return songRepo.save(song);
    }

    public List<Song> findAllSongs() {
        return songRepo.findAll();
    }

    public Song updateSong(Song song) {
        return songRepo.save(song);
    }

    public Song findSongById(Long songId) {
        return songRepo.findSongById(songId)
                .orElseThrow(() -> new UserNotFoundException("Song by id " + songId + " was not found"));
    }

    public void deleteSong(Long id){
        songRepo.deleteSongById(id);
    }

    public List<Song> findAllForArtist(long artistId) {
        return songRepo.findAll().stream()
                .filter(r->r.getArtist().getId().equals(artistId))
                .collect(Collectors.toList());
    }
}
