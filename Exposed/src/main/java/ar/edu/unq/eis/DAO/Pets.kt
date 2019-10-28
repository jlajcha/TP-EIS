package ar.edu.unq.eis.DAO

import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.IntIdTable
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table

object Pets : IntIdTable() {
    val code: Column<Int> = integer("code").uniqueIndex().primaryKey()
    var name: Column<String> = varchar("name", 50)
    var note: Column<String> = varchar("note", 250)
}

class Pet(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<Pet>(Pets)

    var code by Pets.code
    var name by Pets.name
    var note by Pets.note
}

object PetsOfs : Table() {
    val pet = reference("pet", Pets).primaryKey(0)
    val person = reference("person", Persons).primaryKey(1)
}

