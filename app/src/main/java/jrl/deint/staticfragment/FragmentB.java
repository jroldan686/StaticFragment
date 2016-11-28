package jrl.deint.staticfragment;

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

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_a,container,false);
        if(rootView!=null) {
            txvTextResult = (TextView)rootView.findViewById(R.id.txvTextResult);
        }
        return rootView;
    }

    /**
     * Method which modifies the text and font size
     * @param text          The text to be displayed
     * @param size      The font size
     */
    public void changeTextPropierties(String text, int size) {
        txvTextResult.setText(text);
        txvTextResult.setTextSize(size);
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
            changeTextPropierties(text, fontsize);
        }
    }
}
