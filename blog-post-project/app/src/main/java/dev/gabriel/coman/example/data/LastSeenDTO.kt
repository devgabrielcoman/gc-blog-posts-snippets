package dev.gabriel.coman.example.data

data class LastSeenDTO (val lastSeen: String): DTO {
    companion object {
        val default = LastSeenDTO(lastSeen = "")
    }
}