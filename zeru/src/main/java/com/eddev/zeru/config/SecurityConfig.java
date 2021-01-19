package com.eddev.zeru.config;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
  
  private static final String[] PUBLIC_MATCHERS = {
    "/h2-console/**" 
  };
  
  private static final String[] PUBLIC_MATCHERS_GET = {
    "/produtos/**",
    "/categorias/**"
  };
  
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    if(Arrays.asList(env.getActiveProfiles()).contains("dev"))
      http.headers().frameOptions().disable();
    
    http.cors().and().csrf().disable;
    http.authorizeRequests()
        .antMatchers(HttpMethod.GET, PUBLIC_MATCHERS_GET).permitAll()
        .antMatchers(PUBLIC_MATCHERS).permitAll()
        .anyRequest().authenticated();
    http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
  }
  
}
