package br.com.gubee.interview.application.gateway;

import br.com.gubee.interview.core.domain.Hero;

import java.util.UUID;

public interface UpdateHeroGateway {
    Hero updateById(UUID id, Hero hero);
}
