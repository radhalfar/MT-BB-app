package cz.fai.utb.mt_bb_app.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import cz.fai.utb.mt_bb_app.MyApplication
import cz.fai.utb.mt_bb_app.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {

        val app = activity?.application as MyApplication
        val homeViewModel =
                ViewModelProvider(this, HomeViewModelFactory(app.repository)).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        homeViewModel.breakingBadQuote.observe(viewLifecycleOwner, { bbq ->
            // Update the UI with the new quote
            binding.textHome.text = bbq.quote + "\n- " + bbq.author
        })

        binding.viewModel = homeViewModel
        /*binding.lifecycleOwner = this*/

        /*val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }*/



        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*homeViewModel.getBBQuote()*/
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}