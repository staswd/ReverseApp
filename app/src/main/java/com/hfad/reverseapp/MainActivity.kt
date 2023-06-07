package com.hfad.reverseapp

import android.R.attr.radius
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.shape.CornerFamily
import com.google.android.material.shape.MaterialShapeDrawable


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

//        val radius = getResources().getDimension(R.dimen.radius).toFloat()
        val toolbarBackground = toolbar.background as MaterialShapeDrawable
        toolbarBackground.shapeAppearanceModel = toolbarBackground.shapeAppearanceModel.toBuilder()
            .setBottomRightCorner(CornerFamily.ROUNDED, 50f)
            .setBottomLeftCorner(CornerFamily.ROUNDED, 50f).build()
    }
}