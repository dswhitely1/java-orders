package com.lambdaschool.orders.dao;

import com.lambdaschool.orders.models.Agents;
import org.springframework.data.repository.CrudRepository;

public interface AgentsDao extends CrudRepository<Agents, Long>
{
}
