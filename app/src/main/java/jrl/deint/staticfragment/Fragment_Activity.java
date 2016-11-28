package jrl.deint.staticfragment;

import android.app.Activity;
import android.os.Bundle;

public class Fragment_Activity extends Activity implements FragmentA.FragmentIterationListener {

    private FragmentB fragmentB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        fragmentB = (FragmentB)getFragmentManager().findFragmentById(R.id.fragment_b);
    }

    @Override
    public void onFragmentIterationListener(String text, int size) {

    }
}
