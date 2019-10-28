package ar.edu.unq.eis.DAO

interface PetDAO {

    fun createPet(givenDNI : Int, givenName : String, givenNote : String) : Pet

    fun updatePet(pet : Pet)

    fun deletePet(code : Int)

    fun readPet(code : Int) : Pet
}