import br.com.gubee.interview.infrastructure.Application;
import br.com.gubee.interview.infrastructure.constants.AppConstants;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = {Application.class})
@ActiveProfiles("test")
@SpringJUnitConfig
@AutoConfigureMockMvc
public class ApplicationIt {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetHealthCheck() throws Exception {
        mockMvc.perform(get(AppConstants.URL_SUFFIX + "health"))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void testGetHeroes() throws Exception {
        mockMvc.perform(get(AppConstants.PATH + AppConstants.API + AppConstants.V1 +
                        AppConstants.URL_SUFFIX + "heroes"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$").isNotEmpty())
                .andExpect(jsonPath("$[0].hero_id").exists())
                .andExpect(jsonPath("$[0].name", notNullValue()))
                .andExpect(jsonPath("$[0].race", notNullValue()))
                .andReturn();
    }

    @Test
    public void testCreateHero() throws Exception {
        String requestBody = "{ " +
                "\"name\": \"Superman\", " +
                "\"race\": \"ALIEN\", " +
                "\"strength\": 100, " +
                "\"agility\": 90, " +
                "\"dexterity\": 80, " +
                "\"intelligence\": 70 " +
                "}";

        mockMvc.perform(post(AppConstants.PATH + AppConstants.API + AppConstants.V1 +
                        AppConstants.URL_SUFFIX + "heroes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isCreated())
                .andReturn();
    }
}
