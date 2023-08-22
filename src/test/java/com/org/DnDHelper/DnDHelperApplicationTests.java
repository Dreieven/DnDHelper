package com.org.DnDHelper;

import com.org.DnDHelper.repositories.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.util.Optional;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;

@SpringBootTest
class DnDHelperApplicationTests {

	@BeforeEach
	public void setUp() {

		Mockito.when(userRepository.count()).thenReturn(new Long(9));
	}

	@Test
	void contextLoads() {
		Long countRes = new Long(9);
		Assertions.assertEquals(countRes, userRepository.count());
		System.out.println(userRepository.count());
		Mockito.verify(userRepository, times(2)).count();
	}

	@MockBean
	public UserRepository userRepository;

}
