package de.darmotek.rocketlabinfo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import de.darmotek.rocketlabinfo.Adapter.LaunchViewAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val launch1: LaunchData = LaunchData("It's a Test", "25.5.2017 0:30", "Mahia(NZ) - LC1");
        val launch2: LaunchData = LaunchData("Still Testing","21.1.2018 1:30","Mahia(NZ) - LC1");
        val launches = listOf(launch1,launch2);
        print(launches);

        val adapter = LaunchViewAdapter(this, launches,false);

        container?.adapter = adapter;
        adapter?.notifyDataSetChanged()


    }
}
