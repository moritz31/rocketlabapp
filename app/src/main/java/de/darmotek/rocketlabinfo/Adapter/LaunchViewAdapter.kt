package de.darmotek.rocketlabinfo.Adapter

import android.app.Activity
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import de.darmotek.rocketlabinfo.LaunchData
import de.darmotek.rocketlabinfo.R
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

/**
 * Created by moritz on 23.01.18.
 */

class LaunchViewAdapter(private var activity: Activity, private var items: List<LaunchData>): BaseAdapter() {

    private class ViewHolder(row: View?) {
        var missionName: TextView? = null
        var missionDate: TextView? = null
        var missionLocation: TextView? = null

        init {
            this.missionName = row?.findViewById<TextView>(R.id.name)
            this.missionDate = row?.findViewById<TextView>(R.id.datetime)
            this.missionLocation = row?.findViewById<TextView>(R.id.location)
        }
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View?
        val viewHolder: ViewHolder
        if (convertView == null) {
            val inflater = activity?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            view = inflater.inflate(R.layout.launch_item, null)
            viewHolder = ViewHolder(view)
            view?.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        var launch = items[position]
        viewHolder.missionName?.text = launch.name

        val simpleDateFormat = SimpleDateFormat("dd.MM.yyyy HH:mm")
        Log.d("SimpleDate",simpleDateFormat.toString())
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"))
        Log.d("SimpleDate",simpleDateFormat.toString())
        val myDate = simpleDateFormat.parse(launch.datetime)
        val formatter = SimpleDateFormat("dd.MM.yyyy, HH:mm (z)")
        val formattedDate = formatter.format(myDate)
        Log.d("SimpleDate",formattedDate.toString())
        viewHolder.missionDate?.text = formattedDate.toString()
        viewHolder.missionLocation?.text = launch.location

        return view as View
    }

    override fun getItem(i: Int): LaunchData {
        return items[i]
    }

    override fun getItemId(i: Int): Long {
        return i.toLong()
    }

    override fun getCount(): Int {
        return items.size
    }
}