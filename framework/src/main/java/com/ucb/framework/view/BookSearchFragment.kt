package com.ucb.framework.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.ucb.databinding.FragmentBookSearchBinding
import com.ucb.framework.viewmodel.BookSearchViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class BookSearchFragment : Fragment() {

    private var _binding: FragmentBookSearchBinding? = null
    private val binding get() = _binding!!

    private val viewModel: BookSearchViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentBookSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.searchButton.setOnClickListener {
            val query = binding.searchEditText.text.toString()
            if (query.isNotEmpty()) {
                viewModel.searchBooks(query)
            } else {
                Toast.makeText(requireContext(), "Ingrese un título", Toast.LENGTH_SHORT).show()
            }
        }

        // Observa los resultados de la búsqueda
        lifecycleScope.launchWhenStarted {
            viewModel.books.collectLatest { books ->
                // Aquí se debe actualizar el RecyclerView u otro componente de UI con la lista de libros
                adapter.submitList(books)
            }
        }

        // Ejemplo de implementar "me gusta" en el adaptador de la lista:
        adapter.setOnLikeClickListener { book -> viewModel.likeBook(book) }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
