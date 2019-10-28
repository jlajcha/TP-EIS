import ar.edu.unq.eis.DAO.*
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import org.junit.Test


class ExposedTest {

    val db = ConnectionBlock()
    val personDAO : PersonDAO = ExposedPersonDAO()
    val petDAO : PetDAO = ExposedPetDAO()

    @Test
    fun firstTryConnectionWithMySQL(){

        transaction {

            SchemaUtils.create(Persons)
            SchemaUtils.create(Pets)
            SchemaUtils.create(PetsOfs)

            //personDAO.createPerson("Pepe","Argento",24543234,"@")
            petDAO.createPet(24543234,"Bruno", "Cabezon")
        }
    }
}