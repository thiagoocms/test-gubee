package br.com.gubee.interview.application.usecaseimpl;

import br.com.gubee.interview.application.gateway.ExistHeroByNameGateway;
import br.com.gubee.interview.application.gateway.FindHeroByNameGateway;
import br.com.gubee.interview.core.domain.Hero;
import br.com.gubee.interview.core.exception.BadRequestException;
import br.com.gubee.interview.usecase.ExistHeroByNameUseCase;
import br.com.gubee.interview.usecase.FindHeroByNameUseCase;

import java.util.Set;

public class ExistHeroByNameUserCaseImpl implements ExistHeroByNameUseCase {

    private final ExistHeroByNameGateway existHeroByNameGateway;

    public ExistHeroByNameUserCaseImpl(ExistHeroByNameGateway existHeroByNameGateway) {
        this.existHeroByNameGateway = existHeroByNameGateway;
    }

    @Override
    public void existByName(String name) {
        Hero hero = existHeroByNameGateway.existByName(name);
        if (hero != null) {
            throw new BadRequestException("Ja existe um heroi com esse nome.");
        }
    }
}
