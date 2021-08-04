package springJWTAuth.filters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.server.ResponseStatusException;
import springJWTAuth.util.JwtUtil;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;

import java.io.IOException;
import java.util.ArrayList;

@Component
public class JwtRequestFilter implements Filter {

    ArrayList<String> valideClientIds = new ArrayList<String>() {{
                    add("wen");
                    add("wenTest");
                    add("ssss");
    }};

    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain) throws ResponseStatusException, IOException, ServletException {
        try {
            HttpServletRequest httpServletRequest = (HttpServletRequest) request;
            final String authorizationHeader = httpServletRequest.getHeader("Authorization");
            JwtUtil jwtUtil = new JwtUtil();
            String clientId = null;
            String jwt = null;

            if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
                jwt = authorizationHeader.substring(7);
                clientId = jwtUtil.extractClientId(jwt);
            }

            if (clientId != null && jwtUtil.validateToken(jwt, valideClientIds)) {
                chain.doFilter(request, response);
            } else {
                HttpServletResponse httpServletResponse = (HttpServletResponse) response;
                httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Failed token");
            }
        }catch (Exception e){
            HttpServletResponse httpServletResponse = (HttpServletResponse) response;
            httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Failed token");
        }

    }
}
