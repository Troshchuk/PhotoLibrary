package com.troshchuk.photoLibrary.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Dmytro Troshchuk
 * @version 1.00  18.08.14.
 */

@Entity
@Table(name = "Photos")
public class Photo {
    @Id
    @Column(name = "photo_id")
    private long photoId;

    private String source;

    public Photo() {
    }

    public Photo(String source) {
        this.source = source;
    }

    public long getPhotoId() {
        return photoId;
    }

    public void setPhotoId(long photoId) {
        this.photoId = photoId;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
