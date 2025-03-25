package kr.co.sboard.security;

import kr.co.sboard.entity.User;
import kr.co.sboard.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class MyUserDetailService implements UserDetailsService {

    public final UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        log.info("username : {}", username);

        // 사용자 조회 - 사용자가 입력한 아이디, 비밀번호는 이전단계인 AuthenticationProvider 에서 먼저 수행
        Optional<User> optUser = userRepository.findById(username);

        if (optUser.isPresent()) {
            // Security 사용자 인증객체 생성
            MyUserDetails myUserDetails = MyUserDetails.builder()
                    .user(optUser.get())
                    .build();
            // 리턴 되는 myUserDetails는 Security ContextHolder에 저장
            return myUserDetails;
        }

        return null;

    }
}