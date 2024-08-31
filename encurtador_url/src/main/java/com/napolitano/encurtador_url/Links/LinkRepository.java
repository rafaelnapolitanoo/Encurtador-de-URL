package com.napolitano.encurtador_url.Links;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LinkRepository extends JpaRepository<Link , Long> {

    Link findByLongUrl(String shortenedUrl);

}
