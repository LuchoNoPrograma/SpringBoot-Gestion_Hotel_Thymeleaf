package com.hotel.hotel.configuration;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleXlsxReportConfiguration;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Map;

@Component
public class JasperReportManager {
  private static final String REPORT_FOLDER = "reportes";
  private static final String JRXML = ".jrxml";
  private static final String JASPER = ".jasper";
  private static boolean alreadySetup = false;


  /**
   * @author <a href="mailto:4softwaredevelopers@gmail.com">Jordy Rodríguezr</a>
   * @date 17 sep. 2021
   * @description
   * @HU_CU_REQ
   * @param fileName
   * @param tipoReporte
   * @param params
   * @param ds
   * @return
   * @throws JRException
   * @throws IOException
   */

  /**
   * Validacion de que si esta apagado el server vuelva a compilar los reportes, caso contrario no se compilara
   * Se usa para poder actualizar reportes en caso de que se requiera
   */
  @EventListener(ApplicationReadyEvent.class)
  public void initializeReCompileReports(){
    if(alreadySetup) {
      return;
    }
    alreadySetup = true;
  }


  public ByteArrayOutputStream compilarAndExportarReporte(String original, String compilado, Map<String, Object> params, Connection con) throws IOException, JRException {
    ByteArrayOutputStream stream = new ByteArrayOutputStream();
    ClassPathResource resource = new ClassPathResource(REPORT_FOLDER + File.separator + original + JRXML);

    InputStream reportStream = resource.getInputStream();

    JasperReport jasperReport = JasperCompileManager.compileReport(reportStream);

    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, con);
    JasperExportManager.exportReportToPdfStream(jasperPrint, stream);
    return stream;
  }
}
