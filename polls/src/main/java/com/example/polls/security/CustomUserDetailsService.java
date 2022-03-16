package com.example.polls.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.polls.model.User;
import com.example.polls.repository.UserRepository;

/**
 * UserDetailsService이제 사용자 이름이 지정된 사용자 데이터를 로드하는 사용자 지정을 정의 클래스.
 */

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String usernameOrEmail)
		throws UsernameNotFoundException {
		// Let people login with either username or email
		User user = userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
			.orElseThrow(() ->
				new UsernameNotFoundException("User not found with username or email : " + usernameOrEmail)
			);

		return UserPrincipal.create(user);
	}

	// This method is used by JWTAuthenticationFilter
	@Transactional
	public UserDetails loadUserById(Long id) {
		User user = userRepository.findById(id).orElseThrow(
			() -> new UsernameNotFoundException("User not found with id : " + id)
		);

		return UserPrincipal.create(user);
	}

	/**
	 * 첫 번째 방법 loadUserByUsername()은 Spring 보안에서 사용됩니다.메소드 의 사용에 주의하십시오
	 * findByUsernameOrEmail. 이를 통해 사용자는 사용자 이름이나 이메일을 사용하여 로그인할 수 있습니다.
	 */
}
