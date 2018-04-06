package be.superteam.config;

import be.superteam.filter.JwtAuthenticationFilter;
import be.superteam.filter.JwtAuthorizationFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	// Peut être retrouvé dans un fichier de configuration (genre application.yml)
	// Ou bien dans les paramètres au lancement de la JVM
	// Ou bien dans les variables d'environnement
	@Value("${secret}")
	private String secret;

	private final UserDetailsService userDetailsService;

	public SecurityConfig(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Override
	    protected void configure(HttpSecurity http) throws Exception {

	        http
	                .authorizeRequests()
	                .antMatchers("/api/user/**").hasRole("USER")
	                .antMatchers("/api/admin/**").hasRole("ADMIN")
	                .antMatchers("/api/**").permitAll()
	                .anyRequest().authenticated()
	                .and().exceptionHandling()
	                .authenticationEntryPoint((request, response, exception) -> response.sendError(401))  // Pas redirection vers page de login (défaut si site propre), mais envoi d'une erreur "401"
					.and()          // Interception des requêtes par un filtre
	                .addFilter(new JwtAuthenticationFilter(authenticationManager(), secret))    // Authentification
	                .addFilter(new JwtAuthorizationFilter(authenticationManager(), secret))    // Autorisation (vérification du token)
	                .cors().and()
					.csrf().disable() // Validation directe sur notre propre site (désactivé si API)
	                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS); // Validation par token, et plus par session
	   }
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() { // Remplacer par WebMvcConfigurerAdapter sur Spring Boot < 2.0.0
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*").allowedHeaders("Authorization").exposedHeaders("Authorization");
			}
		};
	}
//	@Bean
//	CorsConfigurationSource corsConfigurationSource() {
//		CorsConfiguration configuration = new CorsConfiguration();
//		configuration.setAllowedOrigins(Arrays.asList("*"));
//		configuration.setAllowedMethods(Arrays.asList("GET","POST", "OPTIONS", "PUT", "DELETE"));
//		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//		source.registerCorsConfiguration("/**", configuration);
//		return source;
//	}

}
