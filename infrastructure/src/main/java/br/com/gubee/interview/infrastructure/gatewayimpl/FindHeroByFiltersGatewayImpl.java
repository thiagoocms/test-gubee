package br.com.gubee.interview.infrastructure.gatewayimpl;

import br.com.gubee.interview.application.gateway.FindHeroByFiltersGateway;
import br.com.gubee.interview.application.gateway.FindHeroByIdGateway;
import br.com.gubee.interview.core.domain.Hero;
import br.com.gubee.interview.core.domain.HeroFilter;
import br.com.gubee.interview.infrastructure.repository.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class FindHeroByFiltersGatewayImpl implements FindHeroByFiltersGateway {

    @Lazy
    @Autowired
    private HeroRepository heroRepository;

    @Override
    public Set<Hero> findFilter(HeroFilter filter) {
        return heroRepository.findFilter(filter);
    }
}
