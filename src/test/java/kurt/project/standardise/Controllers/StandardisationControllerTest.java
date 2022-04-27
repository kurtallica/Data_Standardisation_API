package kurt.project.standardise.Controllers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//Ask Spring Boot to search for main config and start a spring application context.
//Ask SpringRunner to automatically configure the Mock MVC.
@SpringBootTest
@AutoConfigureMockMvc
public class StandardisationControllerTest {

    //Starts a mock HTTP servlet which allows us to test our @RestController class
    // without the cost of starting a Web server.
    @Autowired
    private MockMvc mvc;

    @Test
    @DisplayName("Test fullStandardise endpoint returns success status code when given string")
    public void testFullStandardiseEndpointWithStringParameter() throws Exception {

        this.mvc.perform(get("/full-standardise?term=Tuomas Petäjä, 21056879"))
                .andExpect(status().isOk())
                .andExpect(content().string("{\"output\":\"TUOMAS PETAJA \"}"))
                .andDo(print());
    }

    @Test
    @DisplayName("Test fullStandardise endpoint returns success status code when given empty string")
    public void testFullStandardiseEndpointWithEmptyStringParameter() throws Exception {

        this.mvc.perform(get("/full-standardise?term="))
                .andExpect(status().isOk())
                .andExpect(content().string("{\"output\":\"\"}"))
                .andDo(print());
    }

    @Test
    @DisplayName("Test GET method on endpoint returns bad request status code when parameter term is null.")
    public void testFullStandardiseEndpointWithNullValueParameter() throws Exception {

        this.mvc.perform(get("/full-standardise")
                        .param("term", (String) null))
                .andExpect(status().isBadRequest())
//                .andExpect(content().string("{\"output\":\"\"}"))
                .andDo(print());

    }

    @Test
    @DisplayName("Test multipleStandardise endpoint returns success status code given correct parameters")
    public void testMultipleStandardiseEndpointWithParameters() throws Exception {

        this.mvc.perform(post("/multiple-standardise")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"term\":\"Tuomas Petäjä, 21056879\", " +
                                "\"standardisers\":[\"toUpperCase\", \"removePunctuation\"]}"))
                .andExpect(status().isOk())
                .andExpect(content().string("{\"output\":\"TUOMAS PETÄJÄ 21056879\"}"))
                .andDo(print());
    }

    @Test
    @DisplayName("Test multipleStandardise endpoint returns bad request status code given incorrect parameters")
    public void testMultipleStandardiseEndpointWithIncorrectParameters() throws Exception {

        this.mvc.perform(post("/multiple-standardise")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"term\":\"Tuomas Petäjä, 21056879\", " +
                                "\"standardisers\":[\"toLoweredCase\", \"removePunct\"]}"))
                .andExpect(status().isBadRequest())
                .andDo(print());
    }

    @Test
    @DisplayName("Test singleStandardise endpoint returns success status code given correct parameters")
    public void testSingleStandardiseEndpointWithParameters() throws Exception {
        this.mvc.perform(get("/single-standardise")
                        .param("term", "Tuomas Petäjä, 21056879")
                        .param("standardiserInput", "toUpperCase"))
                .andExpect(status().isOk())
                .andExpect(content().string("{\"output\":\"TUOMAS PETÄJÄ, 21056879\"}"))
                .andDo(print());
    }

    @Test
    @DisplayName("Test singleStandardise endpoint returns bad request status code when parameter term is null.")
    public void testSingleStandardiseEndpointWithNullTermInput() throws Exception {
        this.mvc.perform(get("/single-standardise")
                        .param("term", (String) null)
                        .param("standardiserNameInput", "toUpperCase"))
                .andExpect(status().isBadRequest())
//                .andExpect(content().string("{\"output\":\"\"}"))
                .andDo(print());
    }

    @Test
    @DisplayName("Test singleStandardise endpoint returns bad request status code given incorrect parameters")
    public void testSingleStandardiseEndpointWithIncorrectParameters() throws Exception {
        this.mvc.perform(get("/single-standardise")
                        .param("term", "Tuomas Petäjä, 21056879")
                        .param("standardiserNameInput", "toLowerCase"))
                .andExpect(status().isBadRequest())
                //                .andExpect(content().string("{\"output\":\"\"}"))
                .andDo(print());
    }
}
