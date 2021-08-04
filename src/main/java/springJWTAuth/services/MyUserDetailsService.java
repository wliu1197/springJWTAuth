package springJWTAuth.services;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MyUserDetailsService implements UserDetailsService {
    //basic auth
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException{
        //user info can get from db or some where
        //username,password, wen:comein22
        return new User("wen","$2a$10$H0q5xQF5lm9yoMxcrE4DQe5nHEWXb.XhIRW9CVXMqSIQgsIhrMFzi", new ArrayList<>());
    }

    //jwt user
    public UserDetails loadJwtUser(String clientId) throws UsernameNotFoundException{
        //user info can get from db or some where
        //username,password, wen:comein22
        return new User(clientId,"", new ArrayList<>());
    }
}
