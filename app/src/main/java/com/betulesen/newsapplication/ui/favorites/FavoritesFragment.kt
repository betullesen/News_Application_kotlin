package com.betulesen.newsapplication.ui.favorites

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.betulesen.newsapplication.R
import com.betulesen.newsapplication.adapter.NewsAdapter
import com.betulesen.newsapplication.databinding.FragmentFavoritesBinding
import com.betulesen.newsapplication.ui.NewsActivity
import com.betulesen.newsapplication.ui.NewsViewModel
import com.google.android.material.snackbar.Snackbar

class FavoritesFragment : Fragment(R.layout.fragment_favorites) {

    private var _binding: FragmentFavoritesBinding? = null
    private val binding get() = _binding!!
    lateinit var newsViewModel: NewsViewModel
    lateinit var newsAdapter: NewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFavoritesBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        newsViewModel = (activity as NewsActivity).newsViewModel
        setupFavoritesRecycler()

        newsAdapter.setOnItemClickListener {
            val bundle = Bundle().apply {
                putSerializable("article",it)
            }
            findNavController().navigate(R.id.action_favoritesFragment_to_articleFragment,bundle)
        }

        val itemTouchHelperCallback = object  : ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP or ItemTouchHelper.DOWN,
            ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT){
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return true
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val possition = viewHolder.adapterPosition
                val article = newsAdapter.differ.currentList[possition]
                newsViewModel.deleteArticle(article)
                Snackbar.make(view,"Removed from favorites",Snackbar.LENGTH_LONG).apply {
                    setAction("Undo"){
                        newsViewModel.addToFavorites(article)
                    }
                    show()
                }
            }
        }

        ItemTouchHelper(itemTouchHelperCallback).apply {
            attachToRecyclerView(binding.favoritesRecyclerView)
        }

        newsViewModel.getFavoriteNews().observe(viewLifecycleOwner,{articles ->
            newsAdapter.differ.submitList(articles)
        })
    }

    private fun setupFavoritesRecycler(){
        newsAdapter = NewsAdapter()
        binding.favoritesRecyclerView.apply {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(activity)

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}