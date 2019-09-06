package com.example.test_mvvm_git.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.test_mvvm_git.R
import com.example.test_mvvm_git.service.model.Project
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

class MainActivity : AppCompatActivity(), HasSupportFragmentInjector {

    @Inject
    val dispatchingAndroidInject: DispatchingAndroidInjector<Fragment>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            val fragment = ProjectListFragment()

            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, fragment, ProjectListFragment.TAG).commit()
        }
    }

    fun show(project: Project) {
        val projectFragment = ProjectFragment.for
    }

}
