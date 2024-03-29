package br.com.gubee.interview.infrastructure.gatewayimpl;

import br.com.gubee.interview.application.gateway.CreateHeroGateway;
import br.com.gubee.interview.application.gateway.CreatePowerStatsGateway;
import br.com.gubee.interview.application.gateway.DeleteHeroGateway;
import br.com.gubee.interview.core.domain.Hero;
import br.com.gubee.interview.infrastructure.repository.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DeleteHeroGatewayImpl implements DeleteHeroGateway {

    private final HeroRepository heroRepository;

    @Autowired
    public DeleteHeroGatewayImpl(HeroRepository heroRepository) {
        this.heroRepository = heroRepository;
    }

    @Override
    public void deleteById(UUID id) {
        this.heroRepository.deleteById(id);
    }
}
