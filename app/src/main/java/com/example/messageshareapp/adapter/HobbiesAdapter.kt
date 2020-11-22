package com.example.messageshareapp.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.messageshareapp.models.Hobby
import com.example.messageshareapp.R
import com.example.messageshareapp.showToast
import kotlinx.android.synthetic.main.list_item.view.*

class HobbiesAdapter (val context: Context, private val Hobbies: List<Hobby> ): RecyclerView.Adapter<HobbiesAdapter.myViewHolder>() {

    inner class myViewHolder (itemView: View): RecyclerView.ViewHolder(itemView) {

        var currentHobby: Hobby? = null
        var currentPosition: Int = 0

        fun setData(hobby: Hobby?, pos: Int){
            hobby?.let {
                itemView.txvTittle.text = hobby.tittle
            }
         //itemView.txvTittle.text = hobby!!.tittle
            this.currentHobby = hobby
            this.currentPosition = pos

        }

        init {
            itemView.setOnClickListener {
                //context.showToast(currentHobby!!.tittle + getR)
                context.showToast(currentHobby!!.tittle+" Clicked !")
               // Toast.makeText(context, currentHobby!!.tittle+" Clicked !", Toast.LENGTH_SHORT).show()
            }

            itemView.imageShare.setOnClickListener {
                val message: String = "My Hobby is " + currentHobby!!.tittle
                    val intent = Intent()
                    intent.action = Intent.ACTION_SEND
                    intent.putExtra(Intent.EXTRA_TEXT, message)
                    intent.type = "Text/plain"

                  //  context.startActivity(Intent.createChooser(intent, "Share to: "))
                context.startActivity(Intent.createChooser(intent, "Share to: "))
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        return myViewHolder(view)

    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        val hobby = Hobbies[position]
        holder.setData(hobby, position)

    }

    override fun getItemCount(): Int {
        return Hobbies.size
    }
}