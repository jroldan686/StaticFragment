package jrl.deint.dynamicfragment;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

public class Fragment_Activity extends Activity implements FragmentA.FragmentIterationListener {

    private FragmentA fragmentA;
    private FragmentB fragmentB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        FragmentManager fm = getFragmentManager();
        fragmentA = (FragmentA)fm.findFragmentByTag(FragmentA.TAG_FRAGMENT);
        if(fragmentA == null)
        {
            fragmentA = new FragmentA();
            getFragmentManager().beginTransaction().add(R.id.activity_fragment, fragmentA, FragmentA.TAG_FRAGMENT).commit();
        }
    }

    @Override
    public void onFragmentIterationListener(String text, int size) {
        Bundle bundle = new Bundle();
        bundle.putString(FragmentB.TEXT_KEY,text);
        bundle.putFloat(FragmentB.SIZE_KEY, size);
        fragmentB = FragmentB.newInstance(bundle);

        // FragmentA to FragmentB transaction stars
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.activity_fragment,fragmentB);

        // Save in the stack must be done before commit
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
