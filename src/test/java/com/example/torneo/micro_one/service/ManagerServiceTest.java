package com.example.torneo.micro_one.service;

import com.example.torneo.micro_one.model.Manager;
import com.example.torneo.micro_one.repository.ManagerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.Arrays;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class ManagerServiceTest {
    @Mock
    private ManagerRepository repository;

    @InjectMocks
    private ManagerService service;

    private Manager manager;

    @BeforeEach
    public void setUp() {
        manager = new Manager();
        manager.setId(1);
        manager.setName("John Doe");
        manager.setPhone("123456789");
        manager.setEmail("john.doe@example.com");
    }

    @Test
    public void testSaveManager() {
        Mockito.when(repository.save(Mockito.any(Manager.class))).thenReturn(manager);

        Mono<Manager> result = service.saveManager(manager);

        StepVerifier.create(result)
                .expectNext(manager)
                .verifyComplete();

        Mockito.verify(repository, Mockito.times(1)).save(manager);
    }

    @Test
    public void testGetManagerById() {
        Mockito.when(repository.findById(1)).thenReturn(Optional.of(manager));

        Mono<Manager> result = service.getManagerById(1);

        StepVerifier.create(result)
                .expectNext(manager)
                .verifyComplete();

        Mockito.verify(repository, Mockito.times(1)).findById(1);
    }

    @Test
    public void testGetAllManagers() {
        Mockito.when(repository.findAll()).thenReturn(Arrays.asList(manager));

        Flux<Manager> result = service.getAllManagers();

        StepVerifier.create(result)
                .expectNext(manager)
                .verifyComplete();

        Mockito.verify(repository, Mockito.times(1)).findAll();
    }
}
