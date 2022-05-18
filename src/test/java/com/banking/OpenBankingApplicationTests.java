package com.banking;


import java.io.FileReader;
import java.lang.reflect.Array;

import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.banking.controller.ATMController;
import com.banking.repository.ATMRepository;
import com.banking.service.ATMService;
import com.banking.util.BasicReadWebClient;

import net.minidev.json.parser.JSONParser;


@RunWith(SpringRunner.class)
@WebMvcTest({ATMController.class,ATMService.class,ATMRepository.class,BasicReadWebClient.class})
class OpenBankingApplicationTests {


@Autowired
private MockMvc mockMvc;


/*
* @Before public void setup() { mockMvc =
* MockMvcBuilders.webAppContextSetup(webApplicationContext).build(); }
*/

@Test
void getATMByIdentifier() throws Exception {
RequestBuilder rb=MockMvcRequestBuilders.get("http://localhost:8080/atms?identification=LFFFBC11").accept(MediaType.APPLICATION_JSON);

MvcResult mvR= mockMvc.perform(rb).andReturn();
System.out.println(mvR.getResponse().getStatus());
Assert.assertEquals(mvR.getResponse().getStatus(), 200);
String test= mvR.getResponse().getContentAsString();
String[] value= test.split(",")[0].split(":");
String iden = value[1];
Assert.assertEquals("Indentfaction did'nt match",iden.replaceAll("^\"|\"$", ""), "LFFFBC11");
}

}
