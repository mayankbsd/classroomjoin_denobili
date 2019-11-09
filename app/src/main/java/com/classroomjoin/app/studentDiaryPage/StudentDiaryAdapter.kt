package com.classroomjoin.app.studentDiaryPage


import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.classroomjoin.app.helper_utils.BaseRecyclerviewAdapter
import com.classroomjoin.app.helper_utils.DisplayItem
import com.hannesdorfmann.adapterdelegates3.AdapterDelegatesManager
import java.util.*


class StudentDiaryAdapter(var objects: List<DisplayItem>?=ArrayList<DisplayItem>(), context:Context,event_type:String) : BaseRecyclerviewAdapter<DisplayItem>(objects) {
    private val delegatesManager: AdapterDelegatesManager<List<DisplayItem>>

    init {
        delegatesManager = AdapterDelegatesManager<List<DisplayItem>>()
        delegatesManager.addDelegate(StudentDiaryAdapterDelegate(context,event_type))
        delegatesManager.addDelegate(StudentDiaryDateAdapterDelegate())
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
