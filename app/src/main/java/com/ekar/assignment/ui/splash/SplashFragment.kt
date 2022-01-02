package com.ekar.assignment.ui.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.painterResource
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.ekar.assignment.R
import dagger.hilt.android.AndroidEntryPoint

/**
 * @author yusuf.onder
 * Created on 2.01.2022
 */
@AndroidEntryPoint
class SplashFragment : Fragment() {

    private val viewModel: SplashViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                MainContent()
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeViewModel()
    }

    private fun observeViewModel() = with(viewModel) {
        lifecycleScope.launchWhenStarted {
            navigationEvent
                .collect { event ->
                    when (event) {
                        SplashEvent.NavigateToHome -> {
                            navigateToMap()
                        }
                    }
                }
        }
    }

    private fun navigateToMap() {
        findNavController().navigate(R.id.action_splash_to_map)
    }

    @Composable
    fun MainContent() {
        Image(
            painter = painterResource(R.drawable.ekar_logo),
            contentDescription = getString(R.string.app_name),
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
    }

}