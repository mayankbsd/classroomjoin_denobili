package com.classroomjoin.app.socialGradeSelectionPage


import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.classroomjoin.app.helper_utils.BaseRecyclerviewAdapter
import com.classroomjoin.app.helper_utils.DisplayItem
import com.hannesdorfmann.adapterdelegates3.AdapterDelegatesManager
import java.util.*


class SocialGradesSelectionAdapter(listener: SocialListner,var objects: List<DisplayItem>?=ArrayList<DisplayItem>()) : BaseRecyclerviewAdapter<DisplayItem>(objects) {
    private val delegatesManager: AdapterDelegatesManager<List<DisplayItem>>

    init {
        delegatesManager = AdapterDelegatesManager<List<DisplayItem>>()
        delegatesManager.addDelegate(SocialGradeSelectionAdapterDelegate(listener))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return delegatesManager.onCreateViewHolder(parent, viewType)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        delegatesManager.onBindViewHolder(items, position, holder)
    }

    override fun getItemViewType(position: Int): Int {
        return delegatesManager.getItemViewType(items, position)
    }

    override fun addItems(clear: Boolean, mObjects: List<DisplayItem>) {
        super.addItems(clear, mObjects)
    }

}
