package com.napolitano.encurtador_url.Links;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


/*
    O encurtador de URLs recebe uma URL longa como parâmetro inicial.
    O encurtamento será composto por um mínimo de 05 e um máximo de 10 caracteres.
    Apenas letras e números são permitidos no encurtamento.
    A URL encurtada será salva no banco de dados com um prazo de validade (você pode escolher a duração desejada).
    Ao receber uma chamada para a URL encurtada https://xxx.com/DXB6V, você deve fazer o redirecionamento para a URL original salva no banco de dados.
    Caso a URL não seja encontrada no banco, retorne o código de status HTTP 404 (Not Found).
*/

@Service
public class LinkService {

    private final LinkRepository linkRepository;

    public LinkService(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    // Gerar uma URL aleatória
    public String generateSortedUrl() {
        return RandomStringUtils.randomAlphanumeric(5, 10);
    }

    // Encurtar URL
    public Link encurtarUrl(String longUrl) {
        Link link = new Link();
        link.setLongUrl(longUrl);
        link.setShortenedUrl(generateSortedUrl());
        link.setUrlCreatedIn(LocalDateTime.now());
        link.setQrCodeUrl("QR code indisponível no momento");

        return linkRepository.save(link);
    }

    // Obter a URL original a partir da URL encurtada
    public Link obterUrlOriginal(String shortenedUrl) {
        try {
            return  linkRepository.findByShortenedUrl(shortenedUrl);
        } catch (Exception exception){
            throw new RuntimeException("Url not found", exception);
        }

    }
}

