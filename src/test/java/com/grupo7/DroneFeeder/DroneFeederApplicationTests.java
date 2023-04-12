package com.grupo7.DroneFeeder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.grupo7.DroneFeeder.Entity.Drone;
import com.grupo7.DroneFeeder.Repository.DroneRepository;

@SpringBootTest
@AutoConfigureMockMvc
class DroneFeederApplicationTests {
  @Autowired
  private MockMvc mockMvc;

  @SpyBean
  private DroneRepository droneRepository;

  @BeforeEach
  void clean() {
    droneRepository.deleteAll();
  }


  @Test
  @DisplayName("[POST] Cria um novo drone")
  void createNewDrone() throws Exception {
    final var testDrone = new Drone(null, "100", "100");

    final var resposta = mockMvc.perform(post("/drone").contentType(MediaType.APPLICATION_JSON)
        .content(new ObjectMapper().writeValueAsString(testDrone)));

    resposta.andExpect(status().isCreated())
        .andExpect(jsonPath("$.latitude").value(testDrone.getLatitude()))
        .andExpect(jsonPath("$.longitude").value(testDrone.getLongitude()))
        .andExpect(jsonPath("$.entrega").value(testDrone.getEntrega()));

  }

  @Test
  @DisplayName("[GET] Lista todos os drones")
  void findAllDrones() throws Exception {
    final var testDrone1 = new Drone(null, "100", "100");
    final var testDrone2 = new Drone(null, "200", "200");
    final var testDrone3 = new Drone(null, "300", "300");

    droneRepository.save(testDrone1);
    droneRepository.save(testDrone2);
    droneRepository.save(testDrone3);

    final var resposta = mockMvc.perform(get("/drone").contentType(MediaType.APPLICATION_JSON));

    resposta.andExpect(status().isOk())
        .andExpect(jsonPath("$[0].latitude").value(testDrone1.getLatitude()))
        .andExpect(jsonPath("$[0].longitude").value(testDrone1.getLongitude()))
        .andExpect(jsonPath("$[0].entrega").value(testDrone1.getEntrega()));

  }

  @Test
  @DisplayName("[GET] Retorna o drone pelo id")
  void findOneDrone() throws Exception {
    final var testDrone = new Drone(null, "100", "100");

    droneRepository.save(testDrone);

    final var resposta =
        mockMvc.perform(get("/drone/" + testDrone.getId()).contentType(MediaType.APPLICATION_JSON));

    resposta.andExpect(status().isOk()).andExpect(jsonPath("$.id").value(testDrone.getId()))
        .andExpect(jsonPath("$.latitude").value(testDrone.getLatitude()))
        .andExpect(jsonPath("$.longitude").value(testDrone.getLongitude()))
        .andExpect(jsonPath("$.entrega").value(testDrone.getEntrega()));

  }

  @Test
  @DisplayName("[DELETE] Exclui um drone")
  void deleteDrone() throws Exception {
    final var testDrone = new Drone(null, "100", "100");

    droneRepository.save(testDrone);

    final var resposta = mockMvc
        .perform(delete("/drone/" + testDrone.getId()).contentType(MediaType.APPLICATION_JSON));

    resposta.andExpect(status().isOk());

  }

}
