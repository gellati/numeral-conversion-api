package org.conversionapplication.controllers;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.net.URL;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


/**
 * Integration tests to see how well the API works
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ConversionControllerIT {


    private String query = "?number=6&source=decimal&target=roman";
    @LocalServerPort
    private int port;

    private URL base;
    private URL conversionUrl;

    @Autowired
    private TestRestTemplate template;
    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        this.base = new URL("http://localhost:" + port + "/api");
        this.conversionUrl = new URL("http://localhost:" + port + "/api/conversion");
    }

    @Test
    public void getBasicDescription() throws Exception {
        ResponseEntity<String> response = template.getForEntity(base.toString(),
                String.class);
        assertThat(response.getBody(), equalTo("The org system converter"));
    }

    @Test
    public void getConversion() throws Exception {
        String expected = "{\"sourceNumeralSystem\":\"decimal\",\"sourceNumber\":\"6\",\"targetNumeralSystem\":\"roman\",\"targetNumber\":\"VI\"}";

        ResponseEntity<String> response = template.getForEntity(conversionUrl.toString() + query,
                String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        JSONAssert.assertEquals(expected, response.getBody(), false);

    }

    @Test
    public void postConversion() throws Exception {
        String postBody = "{\"source\":\"decimal\",\"number\":\"6\",\"target\":\"roman\"}";
        String expected = "{\n" +
                "    \"sourceNumeralSystem\": \"decimal\",\n" +
                "    \"sourceNumber\": \"6\",\n" +
                "    \"targetNumeralSystem\": \"roman\",\n" +
                "    \"targetNumber\": \"VI\"\n" +
                "}";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<String>(postBody, headers);

        ResponseEntity<String> response = template.postForEntity(conversionUrl.toString(),
                entity, String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        JSONAssert.assertEquals(expected, response.getBody(), false);

    }
}
