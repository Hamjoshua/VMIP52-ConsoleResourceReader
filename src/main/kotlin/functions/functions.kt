package org.example.functions

import java.security.MessageDigest
import java.util.Base64

fun hashPassword(password: String, salt: String) : String {
    val digest = MessageDigest.getInstance("SHA-256")
    val saltedPassword = password + salt
    val hash = digest.digest(saltedPassword.toByteArray())
    return Base64.getEncoder().encodeToString(hash)
}