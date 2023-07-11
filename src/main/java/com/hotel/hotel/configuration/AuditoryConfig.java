package com.hotel.hotel.configuration;


import com.hotel.hotel.modelo.entidad.Auditoria;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

/**
 * @EnableJpaAuditing permite detectar toda transaction de guardar o modificar
 *                    auditorAwareRef = "nombreDelBean"
 *                    donde entra en escena la Super Clase ->
 * @see Auditoria con la anotacion
 * @EntityListeners (AuditingEntityListener.class)
 *
 * @author Luis Alberto Morales Villaca
 * @since 3/26/2023
 */
@Configuration
//@EnableJpaAuditing(auditorAwareRef = "auditarIdUsuario")
@EnableJpaAuditing(auditorAwareRef = "auditarProceso")
public class AuditoryConfig {
  /**
   * AuditorAware<T> es Una interfaz que utiliza JPA para manejar QUIEN REALIZO UNA OPERACION en la BD
   * *
   * AuditorAware<TipoDato>, no es posible por el momento Auditar un SecUsuario,
   * manejarlo con un IUsuarioService para obtener por Id el SecUsuario de quien realizo
   * una operacion en la BD
   * *
   * Se usa una expresion lambda return () -> {}; en lugar de:
   *  return new AuditorAware<TipoDato>() {
  @Override
  public Optional<TipoDato> getCurrentAuditor(){};
   * *
   * En pocas palabras devuelve una nueva instancia de una clase anonima que implementa AuditorAware<TipoDato>
   * donde se sobreescribe el unico metodo:
   * *
   * public Optional<TipoDato> getCurrentAuditor();
   * *
   * y si este tiene un dato
   * Se registrara en la super clase AuditoriaRevision en las anotaciones
   * @CreatedBy
   * TipoDato tipoDato
   *
   * @LastModifiedBy
   * TipoDato tipoDato
   *
   * De lo contrario se registrara null en la BD
   */
  /*@Bean
  AuditorAware<Long> auditarIdUsuario() {
    return () -> {
      Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
      if (authentication != null
              && authentication.isAuthenticated()
              && authentication.getPrincipal() instanceof UserDetailsImpl) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        return Optional.of(userDetails.getId());
      } else {
        return Optional.empty();
      }
    };
  }*/

  @Bean
  AuditorAware<String> auditarProceso(){
    return () -> Optional.empty();
  }
}
