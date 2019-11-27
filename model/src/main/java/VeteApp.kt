import ar.edu.unq.eis.DAO.*
import org.jetbrains.exposed.exceptions.ExposedSQLException
import org.jetbrains.exposed.sql.transactions.transaction
import java.lang.Exception

object VeteApp {
    val db = ConnectionBlock()
    val personDAO : PersonDAO = ExposedPersonDAO()
    val petDao: PetDAO = ExposedPetDAO()

    fun createClient(dni:Int,
                     name:String,
                     lastname:String,
                     address:String,
                     email:String,
                     telephone:String) {

        try {
            transaction {
                personDAO.createPerson(name, lastname, dni, address, email, telephone)
            }
        }catch (e : Exception){
            throw (e as ExposedSQLException)
        }
    }
    fun createPet(name:String,ownerDni:Int,notes:String){

        try {
            transaction {
                petDao.createPet(ownerDni,name, notes)
            }
        }catch (e : Exception){
            throw (e as ExposedSQLException)
        }
    }
    fun getClientById(ownerDni: Int) : Client{
        try {
            return transaction {
                val daoClient = personDAO.readPersonByDni(ownerDni)

                return@transaction Client(daoClient.name,
                                          daoClient.lastname,
                                          daoClient.address,
                                          daoClient.email,
                                          daoClient.telephone,
                                          daoClient.dni)}
        }catch (e : Exception){
            throw (e as ExposedSQLException)
        }
    }

    fun getOwnersPets(ownerDni: Int): ArrayList<Pet>{
        try {
            return transaction {
                val daoPets = personDAO.readPetsOf(ownerDni)
                val pets = ArrayList<Pet>()

                daoPets.forEach { pets.add(Pet(it.code, it.name, it.note)) }
                return@transaction pets
            }
        }catch (e : Exception){
            throw (e as ExposedSQLException)
        }

    }
    fun getSearchedClientsByName(name: String): ArrayList<Client> {
        try {
            return transaction {
                val daoClients = personDAO.readPersonsByLastname(name)
                val clients = ArrayList<Client>()

                daoClients.forEach { clients.add(Client(it.name, it.lastname, it.address, it.email, it.telephone, it.dni)) }
                return@transaction clients
            }
        }catch(e : Exception) {
            throw (e as ExposedSQLException)
        }
    }
}
