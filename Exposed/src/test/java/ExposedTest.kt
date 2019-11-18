import ar.edu.unq.eis.DAO.*
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import org.junit.Test
import kotlin.test.assertEquals

class ExposedTest {

    val db = ConnectionBlock()
    val personDAO : PersonDAO = ExposedPersonDAO()
    val petDAO : PetDAO = ExposedPetDAO()

    @Test
    fun firstTryConnectionWithMySQL(){

        transaction {
            SchemaUtils.drop(PetsOfs)
            SchemaUtils.drop(Persons)
            SchemaUtils.drop(Pets)

            SchemaUtils.create(Persons)
            SchemaUtils.create(Pets)
            SchemaUtils.create(PetsOfs)

            personDAO.createPerson("Pepe","Argento",24543234,"Siempre Viva 123", "pepe@pepelandia.com.ar", "4444-4444")
            petDAO.createPet(24543234,"Bruno", "Cabezon")
        }
    }
    @Test
    fun createAPersonAndFindItByHisDni(){
        transaction {
            SchemaUtils.drop(PetsOfs)
            SchemaUtils.drop(Persons)
            SchemaUtils.drop(Pets)

            SchemaUtils.create(Persons)
            SchemaUtils.create(Pets)
            SchemaUtils.create(PetsOfs)

            personDAO.createPerson("Pepe","Argento",24543234,"Siempre Viva 123", "pepe@pepelandia.com.ar", "4")
            assertEquals(24543234, personDAO.readPersonByDni(24543234).dni)
        }
    }

    @Test
    fun createFivePersonsWithSimilarLastNamesAndNamesAndSeeIfTheAmountOfPersonsFoundIsAsSpected(){
        transaction {
            SchemaUtils.drop(PetsOfs)
            SchemaUtils.drop(Persons)
            SchemaUtils.drop(Pets)

            SchemaUtils.create(Persons)
            SchemaUtils.create(Pets)
            SchemaUtils.create(PetsOfs)

            personDAO.createPerson("Paul", "Cranst", 30000000, "aaron@gmail.com", "@", "4")
            personDAO.createPerson("Bryan", "Cranston", 20000000, "cranstonMeth@gmail.com", "@", "4")
            personDAO.createPerson("Bob", "Cran", 20000002, "saulgoodman@gmail.com", "@", "4")
            personDAO.createPerson("Anna", "Cranist", 22000000, "annaGun@gmail.com", "@", "4")
            personDAO.createPerson("Cranic", "Norris", 20000001, "deanNorris@gmail.com", "@", "4")

            assertEquals(5, personDAO.readPersonsByLastname("Cran").size)
        }
    }
    @Test
    fun createFivePersonsWithDifferentLastNamesAndFindTheOneThatMatchesCriteria(){
        transaction {
            SchemaUtils.drop(PetsOfs)
            SchemaUtils.drop(Persons)
            SchemaUtils.drop(Pets)

            SchemaUtils.create(Persons)
            SchemaUtils.create(Pets)
            SchemaUtils.create(PetsOfs)

            personDAO.createPerson("Paul", "Aaron", 30000000, "aaron@gmail.com", "@", "4")
            personDAO.createPerson("Bryan", "Cranston", 20000000, "cranstonMeth@gmail.com", "@", "4")
            personDAO.createPerson("Bob", "Odenkirk", 20000002, "saulgoodman@gmail.com", "@", "4")
            personDAO.createPerson("Anna", "Gunn", 22000000, "annaGun@gmail.com", "@", "4")
            personDAO.createPerson("Dean", "Norris", 20000001, "deanNorris@gmail.com", "@", "4")

            assertEquals("Bob", personDAO.readPersonsByLastname("Bob").first().name)
        }
    }
    @Test
    fun readPetsOf(){
        transaction {
            personDAO.readPetsOf(24543234).forEach { println(it.code) }
        }
    }

}