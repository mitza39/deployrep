package luxoft.example.springboot;

import luxoft.example.springboot.controller.BasicController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SpringRunner.class)
@WebMvcTest(BasicController.class)
public class ApplicationTests {

	@Autowired
	private MockMvc mvc;

	@Test
	public void welcome() throws Exception {
		ResultActions resultActions = mvc.perform(
				MockMvcRequestBuilders.get("/welcome")
						.accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				//.andExpect(MockMvcResultMatchers.content().string("Hello Woldr"))   --chiar merge
				.andExpect(MockMvcResultMatchers.content().string(equalTo("Hello world")));

	}

	@Test
	public void welcomeWithObject() throws Exception {
		ResultActions resultActions = mvc.perform(
				MockMvcRequestBuilders.get("/welcome-with-object")
						.accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				//.andExpect(MockMvcResultMatchers.content().string("Hello Woldr"))   --chiar merge
				.andExpect(MockMvcResultMatchers.content().string(containsString("Hello World")));

	}

	@Test
	public void welcomeWithParameter() throws Exception {
		ResultActions resultActions = mvc.perform(
				MockMvcRequestBuilders.get("/welcome-with-parameter/name/Mtz")
						.accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				//.andExpect(MockMvcResultMatchers.content().string("Hello Woldr"))   --chiar merge
				.andExpect(MockMvcResultMatchers.content().string(containsString("Hello World from Mtz")));

	}

}
