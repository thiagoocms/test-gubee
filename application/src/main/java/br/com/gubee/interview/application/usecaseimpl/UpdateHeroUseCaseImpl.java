package br.com.gubee.interview.application.usecaseimpl;

import br.com.gubee.interview.application.gateway.UpdateHeroGateway;
import br.com.gubee.interview.core.domain.Hero;
import br.com.gubee.interview.core.domain.PowerStats;
import br.com.gubee.interview.usecase.FindHeroByIdUseCase;
import br.com.gubee.interview.usecase.UpdateHeroUseCase;
import br.com.gubee.interview.usecase.UpdatePowerStatsUseCase;

import java.time.LocalDateTime;
import java.util.UUID;

public class UpdateHeroUseCaseImpl implements UpdateHeroUseCase {

    private final UpdateHeroGateway updateHeroGateway;
    private final UpdatePowerStatsUseCase updatePowerStatsUseCase;
    private final FindHeroByIdUseCase findHeroByIdUseCase;

    public UpdateHeroUseCaseImpl(UpdateHeroGateway updateHeroGateway, UpdatePowerStatsUseCase updatePowerStatsUseCase, FindHeroByIdUseCase findHeroByIdUseCase) {
        this.updateHeroGateway = updateHeroGateway;
        this.updatePowerStatsUseCase = updatePowerStatsUseCase;
        this.findHeroByIdUseCase = findHeroByIdUseCase;
    }

    @Override
    public Hero updateById(UUID id, Hero hero) {
        Hero existHero = this.findHeroByIdUseCase.findById(id);
        PowerStats powerStats = this.updatePowerStatsUseCase.updateById(existHero.getPowerStats().getId(), hero.getPowerStats());
        hero.setId(id);
        hero.setPowerStats(powerStats);
        hero.setCreatedAt(existHero.getCreatedAt());
        hero.setUpdatedAt(LocalDateTime.now());
        return this.updateHeroGateway.updateById(id, hero);
    }
}
