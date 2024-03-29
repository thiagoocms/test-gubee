package br.com.gubee.interview.application.usecaseimpl;

import br.com.gubee.interview.application.gateway.CreateHeroGateway;
import br.com.gubee.interview.application.validation.HeroValidation;
import br.com.gubee.interview.core.domain.Hero;
import br.com.gubee.interview.core.domain.PowerStats;
import br.com.gubee.interview.usecase.CreateHeroUseCase;
import br.com.gubee.interview.usecase.CreatePowerStatsUseCase;
import br.com.gubee.interview.usecase.ExistHeroByNameUseCase;

public class CreateHeroUseCaseImpl implements CreateHeroUseCase {

    private final CreateHeroGateway createHeroGateway;
    private final CreatePowerStatsUseCase createPowerStatsUseCase;
    private final HeroValidation heroValidation;
    private final ExistHeroByNameUseCase  existHeroByNameUseCase;

    public CreateHeroUseCaseImpl(CreateHeroGateway createHeroGateway, CreatePowerStatsUseCase createPowerStatsUseCase, HeroValidation heroValidation, ExistHeroByNameUseCase existHeroByNameUseCase) {
        this.createHeroGateway = createHeroGateway;
        this.createPowerStatsUseCase = createPowerStatsUseCase;
        this.heroValidation = heroValidation;
        this.existHeroByNameUseCase = existHeroByNameUseCase;
    }

    @Override
    public Hero create(Hero hero) throws Throwable {
        this.heroValidation.checkMandatoryFields(hero);
        this.existHeroByNameUseCase.existByName(hero.getName());
        PowerStats powerStats = this.createPowerStatsUseCase.create(hero.getPowerStats());
        hero.setPowerStats(powerStats);
        return this.createHeroGateway.create(hero);
    }
}
