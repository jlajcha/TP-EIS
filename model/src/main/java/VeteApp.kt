import ar.edu.unq.eis.DAO.*
import org.jetbrains.exposed.exceptions.ExposedSQLException
import org.jetbrains.exposed.sql.transactions.transaction
import java.lang.Exception
import com.fasterxml.jackson.annotation.JsonIgnore

import Pet

object VeteApp {
    val db = ConnectionBlock()
    val personDAO : PersonDAO = ExposedPersonDAO()
    val petDao: PetDAO = ExposedPetDAO()

    fun createClient(dni:Int,
                     name:String,
                     lastname:String,
                     address:String,
                     email:String,
                     telephone:String): Client {

        try {
            transaction {
                personDAO.createPerson(name, lastname, dni, email)
            }
        }catch (e : Exception){
            throw (e as ExposedSQLException)
        }
        return Client(name, lastname,address, email, telephone, dni)
    }
    fun createPet(name:String,ownerDni:Int,notes:String):Pet{

        try {
            transaction {
                petDao.createPet(ownerDni,name, notes)

            }
        }catch (e : Exception){
            throw (e as ExposedSQLException)
        }

        return  Pet(name,ownerDni,notes)


    }

    fun getOwnersPets(ownerDni: Int): ArrayList<Pet>{
        var pets: ArrayList<Pet> = arrayListOf<Pet>()
        try {
            transaction {
                pets = (personDAO.readPetsOf(ownerDni)) as ArrayList<Pet>

            }
        }catch (e : Exception){
            throw (e as ExposedSQLException)
        }

        return  pets
    }
}
