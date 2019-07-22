package com.fusap.sanofi.ui.activities;


public class Navigation extends AppCompatActivity {


    protected void changeFragmentFromUseCase(Fragment fragment) {
        getFragmentManager().popBackStackImmediate(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        changeFragment(fragment,R.id.content_main,true);
    }

    public void changeFragment(Fragment fragmentToChange, int containerViewId, boolean stack) {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction()
                .replace(containerViewId, fragmentToChange);
        if(stack){
            fragmentTransaction.addToBackStack(null);
        }
        fragmentTransaction.commit();
    }

}
