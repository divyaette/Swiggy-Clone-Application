package org.demoproject.swiggyclone.repo;

import org.demoproject.swiggyclone.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuItemRepository extends JpaRepository<Menu, Integer> {

}
