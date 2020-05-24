package com.practice.home.springdatajpa.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceUnit;

public class DataAccessDao {
    @PersistenceUnit(unitName = "db1")
    EntityManager entityManager;
}
