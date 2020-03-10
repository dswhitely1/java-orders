package com.lambdaschool.orders.services;

import com.lambdaschool.orders.models.Agents;

import java.util.List;

public interface AgentsService
{
    List<Agents> findAll();
    Agents findById(long id);
    Agents save(Agents agent);
    Agents update(Agents agent, long id);
    Agents delete(long id);
}
