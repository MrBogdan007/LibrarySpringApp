package com.librarypackage.library.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
@Component
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {
	private final UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	    User user = userRepository.findByEmail(username)
	            .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
	    List<GrantedAuthority> authorities = new ArrayList<>();
	    authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole()));

	    return new org.springframework.security.core.userdetails.User(
	            user.getUsername(), user.getPassword(), user.isEnabled(), true, true, true, authorities);
	}
}
