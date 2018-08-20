package com.packt.webstore.domain.repository;

import com.packt.webstore.domain.Role;

public interface RoleRepository {

	Role findByName(String name);
}
