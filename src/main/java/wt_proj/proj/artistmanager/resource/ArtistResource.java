package wt_proj.proj.artistmanager.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wt_proj.proj.artistmanager.model.Artist;
import wt_proj.proj.artistmanager.service.ArtistService;

import java.util.List;

@RestController
@RequestMapping("/artist")
public class ArtistResource {
    private final ArtistService artistService;

    public ArtistResource(ArtistService artistService) {
        this.artistService = artistService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Artist>> getAllArtists () {
        List<Artist> artists = artistService.findAllArtists();
        return new ResponseEntity<>(artists, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Artist> getArtistById (@PathVariable("id") Long id) {
        Artist artist = artistService.findArtistById(id);
        return new ResponseEntity<>(artist, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Artist> addArtist(@RequestBody Artist artist) {
        Artist newArtist = artistService.addArtist(artist);
        return new ResponseEntity<>(newArtist, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Artist> updateArtist(@RequestBody Artist artist) {
        Artist updateArtist = artistService.updateArtist(artist);
        return new ResponseEntity<>(updateArtist, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteArtist(@PathVariable("id") Long id) {
        artistService.deleteArtist(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
