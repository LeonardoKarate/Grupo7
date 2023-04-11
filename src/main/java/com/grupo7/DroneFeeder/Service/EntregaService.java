package com.grupo7.DroneFeeder.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo7.DroneFeeder.Dto.EntregaDto;
import com.grupo7.DroneFeeder.Entity.Entrega;
import com.grupo7.DroneFeeder.Repository.EntregaRepository;

@Service
public class EntregaService {

  @Autowired
  private EntregaRepository repository;

  public Entrega create(EntregaDto entrega) {
    Entrega result = new Entrega();
    result.setData(entrega.getData());
    result.setEndereco(entrega.getEndereco());
    result.setStatus(entrega.getStatus());
    result.setDescricao(entrega.getDescricao());
    result.setVideoUrl(entrega.getVideoUrl());
    result = repository.save(result);
    return result;
  }

  public List<Entrega> findAll() {
    return repository.findAll();
  }

  public Entrega findById(Long id) {
    return repository.findById(id).get();
  }

  public Entrega update(Entrega entrega) {
    Entrega result = repository.save(entrega);
    return result;
  }

  public String delete(Long id) {
    repository.deleteById(id);
    return "Entrega removida com sucesso";
  }

  public List<String> findAllVideos() {
    List<Entrega> results = repository.findAll();
    List<String> videos = new ArrayList<>();

    for (Entrega entrega : results) {
      videos.add(entrega.getVideoUrl());
    }

    return videos;
  }

  public String findVideo(Long id) {
    Entrega result = repository.findById(id).get();
    return result.getVideoUrl();
  }
}
