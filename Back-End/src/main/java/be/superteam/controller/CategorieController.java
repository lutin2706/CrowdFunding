package be.superteam.controller;

import be.superteam.model.dto.CategorieDTO;
import be.superteam.model.dto.ProjetDTO;
import be.superteam.model.entity.Categorie;
import be.superteam.model.entity.Projet;
import be.superteam.service.CategorieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class CategorieController {

    private final CategorieService categorieService;

    public CategorieController(CategorieService categorieService) {
        this.categorieService = categorieService;
    }

    @GetMapping("/categories")
    public List<CategorieDTO> getCategories() {
        List<Categorie> categories = categorieService.findCategories();
        return categories.stream().map(cat -> new CategorieDTO(cat)).collect(Collectors.toList());
    }
}
