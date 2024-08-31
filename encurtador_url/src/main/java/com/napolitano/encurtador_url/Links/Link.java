package com.napolitano.encurtador_url.Links;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "links")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Link {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String longUrl;
    private String shortenedUrl;
    private String qrCodeUrl;
    private LocalDateTime urlCreatedIn;


    // contrutores



    // getters
    public LocalDateTime getUrlCreatedIn() {
        return urlCreatedIn;
    }

    public String getQrCodeUrl() {
        return qrCodeUrl;
    }

    public String getShortenedUrl() {
        return shortenedUrl;
    }

    public String getLongUrl() {
        return longUrl;
    }

    public Long getId() {
        return id;

    }



    // setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }

    public void setShortenedUrl(String shortenedUrl) {
        this.shortenedUrl = shortenedUrl;
    }

    public void setQrCodeUrl(String qrCodeUrl) {
        this.qrCodeUrl = qrCodeUrl;
    }

    public void setUrlCreatedIn(LocalDateTime urlCreatedIn) {
        this.urlCreatedIn = urlCreatedIn;
    }
}
