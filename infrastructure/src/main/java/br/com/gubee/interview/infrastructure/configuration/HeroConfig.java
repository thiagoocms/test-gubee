package br.com.gubee.interview.infrastructure.configuration;

import br.com.gubee.interview.application.gateway.CreateHeroGateway;
import br.com.gubee.interview.application.gateway.CreatePowerStatsGateway;
import br.com.gubee.interview.application.usecaseimpl.CreateHeroUseCaseImpl;
import br.com.gubee.interview.application.usecaseimpl.CreatePowerStatsUseCaseImpl;
import br.com.gubee.interview.application.validation.HeroValidation;
import br.com.gubee.interview.usecase.CreateHeroUseCase;
import br.com.gubee.interview.usecase.CreatePowerStatsUseCase;
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
    public CreateHeroUseCase createHeroUseCase(CreateHeroGateway createHeroGateway, CreatePowerStatsUseCase createPowerStatsUseCase, HeroValidation heroValidation) {
        return new CreateHeroUseCaseImpl(createHeroGateway, createPowerStatsUseCase, heroValidation);
    }
}
