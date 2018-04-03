package be.superteam.controller;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

import be.superteam.model.dto.ProjetDTO;
import be.superteam.model.entity.Statut;
import be.superteam.service.CategorieService;
import be.superteam.service.UserService;
import org.springframework.web.bind.annotation.*;

import be.superteam.model.entity.Projet;
import be.superteam.service.ProjetService;

@RestController
@RequestMapping("/api")
public class ProjetController {

	private final ProjetService projetService;
	private final UserService userService;
	private final CategorieService categorieService;

	protected ProjetController(ProjetService projetService, UserService userService, CategorieService categorieService) {
		this.projetService = projetService;
		this.userService = userService;
        this.categorieService = categorieService;
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

	@PostMapping("/user/projet/")
	public ProjetDTO createProjet(@RequestBody ProjetDTO projetDto, Principal principal) {
		return new ProjetDTO(projetService.save(projetDto.toProjet(
		        userService.findByUsername(principal.getName()),
                categorieService.findById(projetDto.getCategorieId()),
                Statut.PUBLIE
        )));
	}
}
