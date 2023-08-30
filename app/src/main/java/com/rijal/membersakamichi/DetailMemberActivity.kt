package com.rijal.membersakamichi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rijal.membersakamichi.databinding.ActivityDetailMemberBinding

class DetailMemberActivity : AppCompatActivity() {
    private lateinit var detailMemberBinding: ActivityDetailMemberBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailMemberBinding = ActivityDetailMemberBinding.inflate(layoutInflater)
        setContentView(detailMemberBinding.root)
    }
}