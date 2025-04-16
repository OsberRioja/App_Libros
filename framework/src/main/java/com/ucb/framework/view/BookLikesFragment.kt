package com.ucb.framework.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.ucb.databinding.FragmentBookLikesBinding
import com.ucb.framework.viewmodel.BookLikesViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class BookLikesFragment : Fragment() {

    private var _binding: FragmentBookLikesBinding? = null
    private val binding get() = _binding!!

    private val viewModel: BookLikesViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentBookLikesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.loadLikedBooks()

        lifecycleScope.launchWhenStarted {
            viewModel.likedBooks.collectLatest { books ->
                // Actualiza el RecyclerView o componente de UI con la lista de libros guardados.
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
