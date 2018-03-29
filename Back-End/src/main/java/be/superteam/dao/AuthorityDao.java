package be.superteam.dao;

import be.superteam.model.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityDao extends JpaRepository<Authority, Long> {

    Authority findByAuthority(String authority);
}
