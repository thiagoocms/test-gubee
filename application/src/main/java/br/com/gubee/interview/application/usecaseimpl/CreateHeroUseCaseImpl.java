package br.com.gubee.interview.application.usecaseimpl;

import br.com.gubee.interview.application.gateway.CreateHeroGateway;
import br.com.gubee.interview.core.domain.Hero;
import br.com.gubee.interview.usecase.CreateHeroUseCase;
import br.com.gubee.interview.usecase.CreatePowerStatsUseCase;

public class CreateHeroUseCaseImpl implements CreateHeroUseCase {

    private final CreateHeroGateway createHeroGateway;
    private final CreatePowerStatsUseCase createPowerStatsUseCase;

    public CreateHeroUseCaseImpl(CreateHeroGateway createHeroGateway, CreatePowerStatsUseCase createPowerStatsUseCase) {
        this.createHeroGateway = createHeroGateway;
        this.createPowerStatsUseCase = createPowerStatsUseCase;
    }

    @Override
    public Hero create(Hero hero) {
        this.createPowerStatsUseCase.create(hero.getPowerStats());
        return this.createHeroGateway.create(hero);
    }
}
