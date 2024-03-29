package br.com.gubee.interview.infrastructure.gatewayimpl;

import br.com.gubee.interview.application.gateway.UpdateHeroGateway;
import br.com.gubee.interview.core.domain.Hero;
import br.com.gubee.interview.infrastructure.repository.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UpdateHeroGatewayImpl implements UpdateHeroGateway {

    private final HeroRepository heroRepository;

    @Lazy
    @Autowired
    public UpdateHeroGatewayImpl(HeroRepository heroRepository) {
        this.heroRepository = heroRepository;
    }

    @Override
    public Hero updateById(UUID id, Hero hero) {
        return heroRepository.update(id, hero);
    }
}
