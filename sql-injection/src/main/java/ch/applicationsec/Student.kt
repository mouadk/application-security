package ch.applicationsec

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "students")
class Student(
        @Id
        @GeneratedValue
        val id: Long,
        val firstname: String,
        val lastname: String
){
        constructor(): this(-1, "", "")
}