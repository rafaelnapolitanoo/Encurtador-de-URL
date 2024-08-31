package com.napolitano.encurtador_url.Links;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/encurtar_link")
public class LinkController {

    private LinkService linkService;
    public LinkController(LinkService linkService){
        this.linkService = linkService;
    }

    @PostMapping
    public ResponseEntity<LinkResponse> gerarUrlEncurtada(@RequestBody Map<String, String> request) {

        String longUrl = request.get("longUrl");
        Link link = linkService.encurtarUrl(longUrl);

        String gerarUrlDeRedirecionamentoDoUsuario = "http://localhost:8080/r/" + link.getShortenedUrl();

        LinkResponse response = new LinkResponse(
                link.getId(),
                link.getLongUrl(),
                gerarUrlDeRedirecionamentoDoUsuario,
                link.getQrCodeUrl(),
                link.getUrlCreatedIn()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
