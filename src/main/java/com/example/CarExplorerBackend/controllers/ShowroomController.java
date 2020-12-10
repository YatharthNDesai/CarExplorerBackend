package com.example.CarExplorerBackend.controllers;

import com.example.CarExplorerBackend.models.Showroom;
import com.example.CarExplorerBackend.models.Staff;
import com.example.CarExplorerBackend.repositories.ShowroomRepository;
import com.example.CarExplorerBackend.repositories.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ShowroomController {

    @Autowired
    ShowroomRepository repository;

    @Autowired
    StaffRepository staffRepository;

    @GetMapping("/api/showrooms")
    public List<Showroom> getAllShowrooms() {
        return (List<Showroom>) repository.findAll();
    }

    @PostMapping("/api/showroom")
    public Showroom createShowroom(@RequestBody Showroom showroom) {
        return repository.save(showroom);
    }

    @PutMapping("/api/showrooms/{showroomId}/staff/{staffId}")
    public Showroom changeManager(@PathVariable("showroomId") Integer showroomId,
                               @PathVariable("staffId")Integer staffId) {
        Showroom showroom = repository.findById(showroomId).get();
        showroom.getManager().setManager(false);
        showroom.setManager(staffRepository.findById(staffId).get());
        showroom.getManager().setManager(true);
        return repository.save(showroom);
    }
}
