package br.com.gubee.interview.infrastructure.controller;

import br.com.gubee.interview.core.domain.Hero;
import br.com.gubee.interview.core.domain.HeroComparePowerStats;
import br.com.gubee.interview.infrastructure.constants.AppConstants;
import br.com.gubee.interview.infrastructure.dto.*;
import br.com.gubee.interview.infrastructure.mapper.HeroMapper;
import br.com.gubee.interview.usecase.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = AppConstants.PATH + AppConstants.API + AppConstants.V1 + AppConstants.URL_SUFFIX +"heroes")
public class HeroController {

    private final CreateHeroUseCase createHeroUseCase;
    private final FindHeroByIdUseCase findHeroByIdUseCase;
    private final DeleteHeroUseCase deleteHeroUseCase;
    private final UpdateHeroUseCase updateHeroUseCase;
    private final FindHeroByFiltersUseCase findHeroByFiltersUseCase;
    private final CompareHeroUseCase compareHeroUseCase;

    public HeroController(CreateHeroUseCase createHeroUseCase, FindHeroByIdUseCase findHeroByIdUseCase,
                          DeleteHeroUseCase deleteHeroUseCase, UpdateHeroUseCase updateHeroUseCase,
                          FindHeroByFiltersUseCase findHeroByFiltersUseCase, CompareHeroUseCase compareHeroUseCase) {
        this.createHeroUseCase = createHeroUseCase;
        this.findHeroByIdUseCase = findHeroByIdUseCase;
        this.deleteHeroUseCase = deleteHeroUseCase;
        this.updateHeroUseCase = updateHeroUseCase;
        this.findHeroByFiltersUseCase = findHeroByFiltersUseCase;
        this.compareHeroUseCase = compareHeroUseCase;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<HeroResponse> create(@RequestBody HeroRequest heroRequest) throws Throwable {
        Hero hero = createHeroUseCase.create(HeroMapper.toHero(heroRequest));
        HeroResponse heroResponse = HeroMapper.toHeroResponse(hero);
        return ResponseEntity
                .created(URI.create(AppConstants.URL_SUFFIX + "heroes"))
                .body(heroResponse);
    }

    @GetMapping(AppConstants.URL_SUFFIX + "{id}")
    @Transactional(readOnly = true)
    public ResponseEntity<HeroResponse> findById(@PathVariable UUID id) {
        HeroResponse response = HeroMapper.toHeroResponse(findHeroByIdUseCase.findById(id));
        return ResponseEntity
                .ok()
                .body(response);
    }

    @DeleteMapping(AppConstants.URL_SUFFIX + "{id}")
    @Transactional
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteHeroUseCase.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping(AppConstants.URL_SUFFIX + "{id}")
    @Transactional
    public ResponseEntity<HeroResponse> update(@PathVariable UUID id, @RequestBody HeroRequest request) {
        Hero hero = updateHeroUseCase.updateById(id, HeroMapper.toHero(request));
        HeroResponse response = HeroMapper.toHeroResponse(hero);
        return ResponseEntity
                .ok()
                .body(response);
    }

    @GetMapping
    @Transactional(readOnly = true)
    public ResponseEntity<Set<HeroResponse>> findAll(HeroFilterRequest filterRequest) {

        Set<Hero> heroSet = findHeroByFiltersUseCase.findFilter(HeroMapper.toFilter(filterRequest));

        if (heroSet.isEmpty()) {
            return ResponseEntity
                    .ok().build();
        }

        Set<HeroResponse> responseSet = heroSet.stream()
                .map(HeroMapper::toHeroResponse).collect(Collectors.toSet());

        return ResponseEntity
                .ok()
                .body(responseSet);
    }

    @PostMapping(AppConstants.URL_SUFFIX + "compare-to")
    @Transactional(readOnly = true)
    public ResponseEntity<HeroComparePowerStatsResponse> compare(@RequestBody HeroCompareRequest request) {
        HeroComparePowerStats heroComparePowerStats =
                this.compareHeroUseCase.compareTo(request.getHeroId(), request.getOpponentId());
        return ResponseEntity
                .ok()
                .body(HeroMapper.toHeroCompareResponse(heroComparePowerStats));
    }
}
