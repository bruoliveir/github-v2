package bru.oliveir.playground

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import bru.oliveir.master.MasterFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .add(R.id.flContainer, MasterFragment())
            .commit()
    }
}