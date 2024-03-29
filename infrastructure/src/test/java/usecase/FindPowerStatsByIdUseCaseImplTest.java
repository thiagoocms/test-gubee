package usecase;

import br.com.gubee.interview.application.gateway.FindPowerStatsByIdGateway;
import br.com.gubee.interview.application.usecaseimpl.FindPowerStatsByIdUseCaseImpl;
import br.com.gubee.interview.core.domain.PowerStats;
import br.com.gubee.interview.core.exception.ResourceNotFoundException;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class FindPowerStatsByIdUseCaseImplTest {

    @Mock
    private FindPowerStatsByIdGateway powerStatsByIdGateway;

    private FindPowerStatsByIdUseCaseImpl findPowerStatsByIdUseCase;

    public FindPowerStatsByIdUseCaseImplTest() {
        MockitoAnnotations.openMocks(this);
        this.findPowerStatsByIdUseCase = new FindPowerStatsByIdUseCaseImpl(powerStatsByIdGateway);
    }

    @Test
    void findByIdExistingIdReturnsPowerStats() {
        // Arrange
        UUID id = UUID.randomUUID();
        PowerStats expectedPowerStats = new PowerStats();
        when(powerStatsByIdGateway.findById(id)).thenReturn(expectedPowerStats);

        // Act
        PowerStats result = findPowerStatsByIdUseCase.findById(id);

        // Assert
        assertEquals(expectedPowerStats, result);
    }

    @Test
    void findByIdNonExistingIdThrowsResourceNotFoundException() {
        // Arrange
        UUID id = UUID.randomUUID();
        when(powerStatsByIdGateway.findById(id)).thenReturn(null);

        // Act and Assert
        assertThrows(ResourceNotFoundException.class, () -> {
            findPowerStatsByIdUseCase.findById(id);
        });
    }
}
