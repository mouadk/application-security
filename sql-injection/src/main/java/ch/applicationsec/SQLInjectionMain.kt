package ch.applicationsec

import org.hibernate.SessionFactory
import org.hibernate.reactive.stage.Stage
import javax.persistence.Persistence

class SQLInjectionMain {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            val entityFactory = Persistence.createEntityManagerFactory("applicationSec")
            val sessionFactory = entityFactory.unwrap(SessionFactory::class.java)
            val userInput = "evil';drop table students;--"
            val session =  sessionFactory.openSession()
            session.createNativeQuery("select firstname from students where lastname='$userInput'" )
                    .uniqueResult()
            // it will never reach it due to exception - SQL Error: 0, SQLState: 0100E
            session.close()
        }

    }
}