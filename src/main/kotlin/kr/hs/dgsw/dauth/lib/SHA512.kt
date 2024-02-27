package kr.hs.dgsw.dauth.lib

import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

class SHA512 {

    companion object {
        private const val ALGORITHM = "SHA-512"
    }

    fun hashing(input: String): String {

        return try {

            MessageDigest.getInstance(ALGORITHM)
                .digest(input.toByteArray())
                .joinToString("") { "%02x".format(it) }

        } catch (e: NoSuchAlgorithmException) {
            e.printStackTrace()
            ""
        }
    }

}