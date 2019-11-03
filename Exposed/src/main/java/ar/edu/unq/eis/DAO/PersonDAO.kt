package ar.edu.unq.eis.DAO

interface PersonDAO {

    fun createPerson(givenName : String,
                     givenLastname : String,
                     givenDni : Int,
                     givenEmail : String) : Person

    fun updatePerson(person : Person)

    fun deletePerson(dni : Int)

    fun readPersonsByLastname(lastname : String) : MutableCollection<Person>

    fun readPersonByDni(dni : Int) : Person

    fun readPetsOf(dni : Int) : ArrayList<Pet>

    fun deletePetsOf(dni: Int)


}
