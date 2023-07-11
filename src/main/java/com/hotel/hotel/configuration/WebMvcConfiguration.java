package com.hotel.hotel.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class WebMvcConfiguration implements WebMvcConfigurer {
  @Qualifier("estadoHabitacionRedirectInterceptor")
  private final HandlerInterceptor estadoHabitacionInterceptor;

  public void addInterceptors(InterceptorRegistry registry){
    registry.addInterceptor(estadoHabitacionInterceptor).addPathPatterns("/habitacion/**");
  }
}