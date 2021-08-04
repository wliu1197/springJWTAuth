package springJWTAuth.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springJWTAuth.util.JwtUtil;

@Configuration
public class restConfiguration {
    @Bean
    public ObjectMapper createMapper() {
        return new ObjectMapper();
    }

}

