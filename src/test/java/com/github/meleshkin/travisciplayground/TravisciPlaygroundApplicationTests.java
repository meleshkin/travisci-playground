package com.github.meleshkin.travisciplayground;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class TravisciPlaygroundApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void homePageTest() throws Exception {
		mockMvc.perform(get("/"))
				.andExpect(status().isOk());
	}

	@Test
	public void notFoundTest() throws Exception {
		mockMvc.perform(get("/404"))
				.andExpect(status().isNotFound());
	}

	@Test
	public void timePageTest() throws Exception {
		LocalDateTime a = LocalDateTime.now();

		mockMvc.perform(get("/time"))
				.andExpect(status().isOk())
				.andExpect(
						mvcResult -> {
							String content = mvcResult.getResponse()
									.getContentAsString();
							Locale locale = Locale.forLanguageTag("en");
							DateTimeFormatter dateTimeFormatter =  DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).withLocale(locale);
							LocalDateTime b =  LocalDateTime.parse(content, dateTimeFormatter);
							Assert.assertTrue(a.isBefore(b));
						}
				);

	}

}
