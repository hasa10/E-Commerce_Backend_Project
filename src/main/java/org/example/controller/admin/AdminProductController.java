package org.example.controller.admin;

import lombok.RequiredArgsConstructor;
import org.example.service.admin.adminProduct.AdminProductService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminProductController {

    private final AdminProductService adminProductService;

}