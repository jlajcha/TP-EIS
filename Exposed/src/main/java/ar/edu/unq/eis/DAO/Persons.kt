package ar.edu.unq.eis.DAO

import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.IntIdTable
import org.jetbrains.exposed.sql.Column

object Persons : IntIdTable() {
    val dni: Column<Int> = integer("dni").uniqueIndex().primaryKey()
    var name: Column<String> = varchar("name", 50)
    var lastname: Column<String> = varchar("lastname", 50)
    var email: Column<String> = varchar("email", 50)
    var telephone: Column<Int> = integer("telephone")
}

class Person(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<Person>(Persons)

    var dni by Persons.dni
    var name by Persons.name
    var lastname by Persons.lastname
    var email by Persons.email
    var telephone by Persons.telephone

    var pets by Pet via PetsOfs
}