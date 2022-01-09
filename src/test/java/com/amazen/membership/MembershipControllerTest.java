package com.amazen.membership;

import com.amazen.membership.domain.Membership;
import com.amazen.membership.exposition.MembershipController;
import com.amazen.membership.exposition.MembershipRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@WebMvcTest(Membership.class) // target the controller
@AutoConfigureMockMvc(addFilters = false) // disable spring security
//@ContextConfiguration(classes = {PoundaControllerApplication.class, FoodControllerTestConfiguration.class})
public class MembershipControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper mapper;

    @InjectMocks
    private MembershipController controller;

    @Before
    public void setup() {
        this.mvc = MockMvcBuilders.standaloneSetup(new Membership()).build();
    }


    @Test
    public void createContractorShouldSuccess() throws Exception {
        // Given
//        final MembershipRequest membershipRequest = new MembershipRequest("contractor@trade.me", "12345678", "1 rue du contractor", "Paris", "contractor");

        // When
//        Mockito.when(foodService.save(foodEntity)).thenReturn(foodEntity);
        mvc.perform(MockMvcRequestBuilders.get("/memberships")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
        // Then
//        mvc.perform(MockMvcRequestBuilders.post("/memberships")
//                        .content(mapper.writeValueAsString(membershipRequest))
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    public void createContractorShouldFail(){

    }

    @Test
    public void createTradesmanShouldSuccess(){

    }

    @Test
    public void createTradesmanShouldFail(){

    }
}
