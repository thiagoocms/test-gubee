package br.com.gubee.interview.application.gateway;

import br.com.gubee.interview.core.domain.Hero;

import java.util.Set;

public interface FindHeroByNameGateway {
    Set<Hero> findFilterByName(String name);
}
