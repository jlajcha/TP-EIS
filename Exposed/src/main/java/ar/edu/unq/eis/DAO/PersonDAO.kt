package ar.edu.unq.eis.DAO

interface PersonDAO {

    fun createPerson(givenName : String,
                     givenLastname : String,
                     givenDni : Int,
                     givenEmail : String) : Person

    fun updatePerson(person : Person)

    fun deletePerson(dni : Int)

    fun readPersonByLastname(lastname : String) : Person

    fun readPetsOf(dni : Int) : ArrayList<Pet>

    fun deletePetsOf(dni: Int)


}
