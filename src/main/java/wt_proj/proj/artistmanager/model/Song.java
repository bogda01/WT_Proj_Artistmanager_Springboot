package wt_proj.proj.artistmanager.model;


import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Song implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "song_id",nullable = false)
    private Long id;

    @Column(name = "songName")
    private String songName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    @ToString.Exclude
    private Artist artist;

    public Song(){}

    public Song(Long id, String songName, Artist artist) {
        this.id = id;
        this.songName = songName;
        this.artist = artist;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long songId) {
        this.id = songId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }
}
