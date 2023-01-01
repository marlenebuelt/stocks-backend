package de.stockexchange.stocks.web;

import de.stockexchange.stocks.service.SharesService;
import de.stockexchange.stocks.web.api.Share;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SharesRestController.class)
class SharesRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SharesService sharesService;

    @Test
    @DisplayName("should return found shares from shares service")
    void should_return_found_share_from_share_service() throws Exception {
        // given
        var shares = List.of(
                new Share(1, "1234", "Apple", BigDecimal.valueOf(100), true),
                new Share(2, "5678", "Google", BigDecimal.valueOf(200), false)
        );
        doReturn(shares).when(sharesService).findAll();

        // when
        mockMvc.perform(get("/api/v1/shares"))
                // then
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].wkn").value("1234"))
                .andExpect(jsonPath("$[0].name").value("Apple"))
                .andExpect(jsonPath("$[0].stocksPrice").value(BigDecimal.valueOf(100)))
                .andExpect(jsonPath("$[0].buy").value(true))
                .andExpect(jsonPath("$[1].wkn").value("5678"))
                .andExpect(jsonPath("$[1].name").value("Google"))
                .andExpect(jsonPath("$[1].stocksPrice").value(BigDecimal.valueOf(200)))
                .andExpect(jsonPath("$[1].buy").value(false));
    }

    @Test
    @DisplayName("should return 404 if share is not found")
    void should_return_404_if_share_is_not_found() throws Exception {
        // given
        doReturn(null).when(sharesService).findById(anyLong());

        // when
        mockMvc.perform(get("/api/v1/shares/123"))
                // then
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("should return 201 http status and Location header when creating a share")
    void should_return_201_http_status_and_location_header_when_creating_a_share() throws Exception {
        // given
        String shareToCreateAsJson = "{\"wkn\": \"1234\", \"name\":\"Apple\", \"stocksPrice\":\"100\", \"buy\": false}";
        var share = new Share(123, null, null, null, false);
        doReturn(share).when(sharesService).create(any());

        // when
        mockMvc.perform(
                        post("/api/v1/shares")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(shareToCreateAsJson)
                )
                // then
                .andExpect(status().isCreated())
                .andExpect(header().exists("Location"))
                .andExpect(header().string("Location", Matchers.equalTo(("/api/v1/shares/" + share.getId()))));
//            .andExpect(header().string("Location", Matchers.containsString(Long.toString(person.getId()))));

    }

    @Test
    @DisplayName("should validate create share request")
    void should_validate_create_shares_request() throws Exception {
        // given
        String shareToCreateAsJson = "{\"wkn\": \"12345\", \"name\":\"\", \"stocksPrice\":\"150\", \"buy\": true}";

        // when
        mockMvc.perform(
                        post("/api/v1/shares")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(shareToCreateAsJson)
                )
                // then
                .andExpect(status().isBadRequest());
    }
}
