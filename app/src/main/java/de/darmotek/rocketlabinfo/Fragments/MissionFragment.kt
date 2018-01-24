package de.darmotek.rocketlabinfo.Fragments

import android.content.Context
import android.os.Bundle
import android.provider.CalendarContract
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import de.darmotek.rocketlabinfo.R

/**
 * Created by Admin on 24.01.2018.
 */
class MissionFragment : Fragment() {

    companion object {
        fun newInstance(): MissionFragment {
            return newInstance()
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)

    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?) : View? {
        return inflater?.inflate(R.layout.fragment_missions,container, false)
    }
}