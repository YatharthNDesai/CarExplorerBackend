package com.example.CarExplorerBackend.controllers;

import com.example.CarExplorerBackend.models.Showroom;
import com.example.CarExplorerBackend.models.Staff;
import com.example.CarExplorerBackend.repositories.ShowroomRepository;
import com.example.CarExplorerBackend.repositories.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
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
}
