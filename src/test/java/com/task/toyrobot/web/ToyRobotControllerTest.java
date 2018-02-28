package com.task.toyrobot.web;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.nio.charset.Charset;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

/**
 * Test {@link ToyRobotController}
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ToyRobotControllerTest {

  @Autowired
  private WebApplicationContext webApplicationContext;

  private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
      MediaType.APPLICATION_JSON.getSubtype(),Charset.forName("utf8"));

  private MockMvc mockMvc;

  @Before
  public void setUp() throws Exception {

    this.mockMvc = webAppContextSetup(webApplicationContext).build();
  }

  @Test
  public void showRobotPlace() throws Exception {
    mockMvc.perform(get("http://localhost:8080/api/v1/toy-robot?PLACE=1,2,EAST&ACTIONS=MOVE,MOVE,LEFT,MOVE,REPORT"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(contentType)).andExpect(jsonPath("$.x",is(3)))
        .andExpect(jsonPath("$.y",is(3)))
        .andExpect(jsonPath("$.direction",is("NORTH")));
  }
}