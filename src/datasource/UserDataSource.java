package datasource;

import model.User;

import java.util.HashMap;
import java.util.Map;

public class UserDataSource<Entity> {

    private final Map<Long, Entity> dataBase = new HashMap<>();
    private static UserDataSource INSTANCE = null;
    private Long autoKey = 0L;

    private UserDataSource() {}

    public static <Entity> UserDataSource<Entity> getInstance() {
        if (INSTANCE != null) {
            return INSTANCE;
        }
        INSTANCE = new UserDataSource<Entity>();
        return INSTANCE;
    }

    /**
     * 예시상 단순히 무조건 AUTO_INCREMENT 처럼 취급한다.
     * @param entity
     * @return entity
     */
    public Entity insert(Entity entity) {
        Entity savedEntity = dataBase.put(++autoKey, entity);
        return savedEntity;
    }

    public Entity findEntity(Long id) {
        return dataBase.get(id);
    }

}
