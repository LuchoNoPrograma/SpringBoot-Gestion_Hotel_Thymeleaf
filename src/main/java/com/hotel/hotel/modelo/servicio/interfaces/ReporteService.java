package com.hotel.hotel.modelo.servicio.interfaces;

import com.hotel.hotel.modelo.dto.ReporteDto;

import java.io.IOException;
import java.util.Map;

public interface ReporteService {
  ReporteDto reporteDiarioMoivimiento(Map<String, Object> params) throws IOException;
}
