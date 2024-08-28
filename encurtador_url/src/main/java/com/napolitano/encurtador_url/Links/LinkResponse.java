package com.napolitano.encurtador_url.Links;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LinkResponse {

    private Long id;

    private String longUrl;
    private String shortenedUrl;
    private String qrCodeUrl;
    private LocalDateTime urlCreatedIn;
}
