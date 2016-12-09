package mywebapp.repository;

import java.util.List;

import mywebapp.entity.Role;

public interface RoleRepository{
	List<Role> findAll();
}
