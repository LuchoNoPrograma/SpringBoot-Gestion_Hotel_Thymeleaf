package com.hotel.hotel.controlador;

import com.hotel.hotel.modelo.entidad.Persona;
import com.hotel.hotel.modelo.servicio.interfaces.IPersonaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/persona")
@RequiredArgsConstructor
@Log4j2
public class PersonaApi {
  private final IPersonaService personaService;

  @GetMapping("/pageable")
  public ResponseEntity<?> buscarPersonasPorQuery(@RequestParam("q") String query, @RequestParam(value="page", defaultValue = "0") int page) {
    Pageable pageable = PageRequest.of(page, 10);
    Page<Persona> personasPage = personaService.findAllDistinctEliminado(query, pageable);


    personasPage.getContent().forEach(p -> {
      log.info(p.getNombreCompleto()+" - "+p.getDocumentoIdentidad());
    });

    Map<String, Object> response = new HashMap<>();
    response.put("results", personasPage.getContent());
    response.put("pagination", Map.of("more", personasPage.hasNext()));
    return ResponseEntity.ok().body(response);
  }
}
