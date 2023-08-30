package com.rijal.membersakamichi

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MemberSaka(
    val name: String,
    val generation: Int,
    val group: Group,
    val image: Int,
    val desc: String,
    val isGraduated: Boolean = false,
) : Parcelable {
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
