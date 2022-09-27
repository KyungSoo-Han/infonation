package kr.infonation.service;

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
   private final UserQueryRepository userQueryRepository;

   public CustomUserDetailsService(UserRepository userRepository, UserQueryRepository userQueryRepository) {
      this.userRepository = userRepository;
      this.userQueryRepository = userQueryRepository;
   }

   @Override
   @Transactional
   public UserDetails loadUserByUsername(final String login_id) {
      return userQueryRepository.findById2(login_id)
         .map(user -> createUser(login_id, user))
         .orElseThrow(() -> new UsernameNotFoundException(login_id + " -> 데이터베이스에서 찾을 수 없습니다."));
   }

   private org.springframework.security.core.userdetails.User createUser(String loginId, User user) {
      if (!user.isActivated()) {
         throw new RuntimeException(loginId + " -> 활성화되어 있지 않습니다.");
      }

      List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
      authorities.add(new SimpleGrantedAuthority(user.getRole().toString()));

      return new org.springframework.security.core.userdetails.User(user.getLogin_id(),
              user.getPassword(),
              authorities);
   }
}
