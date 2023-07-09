package com.hotel.hotel.modelo.servicio.impls;

import com.hotel.hotel.configuration.JasperReportManager;
import com.hotel.hotel.modelo.dto.ReporteDto;
import com.hotel.hotel.modelo.servicio.interfaces.ReporteService;
import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.JRException;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ReporteServiceImpl implements ReporteService {
  private final DataSource dataSource;
  private final JasperReportManager reportManager;
  private final ResourceLoader resourceLoader;
  @Override
  public ReporteDto reporteDiarioMoivimiento(Map<String, Object> params) throws IOException {
    String fileName = "reporte_matriculas_detalle";
    ReporteDto dto = new ReporteDto();

    Resource resource = resourceLoader.getResource("classpath:static/assets/images");
    String rutaImagenes = resource.getFile().getAbsolutePath();
    String logo = rutaImagenes+"/logo_madeiro.jpg";

    params.put("logo", logo);


    dto.setFileName(fileName + ".pdf");

    try {
      ByteArrayOutputStream stream = reportManager.compilarAndExportarReporte(
              "HOTEL", "HOTEL",
              params, dataSource.getConnection());
      byte[] bs = stream.toByteArray();
      dto.setStream(new ByteArrayInputStream(bs));
      dto.setLength(bs.length);

      return dto;
    } catch (JRException | IOException | SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
