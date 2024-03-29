package br.com.gubee.interview.infrastructure.gatewayimpl;

import br.com.gubee.interview.application.gateway.FindHeroByIdGateway;
import br.com.gubee.interview.application.gateway.FindPowerStatsByIdGateway;
import br.com.gubee.interview.core.domain.Hero;
import br.com.gubee.interview.core.domain.PowerStats;
import br.com.gubee.interview.infrastructure.repository.HeroRepository;
import br.com.gubee.interview.infrastructure.repository.PowerStatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class FindHeroByIdGatewayImpl implements FindHeroByIdGateway {

    @Lazy
    @Autowired
    private HeroRepository heroRepository;

    @Override
    public Hero findById(UUID id) {
        return heroRepository.findById(id);
    }
}
