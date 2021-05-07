package com.zunde.userManagement.registration.token;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@NoArgsConstructor
public class ConfirmationTokenService {
    @Autowired
    ConfirmationTokenRepository tokenRepository;

    public void saveToken(ConfirmationToken token){
        tokenRepository.save(token);
    }
    public Optional<ConfirmationToken> getToken(String token) {
        return tokenRepository.findByToken(token);
    }

    public int setConfirmedAt(String token) {
        return tokenRepository.updateConfirmedAt(
                token, LocalDateTime.now());
    }
}
