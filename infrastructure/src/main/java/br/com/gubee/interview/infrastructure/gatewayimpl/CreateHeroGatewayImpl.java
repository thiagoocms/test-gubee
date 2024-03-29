package br.com.gubee.interview.infrastructure.gatewayimpl;

import br.com.gubee.interview.application.gateway.CreateHeroGateway;
import br.com.gubee.interview.application.gateway.CreatePowerStatsGateway;
import br.com.gubee.interview.core.domain.Hero;
import br.com.gubee.interview.core.domain.PowerStats;
import br.com.gubee.interview.infrastructure.repository.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class CreateHeroGatewayImpl implements CreateHeroGateway {

    private final HeroRepository heroRepository;
    private final CreatePowerStatsGateway createPowerStatsGateway;

    @Lazy
    @Autowired
    public CreateHeroGatewayImpl(HeroRepository heroRepository, CreatePowerStatsGateway createPowerStatsGateway) {
        this.heroRepository = heroRepository;
        this.createPowerStatsGateway = createPowerStatsGateway;
    }

    @Override
    public Hero create(Hero hero) {
        PowerStats powerStats = createPowerStatsGateway.create(hero.getPowerStats());
        hero.setPowerStats(powerStats);
        return heroRepository.create(hero);
    }
}
