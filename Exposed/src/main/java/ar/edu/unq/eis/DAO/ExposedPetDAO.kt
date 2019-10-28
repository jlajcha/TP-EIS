package ar.edu.unq.eis.DAO

class ExposedPetDAO : PetDAO {

    override fun createPet(givenDNI: Int, givenName: String, givenNote: String): Pet {

        val pet = Pet.new {
            code = lastCode() + 1
            name = givenName
            note = givenNote
        }
        ExposedPersonDAO().assignPet(givenDNI, pet)
        return pet
    }

    override fun readPet(code: Int) : Pet{
        val tempPet = Pet.find { Pets.code eq code }
        return tempPet.first()
    }

    override fun updatePet(pet: Pet) {
        val persistedPet = this.readPet(pet.code)
        persistedPet.name = pet.name
        persistedPet.note = pet.note
    }

    override fun deletePet(code: Int) {
        this.readPet(code).delete()
    }
    fun lastCode(): Int{
        var max = 0;
        Pet.all().forEach { if (it.code > max) { max = it.code } }
        return max
    }

}