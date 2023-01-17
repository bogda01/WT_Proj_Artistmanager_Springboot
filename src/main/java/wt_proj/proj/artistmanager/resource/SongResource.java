package wt_proj.proj.artistmanager.resource;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wt_proj.proj.artistmanager.model.Artist;
import wt_proj.proj.artistmanager.model.Song;
import wt_proj.proj.artistmanager.service.SongService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/song")
@Slf4j
public class SongResource {

    private final SongService songService;

    public SongResource(SongService songService){this.songService=songService;}

    @GetMapping("/all")
    public ResponseEntity<List<Song>> getAllSongs (@RequestParam(required = false)Optional<Integer> id) {
        List<Song> songs;
        if(id.isPresent()){
            songs=songService.findAllForArtist(id.get().longValue());
        }
        else {
            songs=songService.findAllSongs();
        }
        return new ResponseEntity<>(songs,HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Song>postSong(@RequestBody Song song){
        Song newSong=songService.addSong(song);
        return new ResponseEntity<>(newSong,HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Song> updateSong(@RequestBody Song song) {
        Song updateSong = songService.updateSong(song);
        return new ResponseEntity<>(updateSong, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Song> getSongById (@PathVariable("id") Long id) {
        Song song = songService.findSongById(id);
        return new ResponseEntity<>(song, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteSong(@PathVariable("id") Long id) {
        songService.deleteSong(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
