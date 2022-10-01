package ch.applicationsec

import org.hibernate.SessionFactory
import javax.persistence.Persistence.createEntityManagerFactory

class PreventionMain {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            val entityFactory = createEntityManagerFactory("applicationSec")
            val sessionFactory = entityFactory.unwrap(SessionFactory::class.java)
            val lastname = "evil'; drop table students;--" // sql injection fails due to parameters binding protection
            val session =  sessionFactory.openSession()
            session.createQuery("select firstname from Student where lastname= :lastname" )
                          .setParameter("lastname", lastname)
                          .uniqueResult()
            session.close()
           }


    }
}