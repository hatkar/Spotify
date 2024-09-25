package com.hatkar.spotifybackend.catalogueContext.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "song_Content")
public class SongContent implements Serializable {

    @Id
    @Column(name = "song_id")
    private Long songId;

    @MapsId
    @OneToOne
    @JoinColumn(name = "songId",referencedColumnName = "id")
    private Song song;

    @Lob
    @Column(name = "file",nullable = false)
    private byte[] file;

    @Column(name="file_Content_Type")
    private String fileContentType;

    public Long getSongId() {
        return songId;
    }

    public Song getSong() {
        return song;
    }

    public byte[] getFile() {
        return file;
    }

    public String getFileContentType() {
        return fileContentType;
    }
}
