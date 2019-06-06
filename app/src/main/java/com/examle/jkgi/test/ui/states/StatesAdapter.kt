package com.examle.jkgi.test.ui.states

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.examle.api.rest.states.entity.ui.State
import com.examle.jkgi.test.R

class StatesAdapter(var statesList: List<State>, var stateListener: StateListener? = null) : RecyclerView.Adapter<StatesAdapter.StatesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StatesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_state, parent, false)
        return StatesViewHolder(view)
    }

    override fun getItemCount(): Int {
        return statesList.size
    }

    override fun onBindViewHolder(holder: StatesViewHolder, position: Int) {
        holder.bind(statesList[position])
    }

    inner class StatesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val abbr by lazy { itemView.findViewById<TextView>(R.id.abbr) }
        val stateName by lazy { itemView.findViewById<TextView>(R.id.stateName) }
        val capital by lazy { itemView.findViewById<TextView>(R.id.capital) }
        val largestCity by lazy { itemView.findViewById<TextView>(R.id.largestCity) }
        val id by lazy { itemView.findViewById<TextView>(R.id.id) }
        val itemRoot by lazy { itemView.findViewById<View>(R.id.itemRoot) }

        fun bind(state: State) {
            abbr.text = "${state.country}, ${state.abbr}"
            stateName.text = state.name
            capital.text = state.capital
            largestCity.text = state.largestCity
            id.text = state.id.toString()

            itemRoot.setOnClickListener { stateListener?.let { it.onItemClick(state) } }
        }
    }

    interface StateListener {
        fun onItemClick(state: State)
    }
}