package com.panujaras

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.gson.*
import io.ktor.response.*
import io.ktor.request.*
import io.ktor.routing.*

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)


fun Application.module() {
    install(DefaultHeaders)
    install(CallLogging)

    install(ContentNegotiation) {
        gson {
        }
    }

    install(Routing) {
        get(path = "/api/sea/user"){
            val user= User(name="sea",age=50)
            call.respond(user)

        }
    }
}
data class User(
    var name:String? = null,
    var age:Int? = null,

)
