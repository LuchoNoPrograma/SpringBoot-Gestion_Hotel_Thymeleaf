package com.hotel.hotel.controlador;

import com.hotel.hotel.modelo.dto.ReporteDto;
import com.hotel.hotel.modelo.servicio.interfaces.ReporteService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Controller
@RequestMapping("/informe")
public class ReporteController {
  private final ReporteService reporteService;

  @GetMapping("/movimiento-diario")
  public ResponseEntity<?> descargarInformeMovimiento(){
    Map<String, Object> params = new HashMap<>();
    params.put("fechaHoy", LocalDate.now().toString());

    ReporteDto dto;
    try {
      dto = reporteService.reporteDiarioMoivimiento(params);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    InputStreamResource streamResource = new InputStreamResource(dto.getStream());
    MediaType mediaType = MediaType.APPLICATION_PDF;

    return ResponseEntity.ok().header("Content-Disposition", "inline; filename=\\\""+dto.getFileName()+ "\\")
            .contentLength(dto.getLength()).contentType(mediaType).body(streamResource);
  }
}
