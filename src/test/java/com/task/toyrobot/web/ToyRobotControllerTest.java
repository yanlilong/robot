package com.task.toyrobot.web;

import org.junit.Test;

import static org.junit.Assert.assertThat;

import java.net.URL;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ToyRobotControllerTest {


  @LocalServerPort
  private int port;

  private URL base;

  @Autowired
  private TestRestTemplate template;

  @Before
  public void setUp() throws Exception {
    this.base = new URL("http://localhost:" + port + "/api/v1/toy-robot");
    this.base = new URL("http://localhost:" + port + "/toy-robot");
  }

  @Test
  public void showRobotPlace() throws Exception {
  }

  @Test
  public void placeExceptionHandler() throws Exception {
  }

  @Test
  public void actionExceptionHandler() throws Exception {
  }

  @Test
  public void report() throws Exception {
  }

}