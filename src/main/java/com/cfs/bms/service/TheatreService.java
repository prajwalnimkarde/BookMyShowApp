package com.cfs.bms.service;

import com.cfs.bms.dto.TheatreDto;
import com.cfs.bms.exception.ResourceNotFoundException;
import com.cfs.bms.model.Theatre;
import com.cfs.bms.repository.TheatreRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TheatreService {

    @Autowired
    private TheatreRepository theatreRepository;

    @Transactional
    public TheatreDto createTheatre(TheatreDto theatreDto) {
        Theatre theatre = mapToEntity(theatreDto);
        Theatre savedTheatre = theatreRepository.save(theatre);
        return mapToDto(savedTheatre);
    }

    public TheatreDto getTheatreById(Long id) {
        Theatre theatre = theatreRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Theatre not found with id: "+id));

        return mapToDto(theatre);
    }

    public List<TheatreDto> getAllTheatre() {
        List<Theatre> theatres = theatreRepository.findAll();

        return theatres.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    public List<TheatreDto> getTheatreByCity(String city) {
        List<Theatre> theatres = theatreRepository.findByCity(city);

        return theatres.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    public TheatreDto updateTheatre(TheatreDto theatreDto) {
        Theatre theatre = theatreRepository.findById(theatreDto.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Theatre not found with id: "+theatreDto.getId()));

        theatre.setName(theatreDto.getName());
        theatre.setAddress(theatreDto.getAddress());
        theatre.setCity(theatreDto.getCity());
        theatre.setTotalScreen(theatreDto.getTotalScreens());

        Theatre updatedTheatre = theatreRepository.save(theatre);
        return mapToDto(updatedTheatre);
    }

    public String deleteTheatre(Long id) {
        theatreRepository.deleteById(id);
        return "Theatre with ID: "+id+ " deleted";
    }


    private Theatre mapToEntity(TheatreDto theatreDto){
        Theatre theatre = new Theatre();
        theatre.setName(theatreDto.getName());
        theatre.setAddress(theatreDto.getAddress());
        theatre.setCity(theatreDto.getCity());
        theatre.setTotalScreen(theatreDto.getTotalScreens());

        return theatre;
    }

    private TheatreDto mapToDto(Theatre theatre){
        TheatreDto theatreDto = new TheatreDto();

        theatreDto.setId(theatre.getId());
        theatreDto.setName(theatre.getName());
        theatreDto.setCity(theatre.getCity());
        theatreDto.setAddress(theatre.getAddress());
        theatreDto.setTotalScreens(theatre.getTotalScreen());

        return theatreDto;
    }
}
