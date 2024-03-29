package br.com.gubee.interview.infrastructure.configuration;

import br.com.gubee.interview.application.gateway.*;
import br.com.gubee.interview.application.usecaseimpl.*;
import br.com.gubee.interview.application.validation.HeroValidation;
import br.com.gubee.interview.usecase.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HeroConfig {

    @Bean
    public CreatePowerStatsUseCase createPowerStatsUseCase(CreatePowerStatsGateway createPowerStatsGateway) {
        return new CreatePowerStatsUseCaseImpl(createPowerStatsGateway);
    }

    @Bean
    public HeroValidation heroValidation(){
        return new HeroValidation();
    }

    @Bean
    public ExistHeroByNameUseCase existHeroByNameUseCase(ExistHeroByNameGateway existHeroByNameGateway) {
        return new ExistHeroByNameUseCaseImpl(existHeroByNameGateway);
    }
    @Bean
    public CreateHeroUseCase createHeroUseCase(CreateHeroGateway createHeroGateway, CreatePowerStatsUseCase createPowerStatsUseCase, HeroValidation heroValidation, ExistHeroByNameUseCase existHeroByNameUseCase) {
        return new CreateHeroUseCaseImpl(createHeroGateway, createPowerStatsUseCase, heroValidation, existHeroByNameUseCase);
    }

    @Bean
    public FindPowerStatsByIdUseCase findPowerStatsByIdUseCase(FindPowerStatsByIdGateway findPowerStatsByIdGateway) {
        return new FindPowerStatsByIdUseCaseImpl(findPowerStatsByIdGateway);
    }

    @Bean
    public FindHeroByIdUseCase findHeroByIdUseCase(FindHeroByIdGateway findHeroByIdGateway, FindPowerStatsByIdUseCase findPowerStatsByIdUseCase) {
        return new FindHeroByIdUseCaseImpl(findHeroByIdGateway, findPowerStatsByIdUseCase);
    }

    @Bean
    public DeletePowerStatsUseCase deletePowerStatsUseCase(DeletePowerStatsGateway deletePowerStatsGateway, FindPowerStatsByIdUseCase findPowerStatsByIdUseCase) {
        return new DeletePowerStatsUseCaseImpl(deletePowerStatsGateway, findPowerStatsByIdUseCase);
    }

    @Bean
    public DeleteHeroUseCase deleteHeroUseCase(DeleteHeroGateway deleteHeroGateway, DeletePowerStatsUseCase deletePowerStatsUseCase, FindHeroByIdUseCase findHeroByIdUseCase) {
        return new DeleteHeroUseCaseImpl(deleteHeroGateway, deletePowerStatsUseCase, findHeroByIdUseCase);
    }

    @Bean
    public  UpdatePowerStatsUseCase updatePowerStatsUseCase(UpdatePowerStatsGateway updatePowerStatsGateway, FindPowerStatsByIdUseCase findPowerStatsByIdUseCase) {
        return new UpdatePowerStatsUseCaseImpl(updatePowerStatsGateway, findPowerStatsByIdUseCase);
    }

    @Bean
    public UpdateHeroUseCase updateHeroUseCase(UpdateHeroGateway updateHeroGateway, UpdatePowerStatsUseCase updatePowerStatsUseCase, FindHeroByIdUseCase findHeroByIdUseCase) {
        return new UpdateHeroUseCaseImpl(updateHeroGateway, updatePowerStatsUseCase, findHeroByIdUseCase);
    }
}
