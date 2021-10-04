package r.r.impls;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import r.r.services.UserService;

@Service
public class UserServiceImpl implements UserService {

   @Override
   public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      return new User("superman", "123", new ArrayList<>());
   }

   @Bean
   public PasswordEncoder passwordEncoder() {
      return NoOpPasswordEncoder.getInstance();
   }

}
