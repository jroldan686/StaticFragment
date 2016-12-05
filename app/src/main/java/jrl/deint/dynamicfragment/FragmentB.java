package jrl.deint.dynamicfragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by usuario on 25/11/16.
 */

public class FragmentB extends Fragment {

    private TextView txvTextResult;
    public static final String TEXT_KEY = "text";
    public static final String SIZE_KEY = "size";
    public static final String TAG_FRAGMENT = "fragmentB";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Retain this fragment
        setRetainInstance(true);
    }

    public static FragmentB newInstance(Bundle arguments) {
        FragmentB fragmentB = new FragmentB();
        if(arguments!=null) {
            fragmentB.setArguments(arguments);
        }
        return fragmentB;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_a,container,false);
        if(rootView!=null) {
            txvTextResult = (TextView) rootView.findViewById(R.id.txvTextResult);
            Bundle bundle = getArguments();
            if (bundle != null) {
                txvTextResult.setText(bundle.getString(TEXT_KEY));
                txvTextResult.setTextSize(bundle.getFloat(SIZE_KEY));
            }
        }
        return rootView;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("text", txvTextResult.getText().toString());
        outState.putDouble("fontsize", txvTextResult.getTextSize()/getResources().getDisplayMetrics().density);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if(savedInstanceState != null) {
            String text = savedInstanceState.getString("text");
            int fontsize = (int)savedInstanceState.getDouble("fontsize");
        }
    }
}
