package br.com.gubee.interview.infrastructure.controller;

import br.com.gubee.interview.core.domain.Hero;
import br.com.gubee.interview.infrastructure.constants.AppConstants;
import br.com.gubee.interview.infrastructure.dto.HeroRequest;
import br.com.gubee.interview.infrastructure.dto.HeroResponse;
import br.com.gubee.interview.infrastructure.mapper.HeroMapper;
import br.com.gubee.interview.usecase.CreateHeroUseCase;
import br.com.gubee.interview.usecase.FindHeroByIdUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping(value = AppConstants.PATH + AppConstants.API + AppConstants.V1 + "/heroes")
public class HeroController {

    private final CreateHeroUseCase createHeroUseCase;
    private final FindHeroByIdUseCase findHeroByIdUseCase;

    public HeroController(CreateHeroUseCase createHeroUseCase, FindHeroByIdUseCase findHeroByIdUseCase) {
        this.createHeroUseCase = createHeroUseCase;
        this.findHeroByIdUseCase = findHeroByIdUseCase;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<HeroResponse> create(@RequestBody HeroRequest heroRequest) throws Throwable {
        Hero hero = createHeroUseCase.create(HeroMapper.toHero(heroRequest));
        HeroResponse heroResponse = HeroMapper.toHeroResponse(hero);
        return ResponseEntity
                .created(URI.create("/heroes"))
                .body(heroResponse);
    }

    @GetMapping("/{id}")
    @Transactional(readOnly = true)
    public ResponseEntity<HeroResponse> findById(@PathVariable UUID id) throws Throwable {
        HeroResponse response = HeroMapper.toHeroResponse(findHeroByIdUseCase.findById(id));
        return ResponseEntity
                .ok()
                .body(response);
    }
}
