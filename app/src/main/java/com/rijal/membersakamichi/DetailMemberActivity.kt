package com.rijal.membersakamichi

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import androidx.core.app.NavUtils
import com.rijal.membersakamichi.databinding.ActivityDetailMemberBinding

class DetailMemberActivity : AppCompatActivity() {
    private lateinit var detailMemberBinding: ActivityDetailMemberBinding
    companion object {
        const val INTENT_EXTRA = "detail_member"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailMemberBinding = ActivityDetailMemberBinding.inflate(layoutInflater)
        Log.d("LOADED", detailMemberBinding.root.toString())
        setContentView(detailMemberBinding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val member: MemberSaka? = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<MemberSaka>(INTENT_EXTRA, MemberSaka::class.java)
        } else {
            intent.getParcelableExtra<MemberSaka>(INTENT_EXTRA)
        }
        if (member != null) {
            supportActionBar?.title = member.name
            detailMemberBinding.imgMemberDetail.setImageResource(member.image)
            detailMemberBinding.imgThumbMember.setImageResource(member.image)
            detailMemberBinding.txtNamaMemberDetail.text = member.name
            detailMemberBinding.txtSecondMemberDetail.text = "${member.getGroup()} - ${member.getGeneration()}"
            detailMemberBinding.txtDescMemberDetail.text = member.desc
            if (member.isGraduated) {
                detailMemberBinding.txtGraduatedMemberDetail.text = "Graduated"
            } else {
                detailMemberBinding.txtGraduatedMemberDetail.text = ""
            }
            detailMemberBinding.btnShare.setOnClickListener {
                val sendIntent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT, """
                        ${member.name}
                        ${member.getGroup()} - ${member.getGeneration()} ${if (member.isGraduated) "(Graduated)" else ""}
                        
                        
                        ${member.desc}
                    """.trimIndent())
                    type = "text/plain"
                }
                val shareIntent = Intent.createChooser(sendIntent, null)
                startActivity(shareIntent)
            }
        } else {
            Log.d("MEMBER", "null")
            finish()
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            android.R.id.home -> NavUtils.navigateUpFromSameTask(this)
        }
        return super.onOptionsItemSelected(item)
    }
}