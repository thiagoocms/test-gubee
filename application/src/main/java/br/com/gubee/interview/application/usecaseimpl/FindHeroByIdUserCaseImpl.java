package br.com.gubee.interview.application.usecaseimpl;

import br.com.gubee.interview.application.gateway.FindHeroByIdGateway;
import br.com.gubee.interview.core.domain.Hero;
import br.com.gubee.interview.core.exception.ResourceNotFoundException;
import br.com.gubee.interview.usecase.FindHeroByIdUseCase;

import java.util.UUID;

public class FindHeroByIdUserCaseImpl implements FindHeroByIdUseCase {

    private final FindHeroByIdGateway findHeroByIdGateway;

    public FindHeroByIdUserCaseImpl(FindHeroByIdGateway findHeroByIdGateway) {
        this.findHeroByIdGateway = findHeroByIdGateway;
    }

    @Override
    public Hero findById(UUID id) {
        Hero hero = this.findHeroByIdGateway.findById(id);
        if (hero == null) {
            throw new ResourceNotFoundException("");
        }
        return hero;
    }
}
