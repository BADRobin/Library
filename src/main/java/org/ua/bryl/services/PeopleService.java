package org.ua.bryl.services;

import org.ua.bryl.model.People;

import java.util.List;
/**
 * Created by olegbryl 13/08/2018.
 */

public interface PeopleService {

    void addPeople(People people);

    People getPeopleById(int people_id);

    List<People> getAllPeoples();

    People getPeopleByUsername(String people_username);

}
