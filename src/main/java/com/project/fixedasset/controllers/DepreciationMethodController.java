package com.project.fixedasset.controllers;

import com.project.fixedasset.DepreciationMethod;
import com.project.fixedasset.repositories.DepreciationMethodRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/depreciation-methods")
@Data
public class DepreciationMethodController {
    @Autowired
    private DepreciationMethodRepository depreciationMethodRepo;

    @GetMapping
    public List<DepreciationMethod> getDepreciationMethods() {
        return depreciationMethodRepo.findAll();
    }
}
