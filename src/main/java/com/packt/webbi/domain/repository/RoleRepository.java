package com.packt.webbi.domain.repository;

import com.packt.webbi.domain.Role;

public interface RoleRepository {

	Role findByName(String name);
}
