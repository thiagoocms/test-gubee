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

    @Lazy
    @Autowired
    public CreateHeroGatewayImpl(HeroRepository heroRepository) {
        this.heroRepository = heroRepository;
    }

    @Override
    public Hero create(Hero hero) {
        return heroRepository.create(hero);
    }
}
