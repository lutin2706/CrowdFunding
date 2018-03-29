package be.superteam.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import be.superteam.model.entity.Projet;
import be.superteam.service.ProjetService;

@RestController
@RequestMapping("/api/admin")
public class ProjetController {

	private final ProjetService projetService;

	protected ProjetController(ProjetService projetService) {
		this.projetService = projetService;
	}
	
	@GetMapping("/projets")
	public List<Projet> getProjets() {
		return projetService.findAll();
	}
}
