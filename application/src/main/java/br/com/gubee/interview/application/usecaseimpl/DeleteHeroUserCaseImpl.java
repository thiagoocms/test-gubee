package br.com.gubee.interview.application.usecaseimpl;

import br.com.gubee.interview.application.gateway.DeleteHeroGateway;
import br.com.gubee.interview.core.domain.Hero;
import br.com.gubee.interview.usecase.DeleteHeroUseCase;
import br.com.gubee.interview.usecase.DeletePowerStatsUseCase;
import br.com.gubee.interview.usecase.FindHeroByIdUseCase;

import java.util.UUID;

public class DeleteHeroUserCaseImpl implements DeleteHeroUseCase {

    private final DeleteHeroGateway deleteHeroGateway;
    private final DeletePowerStatsUseCase deletePowerStatsUseCase;
    private final FindHeroByIdUseCase findHeroByIdUseCase;

    public DeleteHeroUserCaseImpl(DeleteHeroGateway deleteHeroGateway, DeletePowerStatsUseCase deletePowerStatsUseCase, FindHeroByIdUseCase findHeroByIdUseCase) {
        this.deleteHeroGateway = deleteHeroGateway;
        this.deletePowerStatsUseCase = deletePowerStatsUseCase;
        this.findHeroByIdUseCase = findHeroByIdUseCase;
    }

    @Override
    public void deleteById(UUID id) {
        Hero hero = this.findHeroByIdUseCase.findById(id);
        this.deletePowerStatsUseCase.deleteById(hero.getPowerStats().getId());
        this.deleteHeroGateway.deleteById(id);
    }
}
