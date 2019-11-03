class Client (var name:String,
              var surnanme: String,
              var address: String,
              var email: String,
              var telephone: String,
              var dni: String) {
    var pets: MutableCollection<Pet> = mutableListOf()
    companion object {
        @JvmStatic fun main(args: Array<String>) { }

    }

}