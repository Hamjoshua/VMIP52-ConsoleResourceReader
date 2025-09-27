package org.example
import kotlinx.cli.*
import org.example.entities.Resource
import org.example.validators.ValidationContext

fun main(args: Array<String>) {
    val parser = ArgParser("example")
    val login by parser.option(ArgType.String, shortName = "l", description = "User login")
    val password by parser.option(ArgType.String, shortName = "p", description = "User password")
    val resource by parser.option(ArgType.String, shortName = "r", description = "Path to resource")
    val action by parser.option(ArgType.String, shortName = "a", description = "Requested action")
    val volume by parser.option(ArgType.Int, shortName = "v", description = "Volume of used resource")
    parser.parse(args)

}
