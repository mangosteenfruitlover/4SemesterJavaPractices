import main.model.User;
import main.repository.UserRepository;
import main.services.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    @Mock
    private BCryptPasswordEncoder encoder;

    @Captor
    ArgumentCaptor<User> userArgumentCaptor;

    @Test
    void save() {
        User user = new User();
        user.setUsername("Misha");

        UserService userService = new UserService(userRepository, encoder);
        userService.registerUser(user);

        Mockito.verify(userRepository).save(userArgumentCaptor.capture());
        User captured = userArgumentCaptor.getValue();

        Assertions.assertEquals("Misha", captured.getUsername());
    }

    @Test
    void getUserByUsername() {
        User user1 = new User();
        User user2 = new User();

        user1.setUsername("Misha");
        user2.setUsername("Olga");

        UserService userService = new UserService(userRepository, encoder);

        Mockito.when(userRepository.findById(user1.getUsername()))
                .thenReturn(java.util.Optional.of(user1));
        Mockito.when(userRepository.findById(user2.getUsername()))
                .thenReturn(java.util.Optional.of(user2));

        Assertions.assertEquals("Misha",
                userService.loadUserByUsername(user1.getUsername())
                        .getUsername());
        Assertions.assertEquals("Olga",
                userService.loadUserByUsername(user2.getUsername())
                        .getUsername());
    }
}
