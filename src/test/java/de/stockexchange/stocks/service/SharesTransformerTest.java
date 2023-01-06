package de.stockexchange.stocks.service;

import de.stockexchange.stocks.persistance.SharesEntity;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;

import static org.mockito.Mockito.doReturn;

public class SharesTransformerTest implements WithAssertions {

    private final SharesTransformer sharesTransformer = new SharesTransformer();

    @Test
    @DisplayName("transforms a shareentity into a share")
    void transform_shareEntity_into_share(){
        var sharesEntity = Mockito.mock(SharesEntity.class);
        doReturn(1L).when(sharesEntity).getId();
        doReturn("Apple").when(sharesEntity).getName();
        doReturn(BigDecimal.valueOf(100.50)).when(sharesEntity).getStocksPrice();
        doReturn("123456").when(sharesEntity).getWkn();
        doReturn(true).when(sharesEntity).isBuy();

        var actual = sharesTransformer.transformEntity(sharesEntity);

        assertThat(actual.getId()).isEqualTo(1);
        assertThat(actual.getName()).isEqualTo("Apple");
        assertThat(actual.getStocksPrice()).isEqualTo(BigDecimal.valueOf(100.50));
        assertThat(actual.getId()).isEqualTo(1);
        assertThat(actual.isBuy()).isEqualTo(true);
    }
}
