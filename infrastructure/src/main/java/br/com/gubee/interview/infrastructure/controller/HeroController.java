package br.com.gubee.interview.infrastructure.controller;

import br.com.gubee.interview.core.domain.Hero;
import br.com.gubee.interview.infrastructure.constants.AppConstants;
import br.com.gubee.interview.infrastructure.dto.HeroRequest;
import br.com.gubee.interview.infrastructure.mapper.HeroMapper;
import br.com.gubee.interview.usecase.CreateHeroUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping(value = AppConstants.PATH + AppConstants.API + AppConstants.V1 + "/heroes")
public class HeroController {

    @Autowired
    private  CreateHeroUseCase createHeroUseCase;


    @PostMapping
    public ResponseEntity<Hero> create(@RequestBody HeroRequest heroRequest) throws Throwable {
        Hero hero = createHeroUseCase.create(HeroMapper.toHero(heroRequest));
        return ResponseEntity
                .created(URI.create("/heroes"))
                .body(hero);
    }
}
