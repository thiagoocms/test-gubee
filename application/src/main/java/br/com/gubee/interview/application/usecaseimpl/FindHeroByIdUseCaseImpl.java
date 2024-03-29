package br.com.gubee.interview.application.usecaseimpl;

import br.com.gubee.interview.application.gateway.FindHeroByIdGateway;
import br.com.gubee.interview.core.domain.Hero;
import br.com.gubee.interview.core.domain.PowerStats;
import br.com.gubee.interview.core.exception.ResourceNotFoundException;
import br.com.gubee.interview.usecase.FindHeroByIdUseCase;
import br.com.gubee.interview.usecase.FindPowerStatsByIdUseCase;

import java.util.UUID;

public class FindHeroByIdUseCaseImpl implements FindHeroByIdUseCase {

    private final FindHeroByIdGateway findHeroByIdGateway;
    private final FindPowerStatsByIdUseCase findPowerStatsByIdUseCase;

    public FindHeroByIdUseCaseImpl(FindHeroByIdGateway findHeroByIdGateway, FindPowerStatsByIdUseCase findPowerStatsByIdUseCase) {
        this.findHeroByIdGateway = findHeroByIdGateway;
        this.findPowerStatsByIdUseCase = findPowerStatsByIdUseCase;
    }

    @Override
    public Hero findById(UUID id) {
        Hero hero = this.findHeroByIdGateway.findById(id);
        if (hero == null) {
            throw new ResourceNotFoundException("Heroi não encontrado.");
        }
        PowerStats powerStats = this.findPowerStatsByIdUseCase.findById(hero.getPowerStats().getId());
        hero.setPowerStats(powerStats);

        return hero;
    }
}
