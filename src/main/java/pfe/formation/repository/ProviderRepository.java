package pfe.formation.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import pfe.formation.data.Provider;

import javax.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class ProviderRepository implements PanacheRepositoryBase<Provider,Integer> {
}
