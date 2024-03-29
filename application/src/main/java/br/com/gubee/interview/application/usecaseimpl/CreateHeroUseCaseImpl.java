package br.com.gubee.interview.application.usecaseimpl;

import br.com.gubee.interview.application.gateway.CreateHeroGateway;
import br.com.gubee.interview.application.validation.HeroValidation;
import br.com.gubee.interview.core.domain.Hero;
import br.com.gubee.interview.core.exception.BadRequestException;
import br.com.gubee.interview.usecase.CreateHeroUseCase;
import br.com.gubee.interview.usecase.CreatePowerStatsUseCase;

public class CreateHeroUseCaseImpl implements CreateHeroUseCase {

    private final CreateHeroGateway createHeroGateway;
    private final CreatePowerStatsUseCase createPowerStatsUseCase;
    private final HeroValidation heroValidation;

    public CreateHeroUseCaseImpl(CreateHeroGateway createHeroGateway, CreatePowerStatsUseCase createPowerStatsUseCase, HeroValidation heroValidation) {
        this.createHeroGateway = createHeroGateway;
        this.createPowerStatsUseCase = createPowerStatsUseCase;
        this.heroValidation = heroValidation;
    }

    @Override
    public Hero create(Hero hero) throws Throwable {
        this.heroValidation.checkMandatoryFields(hero);
        this.createPowerStatsUseCase.create(hero.getPowerStats());
        return this.createHeroGateway.create(hero);
    }
}
