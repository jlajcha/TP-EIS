package ar.edu.unq.eis.DAO

import org.jetbrains.exposed.sql.Database

class ConnectionBlock {

    val db = Database.connect("jdbc:mysql://localhost:3306/veterinaria", driver = "com.mysql.cj.jdbc.Driver",
            user = "mariano", password = "1234")

    public fun getDatabase(): Database {
        return this.db
    }
}

