package de.stockexchange.stocks.service;

import de.stockexchange.stocks.persistance.SharesRepository;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SharesServiceTest implements WithAssertions {

    @Mock
    private SharesRepository sharesRepository;
    @InjectMocks
    private SharesService sharesService;

    @Test
    @DisplayName("Returns true if delete was successful")
    void returns_true_if_delete_successful() {
        Long idActual = 1L;
        doReturn(true).when(sharesRepository).existsById(idActual);

        boolean actual = sharesService.deleteById(idActual);

        verify(sharesRepository).deleteById(idActual);
        assertThat(actual).isTrue();
    }

    @Test
    @DisplayName("Returns false if delete failed")
    void returns_falls_if_delete_failed() {
        Long idActual = 1L;
        doReturn(false).when(sharesRepository).existsById(idActual);

        boolean actual = sharesService.deleteById(idActual);

        verifyNoMoreInteractions(sharesRepository);
        assertThat(actual).isFalse();
    }
/*    @Test
    @DisplayName("Checks if an item is returned correctly")
    void test_find_by_id() {
        var sharesEntity = Mockito.mock(SharesEntity.class);
        doReturn(1L).when(sharesEntity).getId();
        doReturn("Apple").when(sharesEntity).getName();
        doReturn(BigDecimal.valueOf(100.50)).when(sharesEntity).getStocksPrice();
        doReturn("123456").when(sharesEntity).getWkn();
        doReturn(true).when(sharesEntity).isBuy();


    }*/
}
