package ch.applicationsec

import org.hibernate.SessionFactory
import org.hibernate.reactive.stage.Stage
import javax.persistence.Persistence

class HQLInjectionMain {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            val entityFactory = Persistence.createEntityManagerFactory("applicationSec")
            val sessionFactory = entityFactory.unwrap(SessionFactory::class.java)
            val session =  sessionFactory.openSession()

            // Even though HQL is more restrictive than SQL for injections, it can still be exploited if badly used.
            // cf https://blog.h3xstream.com/2014/02/hql-for-pentesters.html
            // hql injection

            val userInput = "whatever'OR '1'='1"
            val res = session
                    .createQuery("from Student where lastname='$userInput'" )
                    .resultList
            print((res[0] as Student).lastname) // whatever != toto
            session.close()
            }

    }
}