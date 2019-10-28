package ar.edu.unq.eis.DAO

import org.jetbrains.exposed.sql.SizedCollection
import org.jetbrains.exposed.sql.transactions.transaction

class ExposedPersonDAO : PersonDAO {

    val petDAO : PetDAO = ExposedPetDAO()

    override fun createPerson(givenName : String,
                              givenLastname : String,
                              givenDni : Int,
                              givenEmail : String) : Person{

        val person = Person.new {
            dni = givenDni
            name = givenName
            lastname = givenLastname
            email = givenEmail
            telephone = 4
        }
        return person
    }
    override fun updatePerson(person : Person){
        val persistedPerson = this.readPersonByDni(person.dni)
        persistedPerson.email = person.email
        persistedPerson.lastname = person.lastname
        persistedPerson.name = person.name
        persistedPerson.telephone = person.telephone
    }
    override fun deletePerson(dni : Int){
        this.readPersonByDni(dni).delete()
        this.deletePetsOf(dni)
    }
    override fun readPersonByLastname(lastname : String) : Person{
        val tempPerson = Person.find { Persons.lastname eq lastname }
        return tempPerson.first()
    }

    fun readPersonByDni(dni : Int) : Person{
        val tempPerson = Person.find { Persons.dni eq dni }
        return tempPerson.first()
    }

    override fun deletePetsOf(dni: Int) {
        readPersonByDni(dni).pets.forEach { petDAO.deletePet(it.code) }
    }

    override fun readPetsOf(dni: Int): ArrayList<Pet> {
        var pets = ArrayList<Pet>()
        readPersonByDni(dni).pets.forEach { pets.add(it) }
        return pets
    }
    fun assignPet(dni : Int, pet : Pet){
        transaction {
            var petsCollection = readPersonByDni(dni).pets.toMutableList()
            petsCollection.add(pet)
            readPersonByDni(dni).pets = SizedCollection(petsCollection)       }
    }
}