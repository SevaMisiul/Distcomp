package by.bsuir.distcomp.service;

import by.bsuir.distcomp.dto.mapper.AuthorMapper;
import by.bsuir.distcomp.dto.mapper.MarkerMapper;
import by.bsuir.distcomp.dto.request.MarkerRequestTo;
import by.bsuir.distcomp.dto.response.MarkerResponseTo;
import by.bsuir.distcomp.entity.Marker;
import by.bsuir.distcomp.repository.MarkerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarkerService {

    private final MarkerRepository markerRepository;
    private final MarkerMapper markerMapper;

    public MarkerService(MarkerRepository markerRepository, MarkerMapper markerMapper) {
        this.markerRepository = markerRepository;
        this.markerMapper = markerMapper;
    }

    public List<MarkerResponseTo> getAllMarkers() {
        return markerRepository.findAll().stream().map(markerMapper::toDto).toList();
    }

    public MarkerResponseTo getMarkerById(Long id) {
        return markerMapper.toDto(markerRepository.findById(id));
    }

    public MarkerResponseTo createMarker(MarkerRequestTo markerRequestTo) {
        return markerMapper.toDto(markerRepository.create(markerMapper.toEntity(markerRequestTo)));
    }

    public MarkerResponseTo updateMarker(MarkerRequestTo markerRequestTo) {
        return markerMapper.toDto(markerRepository.update(markerMapper.toEntity(markerRequestTo)));
    }

    public void deleteMarker(Long id) {
        markerRepository.deleteById(id);
    }
    
}
