package org.ua.bryl.services.implementation;

import org.ua.bryl.dao.Dao_People;
import org.ua.bryl.model.People;
import org.ua.bryl.services.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * Created by olegbryl 13/08/2018.
 */
@Service
public class PeopleServiceImp implements PeopleService {

    @Autowired
    Dao_People dao_people;

    public List<People> getAllPeoples() {
        return dao_people.getAllPeoples();
    }

    public People getPeopleById(int people_id) {
        return dao_people.getPeopleById(people_id);
    }

    public void addPeople(People people) {
         dao_people.addPeople(people);
    }

    public People getPeopleByUsername(String people_username) {
        return dao_people.getPeopleByUsername(people_username);
    }
}
