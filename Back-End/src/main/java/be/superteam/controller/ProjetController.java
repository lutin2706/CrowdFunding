package be.superteam.controller;

import java.util.List;
import java.util.stream.Collectors;

import be.superteam.model.dto.ProjetDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import be.superteam.model.entity.Projet;
import be.superteam.service.ProjetService;

@RestController
@RequestMapping("/api")
public class ProjetController {

	private final ProjetService projetService;

	protected ProjetController(ProjetService projetService) {
		this.projetService = projetService;
	}
	
	@GetMapping("/projets")
	public List<ProjetDTO> getProjets() {
		List<Projet> projets = projetService.findAll();
		return projets.stream().map(projet -> new ProjetDTO(projet)).collect(Collectors.toList());
	}

	@GetMapping("/projetsVisibles")
	public List<ProjetDTO> getProjetsVisibles() {
		List<Projet> projets = projetService.findProjetsVisibles();
		return projets.stream().map(projet -> new ProjetDTO(projet)).collect(Collectors.toList());
	}

	@GetMapping("/projet/{id}")
	public ProjetDTO getProjet(@PathVariable("id") Long id) {
		return new ProjetDTO(projetService.findProjet(id));
	}
}
