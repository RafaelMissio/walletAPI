package com.missio.wallet.repository;

import com.missio.wallet.entity.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class UserRepositoryTest {

    private static final String EMAIL= "email@teste.com";

    @Autowired
    UserRepository userRepository;

    @Before
    public void setup(){
        User userTest = new User();
        userTest.setName("Teste Setup");
        userTest.setEmail(EMAIL);
        userTest.setPassword("senha123");

         userRepository.save(userTest);
    }

    @After
    public void tearDown(){
        userRepository.deleteAll();
    }

    @Test
    public void testUserSave(){
        User user = new User();
        user.setName("Teste");
        user.setEmail("teste@teste.com.br");
        user.setPassword("123456");

        User response = userRepository.save(user);

        Assert.assertNotNull(response);
    }

    @Test
    public void findByEmail(){
       Optional<User> response = userRepository.findByEmail(EMAIL);

       assertTrue(response.isPresent());
       assertEquals(response.get().getEmail(), EMAIL);

    }

}
