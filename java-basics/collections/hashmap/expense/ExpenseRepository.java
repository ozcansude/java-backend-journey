package hashmap.expense;

import repository.InMemoryRepository;


import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class ExpenseRepository implements InMemoryRepository<Expense,Integer>{

    private final Map<Integer, Expense> map = new HashMap<>();


    @Override
    public void save(Expense entity) {
        map.put(entity.getId(),entity);
    }

    @Override
    public Expense findById(Integer integer) {
        return map.get(integer);
    }

    @Override
    public List<Expense> findAll() {
        return new ArrayList<>(map.values());
    }

    @Override
    public boolean deleteById(Integer integer) {
        Expense deleted = map.remove(integer);
        if(deleted != null){
            return true;
        }
        return false;
    }

    @Override
    public boolean update(Integer integer, Expense entity) {

        if(map.containsKey(integer)){
            map.put(integer,entity);
            return true;
        }
        return false;
    }
}
