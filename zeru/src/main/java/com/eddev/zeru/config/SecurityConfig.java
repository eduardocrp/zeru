package com.eddev.zeru.config;

public class SecurityConfig {
  
  private static final String[] PUBLIC_MATCHERS = {
    "/h2-console/**" 
  };
  
  private static final String[] PUBLIC_MATCHERS_GET = {
    "/produtos/**",
    "/categorias/**"
  };
  
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    
  }
}
