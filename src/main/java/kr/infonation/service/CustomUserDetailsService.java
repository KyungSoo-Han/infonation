package kr.infonation.service;

import ch.qos.logback.core.net.SyslogOutputStream;
import kr.infonation.domain.user.User;
import kr.infonation.repository.user.UserQueryRepository;
import kr.infonation.repository.user.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
   private final UserRepository userRepository;

   public CustomUserDetailsService(UserRepository userRepository) {
      this.userRepository = userRepository;
   }

   @Override
   @Transactional
   public UserDetails loadUserByUsername(final String login_id) {

      return userRepository.findByIdOptional(login_id)
         .map(user -> createUser(login_id, user))
         .orElseThrow(() -> new UsernameNotFoundException(login_id + " -> 데이터베이스에서 찾을 수 없습니다."));
   }

   private org.springframework.security.core.userdetails.User createUser(String login_id, User user) {
      if (!user.isActivated()) {
         throw new RuntimeException(login_id + " -> 활성화되어 있지 않습니다.");
      }

      List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
      authorities.add(new SimpleGrantedAuthority(user.getRole().toString()));

      return new org.springframework.security.core.userdetails.User(user.getLogin_id(),
              user.getPassword(),
              authorities);
   }
}
