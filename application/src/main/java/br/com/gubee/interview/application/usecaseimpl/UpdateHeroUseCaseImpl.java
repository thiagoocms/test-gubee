package br.com.gubee.interview.application.usecaseimpl;

import br.com.gubee.interview.application.gateway.UpdateHeroGateway;
import br.com.gubee.interview.core.domain.Hero;
import br.com.gubee.interview.usecase.UpdateHeroUseCase;
import br.com.gubee.interview.usecase.UpdatePowerStatsUseCase;

import java.util.UUID;

public class UpdateHeroUseCaseImpl implements UpdateHeroUseCase {

    private final UpdateHeroGateway updateHeroGateway;
    private final UpdatePowerStatsUseCase updatePowerStatsUseCase;

    public UpdateHeroUseCaseImpl(UpdateHeroGateway updateHeroGateway, UpdatePowerStatsUseCase updatePowerStatsUseCase) {
        this.updateHeroGateway = updateHeroGateway;
        this.updatePowerStatsUseCase = updatePowerStatsUseCase;
    }

    @Override
    public Hero updateById(UUID id, Hero hero) {
        this.updatePowerStatsUseCase.updateById(hero.getPowerStats().getId(), hero.getPowerStats());
        return this.updateHeroGateway.updateById(id, hero);
    }
}
