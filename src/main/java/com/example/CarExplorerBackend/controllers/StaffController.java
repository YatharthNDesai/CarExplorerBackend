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
public class StaffController {

    @Autowired
    StaffRepository repository;
    @Autowired
    ShowroomRepository showroomRepository;

    @PostMapping("/api/staffs/{showroomId}")
    public Staff createStaff(@PathVariable("showroomId") Integer sid,
                             @RequestBody() Staff staff) {
        staff.setShowroom(showroomRepository.findById(sid).get());

        if (staff.getManager()) {
            if (staff.getShowroom().getManager() == null) {
                staff.getShowroom().setManager(staff);
            }
            else{
                staff.setManager(false);
            }
        }
        return repository.save(staff);
    }

    @GetMapping("/api/staff")
    public List<Staff> getAllStaff(){
        return (List<Staff>) repository.findAll();
    }

    @DeleteMapping("/api/staff/{staffId}")
    public int deleteStaff(@PathVariable("staffId") Integer staffId) {
        repository.deleteById(staffId);
        return 1;   
    }
}
