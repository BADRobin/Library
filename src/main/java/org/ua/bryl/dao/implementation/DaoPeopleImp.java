package org.ua.bryl.dao.implementation;

import org.ua.bryl.dao.Dao_People;
import org.ua.bryl.model.Authorities;
import org.ua.bryl.model.People;
import org.ua.bryl.model.Users;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
/**
 * Created by olegbryl 01/08/2018.
 */

@Repository
@Transactional
public class DaoPeopleImp implements Dao_People {

    @Autowired
    private SessionFactory sessionFactory;

    public void addPeople(People people) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(people);


        Users newUser = new Users();
        newUser.setUsername(people.getPeople_username());
        newUser.setPassword(people.getPeople_password());
        newUser.setEnabled(true);
        newUser.setPeople_id(people.getPeople_id());

        Authorities newAuthorities = new Authorities();
        newAuthorities.setUsername(people.getPeople_username());
        newAuthorities.setAuthority("ROLE_USER");

        session.saveOrUpdate(newUser);
        session.saveOrUpdate(newAuthorities);



        session.saveOrUpdate(people);


        session.flush();
    }

    public People getPeopleByUsername(String username) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from People where people_username = ?");
        query.setString(0, username);

        return (People) query.uniqueResult();
    }

    public People getPeopleById(int people_id){
        Session session = sessionFactory.getCurrentSession();

        return (People) session.get(People.class, people_id);
    }

    public List<People> getAllPeoples(){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from People");

        return (List<People>) query.list();
    }



}
