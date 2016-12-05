package jrl.deint.dynamicfragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;

/**
 * Created by usuario on 25/11/16.
 */

public class FragmentA extends Fragment {

    public static final String TAG_FRAGMENT = "fragmentA";

    private EditText edtText;
    private Button btnChangeText;
    private SeekBar skbTextSize;
    private FragmentIterationListener mCallback;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Retain this fragment
        setRetainInstance(true);
    }

    public interface FragmentIterationListener {
        void onFragmentIterationListener(String text, int size);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mCallback=(FragmentIterationListener)activity;

        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement FragmentIterationListener");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_a,container,false);
        if(rootView != null) {
            edtText = (EditText)rootView.findViewById(R.id.edtText);
            btnChangeText = (Button)rootView.findViewById(R.id.btnChangeText);
            btnChangeText.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mCallback.onFragmentIterationListener(edtText.getText().toString(), skbTextSize.getProgress());
                }
            });
            skbTextSize = (SeekBar)rootView.findViewById(R.id.skbTextSize);
        }
        return rootView;
    }
}
