package com.rijal.membersakamichi

data class MemberSaka(
    val name: String,
    val generation: Int,
    val group: Group,
    val isGraduated: Boolean = false
) {
    fun getGeneration(): String {
        return when(generation) {
            1 -> "1st Generation"
            2 -> "2nd Generation"
            3 -> "3rd Generation"
            else -> "${generation}th Generation"
        }
    }
    fun getGroup(): String {
        return when(group) {
            Group.NOGIZAKA46 -> "Nogizaka46"
            Group.SAKURAZAKA46 -> "Sakurazaka46"
            Group.HINATAZAKA46 -> "Hinatazaka46"
        }
    }
}
