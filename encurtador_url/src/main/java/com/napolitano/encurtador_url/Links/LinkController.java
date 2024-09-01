package com.napolitano.encurtador_url.Links;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
@RestController
@RequestMapping("/encurtar")
public class LinkController {

    private final LinkService linkService;

    public LinkController(LinkService linkService) {
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

    @GetMapping("/r/{shortenedUrl}")
    public void redirectLink(@PathVariable String shortenedUrl, HttpServletResponse response) throws Exception {
        Link link = linkService.obterUrlOriginal(shortenedUrl);

        if (link != null) {
            response.sendRedirect(link.getLongUrl()); // Redirecionar para a URL longa
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}

