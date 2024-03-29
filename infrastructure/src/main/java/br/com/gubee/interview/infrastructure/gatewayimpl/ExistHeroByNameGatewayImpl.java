package br.com.gubee.interview.infrastructure.gatewayimpl;

import br.com.gubee.interview.application.gateway.ExistHeroByNameGateway;
import br.com.gubee.interview.core.domain.Hero;
import br.com.gubee.interview.infrastructure.repository.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExistHeroByNameGatewayImpl implements ExistHeroByNameGateway {

    @Autowired
    private HeroRepository heroRepository;

    @Override
    public Hero existByName(String name) {
         return heroRepository.findByName(name);
    }
}
