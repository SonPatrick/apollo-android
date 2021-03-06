package com.apollographql.apollo.kotlinsample.repositories

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.apollographql.apollo.kotlinsample.R
import com.apollographql.apollo.kotlinsample.fragment.RepositoryFragment
import kotlinx.android.synthetic.main.item_repository.view.*
import java.util.*

class RepositoriesAdapter(private val onClick: (RepositoryFragment) -> Unit) : RecyclerView.Adapter<RepositoriesAdapter.ViewHolder>() {

  private var data: List<RepositoryFragment> = ArrayList()

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    return ViewHolder(
      LayoutInflater.from(parent.context).inflate(R.layout.item_repository, parent, false)
    )
  }

  override fun getItemCount() = data.size

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    holder.bind(data[position], onClick)
  }

  fun setItems(data: List<RepositoryFragment>) {
    this.data = data
    notifyDataSetChanged()
  }

  class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(repositoryFragment: RepositoryFragment, onClick: (RepositoryFragment) -> Unit) {
      itemView.run {
        tvRepositoryName.text = repositoryFragment.name()
        if (repositoryFragment.description() == null) {
          tvRepositoryDescription.visibility = View.GONE
        } else {
          tvRepositoryDescription.text = repositoryFragment.description()
        }

        rootLayout.setOnClickListener {
          onClick(repositoryFragment)
        }
      }
    }
  }
}