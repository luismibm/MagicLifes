package com.example.magiclifes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.magiclifes.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private var lifeP1: Int = 0
    private var poisonP1: Int = 0
    private var lifeP2: Int = 0
    private var poisonP2: Int = 0



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifeP1 = 20
        poisonP1 = 0
        lifeP2 = 20
        poisonP2 = 0

        if (savedInstanceState != null) {
            lifeP1 = savedInstanceState.getInt("lifeP1")
            poisonP1 = savedInstanceState.getInt("poisonP1")
            refresh()
        }


        // Player 1 Button Functionality
        binding.buttonP1LifeIncrement.setOnClickListener {
            lifeP1++
            refresh()
        }

        binding.buttonP1LifeDecrement.setOnClickListener {
            if (lifeP1 > 0)
                lifeP1--
            refresh()
        }

        binding.buttonP1PoisonIncrement.setOnClickListener {
            poisonP1++
            refresh()
        }

        binding.buttonP1PoisonDecrement.setOnClickListener {
            if (poisonP1 > 0)
                poisonP1--
            refresh()
        }


        // Player 2 Button Functionality
        binding.buttonP2LifeIncrement.setOnClickListener {
            lifeP2++
            refresh()
        }

        binding.buttonP2LifeDecrement.setOnClickListener {
            if (lifeP2 > 0)
                lifeP2--
            refresh()
        }

        binding.buttonP2PoisonIncrement.setOnClickListener {
            poisonP2++
            refresh()
        }

        binding.buttonP2PoisonDecrement.setOnClickListener {
            if (poisonP2 > 0)
                poisonP2--
            refresh()
        }


        // Middle Buttons
        binding.PassFromP2ToP1.setOnClickListener {
            if (lifeP2 > 0) {
                lifeP2--
                lifeP1++
                refresh()
            }
        }

        binding.PassFromP1ToP2.setOnClickListener {
            if (lifeP1 > 0) {
                lifeP1--
                lifeP2++
                refresh()
            }
        }

    }

    fun refresh() {
        binding.CounterP1.text = "$lifeP1/$poisonP1"
        binding.CounterP2.text = "$lifeP2/$poisonP2"
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt("lifeP1", lifeP1)
        super.onSaveInstanceState(outState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}