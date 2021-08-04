package springJWTAuth.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import springJWTAuth.models.AuthenticationRequest;
import springJWTAuth.models.AuthenticationResponse;
import springJWTAuth.services.MyUserDetailsService;
import springJWTAuth.util.JwtUtil;

@RestController
@RequestMapping("/rest-api")
public class RestApiController {
    @Autowired
    ObjectMapper mapper;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @GetMapping("/hello")
    @ResponseStatus(value = HttpStatus.OK)
    public JsonNode hello(@RequestParam(value = "name", defaultValue = "World") String name) throws JsonProcessingException {
        String json =  "{\"message\":" + "\"Hello " + name + "\"}";
        return mapper.readTree(json);
    }

    @PostMapping("/getAuthJWT")
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<?> createJWTAuthToken(@RequestBody AuthenticationRequest authRequest) throws ResponseStatusException,Exception {
        UserDetails userDetails = userDetailsService.loadJwtUser(authRequest.getClientId());
        String jwt = jwtUtil.generateToken(userDetails);
        System.out.println(jwt);
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
}