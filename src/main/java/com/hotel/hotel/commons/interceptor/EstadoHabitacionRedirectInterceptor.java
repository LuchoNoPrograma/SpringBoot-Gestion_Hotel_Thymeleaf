package com.hotel.hotel.commons.interceptor;

import com.hotel.hotel.commons.annotation.RedirigirEstadoHabitacion;
import com.hotel.hotel.modelo.enums.EstadoHabitacion;
import lombok.NonNull;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Log4j2
@Component("estadoHabitacionRedirectInterceptor")
public class EstadoHabitacionRedirectInterceptor implements HandlerInterceptor {

  @Override
  public void postHandle(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response,
                         @NonNull Object handler, ModelAndView modelAndView) {

    if (handler instanceof HandlerMethod handlerMethod) {
      log.info("INTERCEPTANDO METODO MEDIANTE PATH");

      RedirigirEstadoHabitacion annotation = handlerMethod.getMethodAnnotation(RedirigirEstadoHabitacion.class);
      if (annotation != null) {
        log.info("INTERCEPTANDO METODO MEDIANTE LA ANOTACIÓN");
        HttpSession session = request.getSession();
        EstadoHabitacion estado = (EstadoHabitacion) session.getAttribute("estado");
        if (estado != null) {
          String redireccion = "/habitacion/lista?estado=" + estado.name();
          modelAndView.setView(new RedirectView(redireccion));
        }
      }
    }
  }
}
