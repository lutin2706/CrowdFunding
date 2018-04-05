package be.superteam.config;

import be.superteam.model.entity.Categorie;
import be.superteam.model.entity.Projet;
import be.superteam.model.entity.Statut;
import be.superteam.model.entity.User;
import be.superteam.service.ProjetService;
import be.superteam.service.UserService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DbInit implements InitializingBean {

    private final UserService userService;
    private final ProjetService projetService;

    public DbInit(UserService userService, ProjetService projetService) {
        this.userService = userService;
        this.projetService = projetService;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

//        User sev = userService.register("sev", "sev", false);
//        User joelle = userService.register("joelle", "jojo", false);
//        User marc = userService.register("marc", "marc", false);
//        User mary = userService.register("marypoppins", "mp", false);
//        userService.register("admin", "admin", true);
//
//        Categorie loisirs_creatifs = projetService.save(new Categorie("Loisirs créatifs"));
//        Categorie dev_pero = projetService.save(new Categorie("Développement personnel"));
//        Categorie loisirs = projetService.save(new Categorie("Loisirs/sorties"));
//
//        projetService.save(new Projet("Mes bijoux en pâte fimo", LocalDate.now().plusDays(60), 6000, "http://p8.storage.canalblog.com/80/47/716062/68971538.jpg",
//                "Ma petite entreprise de pâte fimo", joelle, Statut.PUBLIE, loisirs_creatifs));
//        projetService.save(new Projet("Escape Game à Lustin !", LocalDate.now().plusDays(40), 8000, "https://nashvilleescapegame.com/wp-content/uploads/2017/06/Escape-Game-Adrenaline.jpg",
//                "Nouvel escape game à Lustin", sev, Statut.VALIDE, loisirs));
//        projetService.save(new Projet("Coaching de vie", LocalDate.now().plusDays(30), 2500, "http://reflexionsequestres.e.r.f.unblog.fr/files/2016/05/developpement-personnel.jpg",
//                "Développez votre vie avec du coaching", mary, Statut.ATTENTE_SUPPRESSION, dev_pero));
//        projetService.save(new Projet("Animaux hospi", LocalDate.now().plusDays(120), 15000, "http://www.vdmp.fr/medias/album/guitres9-1.jpg?fx=r_768_768",
//                "Visite des animaux en milieu hospitalier", joelle, Statut.ATTENTE_VALIDATION, dev_pero));
    }
}