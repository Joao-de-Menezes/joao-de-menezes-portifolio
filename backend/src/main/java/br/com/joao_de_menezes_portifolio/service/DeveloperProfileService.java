package br.com.joao_de_menezes_portifolio.service;

import br.com.joao_de_menezes_portifolio.dto.DeveloperProfileRequestDTO;
import br.com.joao_de_menezes_portifolio.dto.DeveloperProfileResponseDTO;
import br.com.joao_de_menezes_portifolio.entity.DeveloperProfile;
import br.com.joao_de_menezes_portifolio.repository.DeveloperProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DeveloperProfileService {
    private final DeveloperProfileRepository profileRepository;

    @Transactional
    public DeveloperProfileResponseDTO createProfile(DeveloperProfileRequestDTO dto) {
        DeveloperProfile profile = new DeveloperProfile();
        profile.setFullName(dto.fullName());
        profile.setAge(dto.age());
        profile.setHeadline(dto.headline());
        profile.setEmail(dto.email());
        profile.setGithubUrl(dto.githubUrl());
        profile.setLinkedinUrl(dto.linkedinUrl());

        profile = profileRepository.save(profile);
        return DeveloperProfileResponseDTO.fromEntity(profile);
    }

    @Transactional(readOnly = true)
    public DeveloperProfileResponseDTO getProfile(Long id) {
        DeveloperProfile profile = profileRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Perfil não encontrado."));
        return DeveloperProfileResponseDTO.fromEntity(profile);
    }
}
