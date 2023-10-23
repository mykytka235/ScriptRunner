package mykytka235.ms.scriptrunner.web.contoller;

import mykytka235.ms.scriptrunner.service.ServiceProvider;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserController {

    private final ServiceProvider serviceProvider;

    @DeleteMapping
    public void deleteUser(@RequestParam String customerId) {
        log.info("Request to delete user. CustomerId = {}.", customerId);
        serviceProvider.deleteUser(customerId);
        log.info("Request to delete user processed.");
    }

}
