package guru.springframework.spring5webfluxrestnolombok.controllers;

import guru.springframework.spring5webfluxrestnolombok.domain.Vendor;
import guru.springframework.spring5webfluxrestnolombok.repositories.VendorRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class VendorControllerTest {

    WebTestClient webTestClient;
    VendorRepository vendorRepository;
    VendorController vendorController;

    @Before
    public void setUp() throws Exception {
        vendorRepository = Mockito.mock(VendorRepository.class);
        vendorController = new VendorController(vendorRepository);
        webTestClient = WebTestClient.bindToController(vendorController).build();
    }

    @Test
    public void list() {
        BDDMockito.given(vendorRepository.findAll())
                .willReturn(Flux.just(new Vendor("JB", "Joe", "Black"),//Vendor.builder().firstName("Joe").lastName("Black").build(),
                        new Vendor("JS", "John", "Smith")));//Vendor.builder().firstName("John").lastName("Smith").build()));

        webTestClient.get().uri("/api/v1/vendors")
                .exchange()
                .expectBodyList(Vendor.class)
                .hasSize(2);
    }

    @Test
    public void getById() {
        BDDMockito.given(vendorRepository.findById("someid"))
                .willReturn(Mono.just(new Vendor("JS", "John", "Smith")));//Vendor.builder().firstName("John").lastName("Smith").build()));

        webTestClient.get().uri("/api/v1/vendors/someid")
                .exchange()
                .expectBody(Vendor.class);
    }
}