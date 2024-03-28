package br.com.gubee.interview.application.gateway;

import br.com.gubee.interview.core.domain.Hero;

import java.util.UUID;

public interface FindHeroByIdGateway {
    Hero findById(UUID id);
}
