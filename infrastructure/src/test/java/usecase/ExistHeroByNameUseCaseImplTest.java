package usecase;

import br.com.gubee.interview.application.gateway.ExistHeroByNameGateway;
import br.com.gubee.interview.application.usecaseimpl.ExistHeroByNameUseCaseImpl;
import br.com.gubee.interview.core.domain.Hero;
import br.com.gubee.interview.core.exception.BadRequestException;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ExistHeroByNameUseCaseImplTest {

    @Mock
    private ExistHeroByNameGateway existHeroByNameGateway;

    private ExistHeroByNameUseCaseImpl existHeroByNameUseCase;

    public ExistHeroByNameUseCaseImplTest() {
        MockitoAnnotations.openMocks(this);
        this.existHeroByNameUseCase = new ExistHeroByNameUseCaseImpl(existHeroByNameGateway);
    }

    @Test
    void existByNameExistingNameThrowsBadRequestException() {
        // Arrange
        String name = "Superman";
        Hero existingHero = new Hero();
        existingHero.setName(name);
        when(existHeroByNameGateway.existByName(name)).thenReturn(existingHero);

        // Act and Assert
        assertThrows(BadRequestException.class, () -> {
            existHeroByNameUseCase.existByName(name);
        });
    }

    @Test
    void existByNameNonExistingNameDoesNotThrowException() {
        // Arrange
        String name = "Batman";
        when(existHeroByNameGateway.existByName(name)).thenReturn(null);

        // Act and Assert
        assertDoesNotThrow(() -> {
            existHeroByNameUseCase.existByName(name);
        });
    }
}
