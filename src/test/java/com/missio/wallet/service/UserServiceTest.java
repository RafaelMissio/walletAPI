package com.missio.wallet.service;

import com.missio.wallet.entity.User;
import com.missio.wallet.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class UserServiceTest {

    @MockBean
    UserRepository repository;

    @Autowired
    UserService service;

    @Before
    public void setup(){
        given(repository.findByEmail(Mockito.anyString())).willReturn(Optional.of(new User()));
    }

    @Test
    public void finByEmail(){
        Optional<User> user = service.findByEmail("email@teste");

        assertTrue(user.isPresent());
    }
}
