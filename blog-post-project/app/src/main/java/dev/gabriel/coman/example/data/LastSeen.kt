package dev.gabriel.coman.example.data

data class LastSeen (val lastSeen: String) {
    companion object {
        val default = LastSeen(lastSeen = "")
    }
}