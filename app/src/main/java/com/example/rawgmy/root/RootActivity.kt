package com.example.rawgmy.root

import android.os.Bundle
import android.view.WindowManager
import com.example.rawgmy.R
import com.example.rawgmy.common.mvp.BaseActivity
import com.example.rawgmy.main.ui.BoardFragment
//import com.example.rawgmy.main.ui.ItemBoardFragment

class RootActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.clearFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        val boardFragment = BoardFragment()
        changeFragment(boardFragment, R.id.contentContainer)
    }
}