package usecase;

import br.com.gubee.interview.application.gateway.DeletePowerStatsGateway;
import br.com.gubee.interview.application.usecaseimpl.DeletePowerStatsUseCaseImpl;
import br.com.gubee.interview.core.domain.PowerStats;
import br.com.gubee.interview.usecase.FindPowerStatsByIdUseCase;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.UUID;

import static org.mockito.Mockito.*;

public class DeletePowerStatsUseCaseImplTest {

    @Mock
    private DeletePowerStatsGateway deletePowerStatsGateway;

    @Mock
    private FindPowerStatsByIdUseCase findPowerStatsByIdUseCase;

    private DeletePowerStatsUseCaseImpl deletePowerStatsUseCase;

    public DeletePowerStatsUseCaseImplTest() {
        MockitoAnnotations.openMocks(this);
        this.deletePowerStatsUseCase = new DeletePowerStatsUseCaseImpl(deletePowerStatsGateway, findPowerStatsByIdUseCase);
    }

    @Test
    void deleteByIdValidIdCallsGatewayToDeletePowerStats() {

        UUID id = UUID.randomUUID();
        PowerStats powerStats = new PowerStats();
        powerStats.setId(id);
        when(findPowerStatsByIdUseCase.findById(id)).thenReturn(powerStats);

        deletePowerStatsUseCase.deleteById(id);

        verify(findPowerStatsByIdUseCase, times(1)).findById(id);
        verify(deletePowerStatsGateway, times(1)).deleteById(id);
    }
}
