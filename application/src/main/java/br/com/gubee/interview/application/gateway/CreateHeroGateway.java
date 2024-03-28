package br.com.gubee.interview.application.gateway;


import br.com.gubee.interview.core.domain.Hero;

public interface CreateHeroGateway {
    Hero create(Hero hero);
}
