package android.eservices.staticfragmenttabs;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.appcompat.widget.ContentFrameLayout;
import androidx.fragment.app.Fragment;

//TODO : fix this fragment so it works :)
//Once it's done, then create a second fragment with the other layout
public class FragmentOne extends Fragment {

    public static final String TAB_NAME = "ADD TO COUNTER";
    private CounterInterface counterInterface;
    private View rootView;

    public FragmentOne() {
        //TODO
    }

    public static FragmentOne newInstance() {
        return new FragmentOne();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_one, container, false);
        return rootView;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        setupCounterButton();
    }

    //TODO add listener to button and transmit the information to parent Activity

    private void setupCounterButton(){
        Button incrementButton = rootView.findViewById(R.id.button_increment);
        incrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(counterInterface != null){
                    counterInterface.incrementCounter();
                }
            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof CounterInterface){
            this.counterInterface = (CounterInterface) context;
        }
    }
}
