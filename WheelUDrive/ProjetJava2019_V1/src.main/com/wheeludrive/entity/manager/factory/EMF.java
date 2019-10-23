package com.wheeludrive.entity.manager.factory;

import static org.eclipse.persistence.config.PersistenceUnitProperties.*;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.wheeludrive.domain.PropertiesManager;
import com.wheeludrive.exception.PropertyException;

/**
* Class to get a connection to the database
*
* @author Renaud DIANA & Simon-Pierre NKIZAMACUMU
*/
public final class EMF {

    private static EntityManagerFactory emfInstance;

    private EMF() {
    }

    private static EntityManagerFactory getInstanceFactory() throws PropertyException {

        if (emfInstance == null) {

            Map<String, String> map = new HashMap<>();
            PropertiesManager prop = new PropertiesManager();
            
            String url = "jdbc:mysql://"+prop.getServer()+":"+prop.getPort()+"/wheeludrive";

            map.put(JDBC_URL, url);
            map.put(JDBC_USER, prop.getUser());
            map.put(JDBC_PASSWORD, prop.getPassword());

            emfInstance = Persistence.createEntityManagerFactory("wheeludrive",map);

            return emfInstance;
        }

        return emfInstance;
    }

    public static EntityManagerFactory getEMF() throws PropertyException {
        return getInstanceFactory();
    }

    public static EntityManager getEM() throws PropertyException {

        return getInstanceFactory().createEntityManager();
    }

    /*
     * Create EntityManager in others classes EntityManager em =
     * EMF.get().createEntityManager(); try { // ... do stuff with em ... } finally
     * { em.close(); }
     */
}