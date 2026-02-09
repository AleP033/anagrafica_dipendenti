package com.example.anagrafica_dipendenti.Service;

import com.example.anagrafica_dipendenti.Dto.DipendenteDTO;
import com.example.anagrafica_dipendenti.Model.Dipendente;
import com.example.anagrafica_dipendenti.Repository.DipendenteRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private final DipendenteRepository dipendenteRepository;
    private final PasswordEncoder passwordEncoder;

    public LoginService(DipendenteRepository dipendenteRepository,
                        PasswordEncoder passwordEncoder) {
        this.dipendenteRepository = dipendenteRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public DipendenteDTO login(String email, String password) {

        try {
            Dipendente d = dipendenteRepository.findByEmail(email)
                    .orElseThrow(() -> new RuntimeException("Email non trovata"));

            if (!passwordEncoder.matches(password, d.getPassword())) {
                throw new RuntimeException("Password errata");
            }

            return toDTO(d);

        } catch (Exception e) {
            throw new RuntimeException("Errore interno durante il login");
        }
    }

    private DipendenteDTO toDTO(Dipendente d) {
        DipendenteDTO dto = new DipendenteDTO();
        dto.setId(d.getId());
        dto.setNome(d.getNome());
        dto.setCognome(d.getCognome());
        dto.setEmail(d.getEmail());
        return dto;
    }
}
