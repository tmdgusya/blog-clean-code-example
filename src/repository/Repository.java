package repository;

public interface Repository<ID, Entity> {

    Entity save(Entity entity);

    Entity findById(ID id);

}
