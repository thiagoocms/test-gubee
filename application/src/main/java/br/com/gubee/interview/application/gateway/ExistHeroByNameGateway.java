package br.com.gubee.interview.application.gateway;

import br.com.gubee.interview.core.domain.Hero;

public interface ExistHeroByNameGateway {
    Hero existByName(String name);
}
