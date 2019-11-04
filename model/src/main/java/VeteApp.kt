import ar.edu.unq.eis.DAO.ConnectionBlock
import ar.edu.unq.eis.DAO.ExposedPersonDAO
import ar.edu.unq.eis.DAO.PersonDAO
import org.jetbrains.exposed.exceptions.ExposedSQLException
import org.jetbrains.exposed.sql.transactions.transaction
import java.lang.Exception

object VeteApp {
    val db = ConnectionBlock()
    val personDAO : PersonDAO = ExposedPersonDAO()

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
}